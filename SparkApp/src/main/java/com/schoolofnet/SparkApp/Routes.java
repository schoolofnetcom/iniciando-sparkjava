package com.schoolofnet.SparkApp;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;
import com.schoolofnet.SparkApp.beans.Contact;
import com.schoolofnet.SparkApp.services.ContactService;
import com.schoolofnet.SparkApp.services.ContactServiceImpl;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Routes {
	
	private static ContactService contactService = new ContactServiceImpl();
	
	public static void setRoutes() {
		get("/template", (request, response) -> {
			Map<String, Object> model = new HashMap<>();
			
			model.put("message", "Hello from Spark using Handlebars");
			
			return new ModelAndView(model, "index.hbs");
		}, new HandlebarsTemplateEngine());
		
		path("/api", () -> {
			get("/contacts", (request, response) -> {
				return new Gson().toJson(contactService.getContacts());
			});
			get("/contacts/:id", (request, response) -> {
				return new Gson().toJson(contactService.getContact(request.params(":id")));
			});
			post("/contacts", (request, response) -> {
				Contact contact = new Gson().fromJson(request.body(), Contact.class);
				
				contact.setId(UUID.randomUUID().toString());
				
				contactService.insertContact(contact);
				return new Gson().toJson(contact);
			});
			put("/contacts/:id", (request, response) ->  {
				Contact contact = new Gson().fromJson(request.body(), Contact.class);
				
				contact.setId(request.params(":id"));
				
				Contact contactEdited = contactService.editContact(contact);
				
				if (contactEdited != null) {
					return new Gson().toJson(contactEdited);
				}
				
				return new Gson().toJson(null);
			});
			delete("/contacts/:id", (request, response) -> {
				contactService.deleteContact(request.params(":id"));
				
				return new Gson().toJson(null);
			});
			after((request, response) -> {
				response.type("application/json");
			});
		});
	}
}

package com.schoolofnet.SparkApp;

import static spark.Spark.*;

import com.google.gson.Gson;
import com.schoolofnet.SparkApp.beans.MyBean;
import com.schoolofnet.SparkApp.utils.JsonResponse;

public class App  {
    
	public static void main( String[] args ) {
		new Config().setConfig();
		new Routes().setRoutes();
//		port(8080);
//		ipAddress("127.0.0.1");
		
//		before((request, response) -> System.out.println("Passing by before filter"));
////		before("", (request, response) -> System.out.println("Passing by before filter"));
//		
//		path("/api", () -> {
//			post("/:name", "application/json",  (request, response) -> {
//				System.out.println(request.body());
//				
//				MyBean bean = new Gson().fromJson(request.body(), MyBean.class);
//				
//				System.out.println(bean.getName());
//				System.out.println(bean.getAge());
//				
//				return new MyBean(request.params(":name"));
//			}, new JsonResponse());
//		});
//		
//		after((request, response) -> {
//			response.type("application/json");
//		});
//		
//		afterAfter((request, response) -> System.out.println("Passing by After After filter"));
		
    }
}

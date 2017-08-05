package com.schoolofnet.SparkApp.services;

import java.util.Collection;
import java.util.HashMap;

import com.schoolofnet.SparkApp.beans.Contact;

public class ContactServiceImpl implements ContactService {

	private HashMap<String, Contact> db;
	
	public ContactServiceImpl() {
		this.db = new HashMap<>();
	}
	
	@Override
	public void insertContact(Contact contact) {
		this.db.put(contact.getId(), contact);
	}

	@Override
	public Collection<Contact> getContacts() {
		return this.db.values();
	}

	@Override
	public Contact getContact(String id) {
		return this.db.get(id);
	}

	@Override
	public Contact editContact(Contact contact) {
		Contact contactToEdit = null;
		try {
			contactToEdit = this.db.get(contact.getId());
		
			if (contactToEdit == null) {
				throw new Exception("Not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (contact.getName() != null) {
			contactToEdit.setName(contact.getName());
		}
		
		if (contact.getTelephone() != null) {
			contactToEdit.setTelephone(contact.getTelephone());
		}

		return contactToEdit;
	}

	@Override
	public void deleteContact(String id) {
		this.db.remove(id);
	}

}

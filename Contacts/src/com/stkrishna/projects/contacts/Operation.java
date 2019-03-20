/**
 * 
 */
package com.stkrishna.projects.contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author krishnamoorthi
 *
 */
public class Operation {

	private List<Contact> contacts;
	private static final String FIELD_SEPERATOR = ",";

	public Operation(List<Contact> contacts) {
		this.contacts = contacts;
		import_file();
	}

	public void add(Contact contact) {
		contacts.add(contact);
		System.out.println("\t\t>>> Contact added successfully !");
	}

	public void delete(long id) {
		delete(contacts.stream().filter(contact -> id == contact.getId()).collect(Collectors.toList()).get(0));
	}

	public void delete(Contact contact) {
		contacts.remove(contact);
		System.out.println("\t\t>>> Contact deleted successfully !");
	}

	public void update(Contact contact) {
		delete(contacts.stream().filter(contactold -> contactold.getId() == contact.getId())
				.collect(Collectors.toList()).get(0));
		contacts.add(contact);
		System.out.println("\t\t>>> Contact updated successfully !");
	}

	public void save() {
		File contactFile = new File("contacts.csv");
		try (FileWriter writer = new FileWriter(contactFile)) {
			writer.write(parseContactsToCsv().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Contact> search(String searchstring) {
		return contacts.stream().filter(contact -> contact.toString().contains(searchstring))
				.collect(Collectors.toList());
	}

	public void import_file() {
		long count = 0;
		File contactFile = new File("contacts.csv");
		if(contactFile.exists()) {
			try (FileReader contactsReader = new FileReader(contactFile)) {
				try (BufferedReader reader = new BufferedReader(contactsReader)) {
					String line = "";
					while ((line = reader.readLine()) != null) {
						String[] fields = line.split("\\,");
						Contact contact = new Contact();
						contact.setId(count++);
						contact.setFirstname(fields[0]);
						contact.setLastname(fields[1]);
						contact.setEmail(fields[2]);
						contact.setPhonenumber(fields[3]);
						contact.setDateOfBirth(fields[4]);
						contact.setCompany(fields[5]);
						contact.setDesignation(fields[6]);
						contacts.add(contact);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private StringBuilder parseContactsToCsv() {
		StringBuilder builder = new StringBuilder("");
		for (Contact contact : contacts) {
			builder.append(contact.getFirstname()).append(FIELD_SEPERATOR).append(contact.getLastname())
					.append(FIELD_SEPERATOR).append(contact.getEmail()).append(FIELD_SEPERATOR)
					.append(contact.getPhonenumber()).append(FIELD_SEPERATOR).append(contact.getDateOfBirth())
					.append(FIELD_SEPERATOR).append(contact.getCompany()).append(FIELD_SEPERATOR)
					.append(contact.getDesignation()).append(System.lineSeparator());
		}
		return builder;
	}

	/**
	 * @return the contacts
	 */
	public List<Contact> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}

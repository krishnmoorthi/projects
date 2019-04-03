/**
 *
 */
package com.stkrishna.projects.contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author krishnamoorthi
 */
public class Harness {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();
        Operation operation = new Operation(contacts);
        Scanner stdin = new Scanner(System.in);
        menu();
        int operationCommand = stdin.nextInt();
        while (operationCommand != 7) {
            callOperation(operationCommand, stdin, operation);
            menu();
            operationCommand = stdin.nextInt();
        }
        stdin.close();
        operation.save();
        System.out.println("\n\n\t\t <<<<< Bye ! Have a nice day ! >>>>>");
    }

    private static void callOperation(int cmd, Scanner sc, Operation operation) {
        if (1 == cmd) {
            Contact contact = new Contact();
            getContactInput(contact, sc);
            operation.add(contact);
        } else if (2 == cmd) {
            long id = getInputIdWhenMultiResults(operation, "Firstname/Lastname for delete", sc);
            operation.delete(id);
        } else if (3 == cmd) {
            long id = getInputIdWhenMultiResults(operation, "Firstname/Lastname for edit", sc);
            Contact contact = new Contact();
            getContactInput(contact, sc);
            contact.setId(id);
            operation.update(contact);
        } else if (4 == cmd) {
            operation.save();
        } else if (5 == cmd) {
            String searchstring = getInputString("search string", sc);
            List<Contact> contacts = operation.search(searchstring);
            listContacts(contacts);
        } else if (6 == cmd) {
            System.out.println("\t\tTotal available contacts :" + operation.getContacts().size());
        } else {
            System.out.println("\nYou entered invalid menu command !\n");
        }
    }

    private static void listContacts(List<Contact> contacts) {
        contacts.stream().forEach(contact -> System.out.println(contact.toString()));
    }

    private static long getInputIdWhenMultiResults(Operation operation, String label, Scanner sc) {
        String searchstring = getInputString(label, sc);
        List<Contact> contactsToDelete = operation.search(searchstring);
        listContacts(contactsToDelete);
        return getInputLong("id", sc);
    }

    private static String getInputString(String label, Scanner sc) {
        System.out.printf("\n\t\tEnter %s :", label);
        String input = sc.next();
        return input;
    }

    private static void getContactInput(Contact contact, Scanner sc) {
        contact.setFirstname(getInputString("Firstname", sc));
        contact.setLastname(getInputString("Lastname", sc));
        contact.setEmail(getInputString("Email", sc));
        contact.setPhonenumber(getInputString("phonenumber", sc));
        contact.setDateOfBirth(getInputString("dateOfBirth", sc));
        contact.setCompany(getInputString("company", sc));
        contact.setDesignation(getInputString("designation", sc));
    }

    private static long getInputLong(String label, Scanner sc) {
        System.out.printf("\t\tSelect %s :", label);
        return sc.nextLong();
    }

    private static void menu() {
        System.out.println("\n\n======================");
        System.out.println("\t Contacts ");
        System.out.println("======================");
        System.out.println("1. Add contact");
        System.out.println("2. delete contact");
        System.out.println("3. edit contact");
        System.out.println("4. save contact");
        System.out.println("5. search contact");
        System.out.println("6. List Available contacts");
        System.out.println("7. Quit");
        System.out.print("\n choose operation : ");
    }

}

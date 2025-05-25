package Hash.Code;

import java.util.*;

public class HashMain {
    public static void main(String[] args) {
        String aText = "Hello";
	  String bText = "Hello";
	  String cText = String.join("l", "He", "lo");
	  String dText = "He".concat("llo");
	  String eText = "hello";

	  List<String> hellos = Arrays.asList(aText, bText,cText,dText,eText);

	  hellos.forEach(s -> System.out.println(s + ": " + s.hashCode()));

	  Set<String> mySet = new HashSet<>(hellos);
	  System.out.println("mySet = " + mySet);
	  System.out.println("# of elements =" + mySet.size());

	  for(String setValue : mySet) {
		  System.out.print(setValue + ": ");
		  for(int i = 0; i < hellos.size(); i++) {
			  if(setValue == hellos.get(i)) {
				  System.out.print(i + ", ");
			  }
		  }
		  System.out.println(" ");
	  }
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("phone List", phones);
        printData("Email List", emails);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);

        printData("Phone Contacts", phoneContacts);
        printData("Email Contacts", emailContacts);

        int index = emails.indexOf(new Contact("Bob Smith"));
        Contact robinHood = emails.get(index);
       // robinHood.addEmail("Robin Hood");
        robinHood.addEmail("Bobsss Smithss");
        System.out.println(robinHood);

        Set<Contact> mergedAB = new HashSet<>();
        mergedAB.addAll(emailContacts);
        mergedAB.addAll(phoneContacts);
        printData("(A U B) Union of emails (A) with phones (B)", mergedAB);

        Set<Contact> intersectionAB = new HashSet<>(emailContacts);
        intersectionAB.retainAll(phoneContacts);
        printData("(A n B) Intersection of emails (A) with phones (B)", intersectionAB);

        Set<Contact> intersectionBA = new HashSet<>(phoneContacts);
        intersectionAB.retainAll(emailContacts);
        printData("(A n B) Intersection of emails (A) with phones (B)", intersectionBA);
    }
    public static void printData(String header, Collection<Contact> contact) {
        System.out.println("------------------------------------------");
        System.out.println(header);
        System.out.println("------------------------------------------");
        contact.forEach(System.out::println);
    }
}


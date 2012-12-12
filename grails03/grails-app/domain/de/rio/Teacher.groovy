package de.rio

import java.util.Date;

class Teacher {
	String lastName;
	String firstName;
	String email;
	String phone;
	String address;
	String zipcode;
	String city;
	String gender;
	Date dateOfBirth;

    static constraints = {
		lastName(blank:false)
		firstName(blank:false)
		email(nullable:true,email:true)
		phone(nullable:true)
		address(nullable:true)
		zipcode(nullable:true)
		city(nullable:true)
		gender(nullable:true,InList:['male','female'])
		dateOfBirth(nullable:true)
    }
	
	String toString() {
		return "${lastName}, ${firstName} (${id})";
	}
}

package de.rio

import org.grails.datastore.gorm.finders.MethodExpression.InList;

class Student {
	String lastName;
	String firstName;
	String email;
	String phone;
	String address;
	String zipcode;
	String city;
	String gender;
	Date dateOfBirth;

	static hasMany = [registrations: Registration];
	
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

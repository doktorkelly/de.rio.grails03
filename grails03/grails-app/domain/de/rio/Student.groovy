package de.rio

import org.grails.datastore.gorm.finders.MethodExpression.InList;

class Student {
	String lastName;
	String firstName;
	String email;
	String phone;
	String phone2;
	String address;
	String zipcode;
	String city;
	String gender;
	Date dateOfBirth;
	String request;

	static hasMany = [registrations: Registration];
	
    static constraints = {
		lastName(blank:false)
		firstName(blank:false)
		email(nullable:true,email:true)
		request(nullable:true,maxSize:1024)
		phone(nullable:true)
		phone2(nullable:true)
		address(nullable:true)
		zipcode(nullable:true)
		city(nullable:true)
		gender(nullable:true,InList:['male','female'])
		dateOfBirth(nullable:true)
    }
	
	String toString() {
		return "${lastName}, ${firstName}";
	}
}

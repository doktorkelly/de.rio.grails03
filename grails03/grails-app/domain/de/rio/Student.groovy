package de.rio

import java.util.List;
import java.util.Map;

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
	
	@Override
	String toString() {
		return "${lastName}, ${firstName}";
	}
	
	static List<Student> listInDefaultOrder(Map params) {
		def c = Student.createCriteria();
		List<Student> results = c.list(max: params.max, offset: params.offset) {
			order("lastName", "asc")
			order("firstName", "asc")
		}
		return results;
	}
}

package de.rio

class Room {
	String name;

	static hasMany = [courses: Course];
	
    static constraints = {
		name(blank:false)
    }
	
	String toString () {
		return "${name} (${courses.size()})";
	}
}

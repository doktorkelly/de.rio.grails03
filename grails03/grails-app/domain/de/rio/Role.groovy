package de.rio

class Role {

	String authority

	static mapping = {
		table name: 'app_role'
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
}

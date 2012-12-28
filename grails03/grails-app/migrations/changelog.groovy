databaseChangeLog = {

	changeSet(author: "pascal (generated)", id: "1354984092592-1") {
		createTable(tableName: "app_role") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "app_rolePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-2") {
		createTable(tableName: "app_user") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "app_userPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-3") {
		createTable(tableName: "course") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "coursePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "end_date", type: "timestamp")

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "price", type: "numeric(19,2)")

			column(name: "room", type: "varchar(255)")

			column(name: "schedule_text", type: "varchar(255)")

			column(name: "start_date", type: "timestamp")

			column(name: "teacher_id", type: "int8")
		}
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-4") {
		createTable(tableName: "lesson") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "lessonPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "course_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "date", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "homework", type: "varchar(255)")

			column(name: "num_students", type: "numeric(19,2)")

			column(name: "plan", type: "varchar(255)")

			column(name: "state", type: "varchar(255)")

			column(name: "teacher_id", type: "int8")
		}
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-5") {
		createTable(tableName: "registration") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "registrationPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "course_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp")

			column(name: "paid", type: "bool")

			column(name: "student_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-6") {
		createTable(tableName: "student") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "studentPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "address", type: "varchar(255)")

			column(name: "city", type: "varchar(255)")

			column(name: "date_of_birth", type: "timestamp")

			column(name: "email", type: "varchar(255)")

			column(name: "first_name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "gender", type: "varchar(6)")

			column(name: "last_name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "zipcode", type: "varchar(255)")
		}
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-7") {
		createTable(tableName: "teacher") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "teacherPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "address", type: "varchar(255)")

			column(name: "city", type: "varchar(255)")

			column(name: "date_of_birth", type: "timestamp")

			column(name: "email", type: "varchar(255)")

			column(name: "first_name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "gender", type: "varchar(6)")

			column(name: "last_name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "zipcode", type: "varchar(255)")
		}
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-8") {
		createTable(tableName: "user_role") {
			column(name: "role_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-9") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-10") {
		addForeignKeyConstraint(baseColumnNames: "teacher_id", baseTableName: "course", constraintName: "FKAF42E01BF0A22197", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "teacher", referencesUniqueColumn: "false")
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-11") {
		addForeignKeyConstraint(baseColumnNames: "course_id", baseTableName: "lesson", constraintName: "FKBE10AD38EA2A8D1D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "course", referencesUniqueColumn: "false")
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-12") {
		addForeignKeyConstraint(baseColumnNames: "teacher_id", baseTableName: "lesson", constraintName: "FKBE10AD38F0A22197", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "teacher", referencesUniqueColumn: "false")
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-13") {
		addForeignKeyConstraint(baseColumnNames: "course_id", baseTableName: "registration", constraintName: "FKAF83E8B9EA2A8D1D", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "course", referencesUniqueColumn: "false")
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-14") {
		addForeignKeyConstraint(baseColumnNames: "student_id", baseTableName: "registration", constraintName: "FKAF83E8B9E006D6F7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "student", referencesUniqueColumn: "false")
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-15") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46A357A5FFD", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "app_role", referencesUniqueColumn: "false")
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-16") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46ADAA523DD", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "app_user", referencesUniqueColumn: "false")
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-17") {
		createIndex(indexName: "authority_unique_1354984092371", tableName: "app_role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-18") {
		createIndex(indexName: "username_unique_1354984092380", tableName: "app_user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "pascal (generated)", id: "1354984092592-19") {
		createSequence(sequenceName: "hibernate_sequence")
	}

	include file: 'change-v0.3.a.groovy'

	include file: 'change-v0.3.b.groovy'

	include file: 'change-v0.3.c.groovy'

	include file: 'change-v0.3.2.a.groovy'

	include file: 'change-v0.3.2.b.groovy'

	include file: 'change-v0.3.2.c.groovy'

	include file: 'change-v0.3.3.a.groovy'

	include file: 'change-v0.3.3.b.groovy'

	include file: 'change-v0.5.1.groovy'
}

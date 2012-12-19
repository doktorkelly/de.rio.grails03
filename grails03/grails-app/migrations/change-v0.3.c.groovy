databaseChangeLog = {

	changeSet(author: "pascal (generated)", id: "1355931049620-1") {
		createTable(tableName: "room") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "roomPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "pascal (generated)", id: "1355931049620-2") {
		addColumn(tableName: "course") {
			column(name: "room_id", type: "int8")
		}
	}

	changeSet(author: "pascal (generated)", id: "1355931049620-3") {
		addForeignKeyConstraint(baseColumnNames: "room_id", baseTableName: "course", constraintName: "FKAF42E01B35A849DD", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "room", referencesUniqueColumn: "false")
	}

	changeSet(author: "pascal (generated)", id: "1355931049620-4") {
		dropColumn(columnName: "room", tableName: "course")
	}
}

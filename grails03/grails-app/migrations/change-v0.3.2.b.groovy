databaseChangeLog = {

	changeSet(author: "pascal (generated)", id: "1355941766826-1") {
		addColumn(tableName: "course") {
			column(name: "group_name", type: "varchar(255)")
		}
	}

	changeSet(author: "pascal (generated)", id: "1355941766826-2") {
		dropColumn(columnName: "group", tableName: "course")
	}
}

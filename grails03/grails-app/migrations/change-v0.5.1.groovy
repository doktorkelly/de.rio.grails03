databaseChangeLog = {

	changeSet(author: "pascal (generated)", id: "1356643771946-1") {
		addColumn(tableName: "student") {
			column(name: "phone2", type: "varchar(255)")
		}
	}

	changeSet(author: "pascal (generated)", id: "1356643771946-2") {
		addColumn(tableName: "student") {
			column(name: "request", type: "varchar(1024)")
		}
	}
}

databaseChangeLog = {

	changeSet(author: "pascal (generated)", id: "1354990115117-1") {
		addColumn(tableName: "student") {
			column(name: "phone", type: "varchar(255)")
		}
	}
}

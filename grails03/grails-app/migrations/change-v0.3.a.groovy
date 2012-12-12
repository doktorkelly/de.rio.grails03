databaseChangeLog = {

	changeSet(author: "pascal (generated)", id: "1354988168928-1") {
		addColumn(tableName: "teacher") {
			column(name: "phone", type: "varchar(255)")
		}
	}
}

databaseChangeLog = {

	changeSet(author: "pascal (generated)", id: "1355943951410-1") {
		addColumn(tableName: "course") {
			column(name: "quartal", type: "varchar(255)")
		}
	}
}

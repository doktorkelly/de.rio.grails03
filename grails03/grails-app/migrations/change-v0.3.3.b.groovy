databaseChangeLog = {

	changeSet(author: "pascal (generated)", id: "1356021779305-1") {
		addColumn(tableName: "course") {
			column(name: "units", type: "numeric(19,2)")
		}
	}
}

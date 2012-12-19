databaseChangeLog = {

	changeSet(author: "pascal (generated)", id: "1355940952624-1") {
		addColumn(tableName: "course") {
			column(name: "group", type: "varchar(255)")
		}
	}
}

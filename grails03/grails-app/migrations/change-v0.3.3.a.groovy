databaseChangeLog = {

	changeSet(author: "pascal (generated)", id: "1356020987867-1") {
		addColumn(tableName: "registration") {
			column(name: "special_price", type: "numeric(19,2)")
		}
	}
}

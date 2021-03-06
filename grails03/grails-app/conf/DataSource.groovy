dataSource {
    pooled = false
    driverClassName = "org.postgresql.Driver"
    username = "grails03"
    password = "grails03"
	dialect = org.hibernate.dialect.PostgreSQLDialect
	//dialect = net.sf.hibernate.dialect.PostgreSQLDialect
	//dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
//    pooled = true
//    driverClassName = "org.h2.Driver"
//    username = "sa"
//    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
			url = "jdbc:postgresql://localhost:5432/grails03_develop"
			logSql = true;
//            dbCreate = "validate" 
//            dbCreate = "create-drop" 
//            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    test {
        dataSource {
            url = "jdbc:postgresql://localhost:5432/grails03_test"
            dbCreate = "create"
//            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
//            dbCreate = "validate"
//            dbCreate = "update"
            url = "jdbc:postgresql://localhost:5432/grails03"
            pooled = true
//            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
//            pooled = true
//            properties {
//               maxActive = -1
//               minEvictableIdleTimeMillis=1800000
//               timeBetweenEvictionRunsMillis=1800000
//               numTestsPerEvictionRun=3
//               testOnBorrow=true
//               testWhileIdle=true
//               testOnReturn=true
//               validationQuery="SELECT 1"
//            }
        }
    }
}

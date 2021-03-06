// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

// (pascal, 2012-12-02):
grails.gorm.default.mapping = {
	id generator: 'sequence'
}

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}
	//check:
	root {
		info 'file', 'stdout'
	}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
		   
	debug  'grails.app.controllers.de.rio'                  // controller
	
	info   'grails.app.domain'                              // domain
}

// Migrate DB automatically at startup:
grails.plugin.databasemigration.changelogLocation      =  "grails-app/migrations"
grails.plugin.databasemigration.updateOnStartFileNames = ["changelog.groovy"]
grails.plugin.databasemigration.updateOnStart          = true

// Added by the Spring Scurity Core plugin:
grails.plugins.springsecurity.userLookup.userDomainClassName = 'de.rio.User'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'de.rio.UserRole'
grails.plugins.springsecurity.authority.className = 'de.rio.Role'

//grails.plugins.springsecurity.securityConfigType = "Annotation"   //default
grails.plugins.springsecurity.securityConfigType = "InterceptUrlMap"

grails.plugins.springsecurity.interceptUrlMap = [
	'/user/**':         ['ROLE_ADMIN'],
	'/role/**':         ['ROLE_ADMIN'],
	'/userrole/**':     ['ROLE_ADMIN'],
	'/*/create':        ['ROLE_USER'],
	'/*/edit/**':       ['ROLE_USER'],
	'/*/update/**':     ['ROLE_USER'],
	'/*/delete/**':     ['ROLE_USER'],
	'/*/save/**':       ['ROLE_USER'],
	'/*/list/**':       ['ROLE_USER', 'ROLE_GUEST', 'IS_AUTHENTICATED_FULLY'],
	'/*/show/**':       ['ROLE_USER', 'ROLE_GUEST', 'IS_AUTHENTICATED_FULLY'],
	'/*/index/**':      ['ROLE_USER', 'ROLE_GUEST', 'IS_AUTHENTICATED_FULLY'],
	'/js/**':           ['IS_AUTHENTICATED_ANONYMOUSLY'],
	'/css/**':          ['IS_AUTHENTICATED_ANONYMOUSLY'],
	'/images/**':       ['IS_AUTHENTICATED_ANONYMOUSLY'],
	'/login/**':        ['IS_AUTHENTICATED_ANONYMOUSLY'],
	'/logout/**':       ['IS_AUTHENTICATED_ANONYMOUSLY'],
	'/':                ['IS_AUTHENTICATED_ANONYMOUSLY'],
	'/**':              ['IS_AUTHENTICATED_ANONYMOUSLY']
 ]

grails.plugins.springsecurity.ipRestrictions = [
	'/pattern1/**': '123.234.345.456',
	'/pattern2/**': '10.0.0.0/8',
	'/pattern3/**': ['10.10.200.42', '10.10.200.63']
 ]









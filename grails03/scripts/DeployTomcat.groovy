/*
 * Copyright 2004-2005 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import grails.util.BuildScope

/**
 * Gant script that deploys a war to tomcat
 * WARNING: this does not work because of "too many redirects error"
 * and authentication errors on tomcat
 * @author Pascal
 * @since 0.3
 */

scriptEnv = "production"

includeTargets << grailsScript("_GrailsWar")

target (deploy: "deploy to tomcat server") {
    depends(war)
	
	String username = buildConfig.tomcat.mgr.username
	char[] password = buildConfig.tomcat.mgr.password
	
	Authenticator.setDefault([
		getPasswordAuthentication: {->
			new PasswordAuthentication(username, password)
		}
	] as Authenticator)
	
	String warNameForward = "file:///C:/Users/pascal/develop/projects/de.rio.grails03/grails03/target/grails03-0.3.1.war";
	
	def url = "http://v45066.1blu.de:8080/manager/text/deploy"
	url +=	"?war=" + warName
	url +=	"&path=/grails03"
	url +=	"&update=true"
		
	def response = new URL(url).text;
	if (response.startsWith("OK")) {
		println("application deployed successfully");
		return 0;
	}		
	else {
		println("application failed to deploy: $response");
		return 1;
	}
}

setDefaultTarget('deploy')

/*******************************************************************************
 * Copyright 2017 Cognizant Technology Solutions
 *   
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * 	of the License at
 *   
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.cognizant.devops.platformservice.security.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SpringAuthorityUtil {
	
	private static Logger log = LogManager.getLogger(SpringAuthorityUtil.class.getName());
	
	public static SpringAuthority getSpringAuthorityRole(String grafanaCurrentOrgRole) {
		try{
			return SpringAuthority.valueOf(grafanaCurrentOrgRole.replaceAll("\\s", "_"));
		}catch (Exception e) {
			log.error("Unable to find grafana role in Spring Authority.", e);
		}
		return SpringAuthority.valueOf("Viewer");
	}

}
/*******************************************************************************
 * Copyright 2017 Cognizant Technology Solutions
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.cognizant.devops.platformdal.dashboards;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cognizant.devops.platformdal.user.UserPortfolioEnum;

@Entity
@Table (name="custom_dashboard")
public class CustomDashboard {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name ="dashboard_name")
	private String dashboardName;
	
	@Column(name ="dashboard_json")
	private String dashboardJson;
	
	@Column(name ="portfolio")
	@Enumerated(EnumType.ORDINAL) 
	private UserPortfolioEnum portfolio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDashboardName() {
		return dashboardName;
	}

	public void setDashboardName(String dashboardName) {
		this.dashboardName = dashboardName;
	}

	public String getDashboardJson() {
		return dashboardJson;
	}

	public void setDashboardJson(String dashboardJson) {
		this.dashboardJson = dashboardJson;
	}

	public UserPortfolioEnum getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(UserPortfolioEnum portfolio) {
		this.portfolio = portfolio;
	}
}
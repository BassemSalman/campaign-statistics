package com.project.CampaignStatistics;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration

//@ComponentScan({"com.apliman.LinkTrackConsultant"})
//@ComponentScan({"com.apliman.LinkTrackConsultant.service","com.apliman.LinkTrackConsultant.repository", "com.apliman.LinkTrackConsultant.model", "com.apliman.LinkTrackConsultant.controller",  "com.apliman.LinkTrackConsultant.implementation"})
//@EntityScan(basePackages = "com.apliman.LinkTrackConsultant.model")
@SpringBootApplication
//@ComponentScan(basePackages = {"com.apliman.LinkTrackConsultant", "com.apliman.LinkTrackConsultant.*"})

public class CampaignStatisticsAplication extends SpringBootServletInitializer{	
	public static void main(String[] args) {
		SpringApplication.run(CampaignStatisticsAplication.class, args);
	}
}

package com.project.CampaignStatistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CampaignStatistics.model.Campaign;
import com.project.CampaignStatistics.model.Engagement;
import com.project.CampaignStatistics.repository.custom.CampaignCustomRepository;
import com.project.CampaignStatistics.repository.custom.CounterCustomRepository;
import com.project.CampaignStatistics.repository.custom.EngagementCustomRepository;


//service that implements logic of requesting url and saving token
@Service
public class URLService {
	@Autowired
	EngagementCustomRepository engagementRepo;
	@Autowired
	CampaignCustomRepository campaignRepo;
	@Autowired
	CounterCustomRepository counterRepo;
	
	
	public CounterCustomRepository getCounterRepo() {
		return counterRepo;
	}


	public void setCounterRepo(CounterCustomRepository counterRepo) {
		this.counterRepo = counterRepo;
	}


	public EngagementCustomRepository getEngagementRepo() {
		return engagementRepo;
	}


	public void setEngagementRepo(EngagementCustomRepository engagementRepo) {
		this.engagementRepo = engagementRepo;
	}


	public CampaignCustomRepository getCampaignRepo() {
		return campaignRepo;
	}


	public void setCampaignRepo(CampaignCustomRepository campaignRepo) {
		this.campaignRepo = campaignRepo;
	}


	public String findUrl(int campaignId, String msisdn, String baseUrl, String appUrl) { // add them as parameters + https.. and port
		String url = null;
//        if(engagementRepo == null || campaignRepo == null) {
//        	System.out.println("null repos inside urlRepo");
//        }
		
        Campaign campaign = campaignRepo.findById(campaignId);
		Engagement engagement = engagementRepo.findByMsisdnAndCampaign(msisdn, campaign);
		
		if(engagement != null && campaign!=null) { // both exist
			String token = engagement.getToken();
			
			if(token == null) { // iza already ando token => dont inc		
				counterRepo.incrementRequestedUrl(campaign);
			}
			
			Engagement e = engagementRepo.setEngagementToken(engagement); 
			token = e.getToken();
			if(token != null) {				
				url = "" + baseUrl + "/" + appUrl + "/redirect/" + token;
			}
			
		}
		return url;
	}
}


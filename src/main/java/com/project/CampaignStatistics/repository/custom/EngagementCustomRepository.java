package com.project.CampaignStatistics.repository.custom;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.CampaignStatistics.model.Campaign;
import com.project.CampaignStatistics.model.Engagement;
@Repository
//@Scope("prototype")
public interface EngagementCustomRepository {
	public List<Engagement> findAll();
	public Engagement findById(int id);
	public Engagement findByToken(String token);
	public boolean existsByToken(String token);
	
//	public Engagement findByMsisdn(String msisdn); not unique alone
	public Engagement findByMsisdnAndCampaign(String msisdn, Campaign campaign);
	public Engagement setEngagementToken(Engagement e);
	public Engagement updateEngagement(Engagement e);
	public Engagement deleteEngagement(Engagement e);


}

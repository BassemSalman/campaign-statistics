
package com.project.CampaignStatistics.repository.custom;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.CampaignStatistics.model.Campaign;
import com.project.CampaignStatistics.model.Engagement;
@Repository
public interface CampaignCustomRepository {
	public Campaign createCampaign(Campaign c);
	public List<Campaign> findAll();
//	public Campaign findByName(String campaignName);
//	public void deleteAll();
	public Campaign deleteById(int id);
	public Campaign findById(int id);
	
	public Campaign updateCampaign(Campaign c);
//	public Campaign deleteByName(String campaignName);
	public Campaign addEngagement(Campaign campaign, String msisdn);
	public Engagement removeEngagement(Campaign c, Engagement e);
	public boolean isExpired(Campaign campaign);
}

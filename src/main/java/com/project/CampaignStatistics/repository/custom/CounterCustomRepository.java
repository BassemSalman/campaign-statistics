package com.project.CampaignStatistics.repository.custom;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.CampaignStatistics.model.Campaign;
import com.project.CampaignStatistics.model.Counter;
@Repository
public interface CounterCustomRepository {
	public List<Counter> findAll();
	public Counter findById(int id);	
	public Counter findByCounterCampaign(Campaign campaign);
	
	public void incrementTotalClicks(Campaign campaign);
	public void incrementSuccessfulClicks(Campaign campaign);
	public void incrementRequestedUrl(Campaign campaign);
	public void resetCounters(Campaign campaign);
	public Counter save(Counter counter);
	public void resetCounters(Counter counter);
	
}

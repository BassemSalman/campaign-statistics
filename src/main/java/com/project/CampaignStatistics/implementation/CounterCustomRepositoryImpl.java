package com.project.CampaignStatistics.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.CampaignStatistics.model.Campaign;
import com.project.CampaignStatistics.model.Counter;
import com.project.CampaignStatistics.repository.CounterRepository;
import com.project.CampaignStatistics.repository.custom.CounterCustomRepository;

@Component
public class CounterCustomRepositoryImpl implements CounterCustomRepository {
	@Autowired
	private CounterRepository counterRepo;

	public List<Counter> findAll() {
		return counterRepo.findAll();
	}

	public Counter findById(int id) {
		return counterRepo.findById(id);
	}

	public Counter findByCounterCampaign(Campaign campaign) {
		return counterRepo.findByCounterCampaign(campaign);
	}

	public void resetCounters(Campaign campaign) {
		Counter counter = counterRepo.findByCounterCampaign(campaign);
		resetCounters(counter);
	}

	public void incrementTotalClicks(Campaign campaign) {
		Counter counter = counterRepo.findByCounterCampaign(campaign);
		if (counter != null) {
			counter.setTotalClicks(counter.getTotalClicks() + 1);
		}
	}

	public void incrementSuccessfulClicks(Campaign campaign) {
		Counter counter = counterRepo.findByCounterCampaign(campaign);
		if (counter != null) {
			counter.setSuccessfulClicks(counter.getSuccessfulClicks() + 1);
		}
	}

	public void incrementRequestedUrl(Campaign campaign) {
		Counter counter = counterRepo.findByCounterCampaign(campaign);
		if (counter != null) {
			counter.setRequestedUrl(counter.getRequestedUrl() + 1);
		}
	}

	public Counter save(Counter counter) {
		return counterRepo.save(counter);
	}

	public void resetCounters(Counter counter) {
		if (counter != null) {
			counter.setTotalClicks(0);
			counter.setTotalClicks(0);
			counter.setRequestedUrl(0);
		}
	}

}

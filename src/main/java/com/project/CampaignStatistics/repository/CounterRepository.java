package com.project.CampaignStatistics.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.CampaignStatistics.model.Campaign;
import com.project.CampaignStatistics.model.Counter;

@Repository

public interface CounterRepository extends CrudRepository<Counter, Integer> {
	public Counter findById(int id);

	public List<Counter> findAll();

	public Counter findByCounterCampaign(Campaign campaign);

	public Counter save(Counter counter);
}

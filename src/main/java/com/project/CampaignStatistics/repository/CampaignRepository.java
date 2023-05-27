package com.project.CampaignStatistics.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.CampaignStatistics.model.Campaign;

@Repository

public interface CampaignRepository extends CrudRepository<Campaign, Integer> {
	public List<Campaign> findAll();
	public Campaign findById(int id);
}

package com.project.CampaignStatistics.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.CampaignStatistics.model.Campaign;
import com.project.CampaignStatistics.model.Engagement;

@Repository
public interface EngagementRepository extends CrudRepository<Engagement, Integer> {
	public Engagement findById(int id);

	public List<Engagement> findAll();

	public boolean existsByToken(String token);

	public Engagement findByToken(String token);

	public Engagement findByMsisdnAndCampaign(String msisdn, Campaign campaign);

	public Engagement findByMsisdn(String msisdn);
}

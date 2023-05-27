package com.project.CampaignStatistics.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.CampaignStatistics.model.Campaign;
import com.project.CampaignStatistics.model.Engagement;
import com.project.CampaignStatistics.repository.CampaignRepository;
import com.project.CampaignStatistics.repository.EngagementRepository;
import com.project.CampaignStatistics.repository.custom.EngagementCustomRepository;
import com.project.CampaignStatistics.service.TokenService;

@Component
public class EngagementCustomRepositoryImpl implements EngagementCustomRepository {
	@Autowired
	EngagementRepository engagementRepo;
	@Autowired
	CampaignRepository campaignRepo;
	@Autowired
	TokenService tokenService;
	@Autowired
	Engagement engagement;

	public List<Engagement> findAll() {
		return engagementRepo.findAll();
	}

	public Engagement findById(int id) {
		return engagementRepo.findById(id);
	}

	// called when link requested
	public Engagement setEngagementToken(Engagement e) {
		if (e.getToken() != null)
			return e;

		String token = tokenService.generate(e.getMsisdn());
		if (token == null)
			return null;

		e.setToken(token);
		return engagementRepo.save(e);
	}

	public boolean existsByToken(String token) {
		return engagementRepo.existsByToken(token);
	}

	// can only change msisdn
	public Engagement updateEngagement(Engagement e) {
		engagement = engagementRepo.findById(e.getEngagementId());
		if (engagement == null) {
			return null;
		}
		if (e.getToken() != null || e.getCampaign() != null || e.getMsisdn() == null) {
			return null;
		}
		engagement.setMsisdn(e.getMsisdn());
		return engagementRepo.save(engagement);
	}

	// auto delete from campaign obj
	public Engagement deleteEngagement(Engagement e) {
		e = engagementRepo.findById(e.getEngagementId());
		if (e == null)
			return null;
		engagementRepo.delete(e);
		engagement = engagementRepo.findById(e.getEngagementId());

		// if no longer exists, return a copy
		if (engagement == null) {
			return e;
		}
		return null;
	}

	public Engagement findByMsisdnAndCampaign(String msisdn, Campaign campaign) {
		return engagementRepo.findByMsisdnAndCampaign(msisdn, campaignRepo.findById(campaign.getId()));
	}

	public Engagement findByMsisdn(String msisdn) {
		return engagementRepo.findByMsisdn(msisdn);
	}

	public Engagement findByToken(String token) {
		return engagementRepo.findByToken(token);
	}
}

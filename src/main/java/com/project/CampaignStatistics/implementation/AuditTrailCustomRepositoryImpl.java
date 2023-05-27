package com.project.CampaignStatistics.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.CampaignStatistics.model.AuditTrail;
import com.project.CampaignStatistics.repository.AuditTrailRepository;
import com.project.CampaignStatistics.repository.EngagementRepository;
import com.project.CampaignStatistics.repository.custom.AuditTrailCustomRepository;

@Component

public class AuditTrailCustomRepositoryImpl implements AuditTrailCustomRepository {
	@Autowired
	AuditTrailRepository auditTrailRepo;

	@Autowired
	EngagementRepository engagementRepo;

	public List<AuditTrail> findAll() {
		return auditTrailRepo.findAll();
	}

	public AuditTrail findById(int id) {
		return auditTrailRepo.findById(id);
	}

// notice
	public AuditTrail createAuditTrail(String campaignName, String msisdn) {
		AuditTrail a = new AuditTrail();
		a.setAuditCampaign(campaignName);
		a.setMsisdn(msisdn);
//		a.setActionDate(LocalDateTime.now()); // should be from db layer
//		a.setAuditEngagement(engagementRepo.findByMsisdnAndCampaign(msisdn, campaign));
		return auditTrailRepo.save(a);
	}

	public void deleteById(int id) {
		auditTrailRepo.deleteById(id);
	}
}

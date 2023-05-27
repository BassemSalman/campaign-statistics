package com.project.CampaignStatistics.repository.custom;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.CampaignStatistics.model.AuditTrail;

@Repository
public interface AuditTrailCustomRepository {
	public AuditTrail findById(int id);
	public List<AuditTrail> findAll();
	public void deleteById(int id);
	
	public AuditTrail createAuditTrail(String campaignName, String msidn);
}

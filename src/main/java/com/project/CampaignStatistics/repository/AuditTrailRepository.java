package com.project.CampaignStatistics.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.CampaignStatistics.model.AuditTrail;

@Repository
public interface AuditTrailRepository extends CrudRepository<AuditTrail, Integer> {
	public AuditTrail findById(int id);

	public List<AuditTrail> findAll();

	public void deleteById(int id);
}

package com.project.CampaignStatistics.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.CampaignStatistics.model.Campaign;
import com.project.CampaignStatistics.model.Counter;
import com.project.CampaignStatistics.model.Engagement;
import com.project.CampaignStatistics.repository.CampaignRepository;
import com.project.CampaignStatistics.repository.EngagementRepository;
import com.project.CampaignStatistics.repository.custom.CampaignCustomRepository;
import com.project.CampaignStatistics.repository.custom.CounterCustomRepository;
import com.project.CampaignStatistics.service.URIValidationService;

@Component
public class CampaignCustomRepositoryImpl implements CampaignCustomRepository {
	@Autowired
	CampaignRepository campaignRepo;
	@Autowired
	Engagement engagement;
	@Autowired
	Campaign campaign;
	@Autowired
	EngagementRepository engagementRepo;

	@Autowired
	CounterCustomRepository counterRepo;
	@Autowired
	Counter counter;

	public List<Campaign> findAll() {
		return campaignRepo.findAll();
	}

	public Campaign findByCampagnID(int id) {
		return campaignRepo.findById(id);
	}

	// deletes referenced engagements
	public Campaign deleteByCampagnID(int id) {
		campaign = campaignRepo.findById(id);
		if (campaign == null)
			return null;

		// doesnt delete engagements manually

		campaignRepo.delete(campaign);
		Campaign c = campaignRepo.findById(id);
		if (c == null)
			return campaign;
		return null;
	}

	public Campaign createCampaign(Campaign c) { // id name creation expiry - url (later)
		if (c.getExpiry() == null || c.getUrl() == null || c.getName() == null)
			return null;
		Campaign existing = campaignRepo.findById(c.getId());
		if (existing != null) {
			System.err.println("Exists");
			return existing;
		}

		boolean inPast = c.getExpiry().isBefore(LocalDateTime.now());
		if (c.getExpiry() != null) {
			if (inPast)
				return null;
			campaign.setExpiry(c.getExpiry());
		}

		boolean isValidUrl = URIValidationService.isValidURL(c.getUrl());
		if (c.getUrl() != null) {
			if (!isValidUrl)
				return null;
			campaign.setUrl(c.getUrl());
		}

//		c.setAuditTrails(null);
//		c.setCreation(LocalDateTime.now());
//		campaign.setCreation(LocalDateTime.now());
		campaignRepo.save(c);
		counter.setCounterId(0);
		counterRepo.resetCounters(counter);
		counter.setCounterCampaign(c);
		counterRepo.save(counter);
		c.setCounters(counter);

		return campaignRepo.findById(c.getId());
	}

	// allow expiry or url
	public Campaign updateCampaign(Campaign c) {
		System.out.println(c.getName());
		Campaign campaign = campaignRepo.findById(c.getId());
		System.out.println("Campaign not found");
		if (campaign == null)
			return null;
		if (c.getCreation() != null || (c.getUrl() != null && c.getExpiry() != null))
			return null;

		if (c.getExpiry() != null) {
			boolean inPast = c.getExpiry().isBefore(LocalDateTime.now());
			if (c.getExpiry() != null) {
				if (inPast)
					return null;
				else
					campaign.setExpiry(c.getExpiry());
			}
		}

		if (c.getUrl() != null) {
			boolean isValidUrl = URIValidationService.isValidURL(c.getUrl());
			if (c.getUrl() != null) {
				if (!isValidUrl)
					return null;
				campaign.setUrl(c.getUrl());
			}
		}
		return campaignRepo.save(campaign);
	}

	public Campaign addEngagement(Campaign c, String msisdn) {
		c = campaignRepo.findById(c.getId());
		if (c == null)
			return null;

		Engagement e = engagementRepo.findByMsisdnAndCampaign(msisdn, c);
		if (e != null) {
			return c;
		}

		// to create a new entry
		engagement.setEngagementId(0);

		engagement.setCampaign(c);
		engagement.setMsisdn(msisdn);
		engagementRepo.save(engagement);
		c.getEngagements().add(engagement);
		return campaignRepo.save(c);
//			reference it in array, not only in database
//			no need since campaignRepo.save will save both (cascade)
	}

	public Engagement removeEngagement(Campaign c, Engagement e) {
		if (c == null || e == null)
			return null;

		// if engagement not found in campaign
		if (!c.getEngagements().contains(e)) {
			return null;
		}

		c.getEngagements().remove(e); // no longer referenced in array
		engagementRepo.delete(e); // deleted from db
		Engagement engagement = engagementRepo.findByMsisdnAndCampaign(e.getMsisdn(), c);
		if (engagement == null)
			return e;
		return null;
	}

	public boolean isExpired(Campaign campaign) {
		return LocalDateTime.now().isAfter(campaign.getExpiry());
	}

	public Campaign deleteById(int id) {
		Campaign c = campaignRepo.findById(id);
		if(c==null) return null;
		campaignRepo.deleteById(id);
		if(campaignRepo.findById(id) != null) {
			return null;
		}
		return c;
	}

	public Campaign findById(int id) {
		return campaignRepo.findById(id);
	}
}

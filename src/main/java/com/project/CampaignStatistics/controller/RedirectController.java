package com.project.CampaignStatistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.project.CampaignStatistics.model.Campaign;
import com.project.CampaignStatistics.model.Engagement;
import com.project.CampaignStatistics.repository.custom.AuditTrailCustomRepository;
import com.project.CampaignStatistics.repository.custom.CampaignCustomRepository;
import com.project.CampaignStatistics.repository.custom.CounterCustomRepository;
import com.project.CampaignStatistics.repository.custom.EngagementCustomRepository;

@RestController
@RequestMapping("/redirect")
public class RedirectController {
	@Autowired
	EngagementCustomRepository engagementRepo;

	@Autowired
	CampaignCustomRepository campaignRepo;

	@Autowired
	CounterCustomRepository counterRepo;

	@Autowired
	AuditTrailCustomRepository auditTrailRepo;

	@GetMapping("/") // could be space
	public String hello() {
		return "Hello";
	}

	@GetMapping(path = "{token}")
	public String initiateEngagement(@PathVariable(name = "token") String token) {

		Engagement engagement = engagementRepo.findByToken(token);

		// campaign is set even if json ignore due to onetomany
		Campaign campaign = engagement.getCampaign();
		String campaignName = campaign.getName();

		String msisdn = engagement.getMsisdn();
		String url = campaign.getUrl();

		// counters
		counterRepo.incrementTotalClicks(campaign);
		if (campaignRepo.isExpired(campaign) == false) {
			counterRepo.incrementSuccessfulClicks(campaign);
		}

		auditTrailRepo.createAuditTrail(campaignName, msisdn);

		return "redirect:" + url;
	}

}

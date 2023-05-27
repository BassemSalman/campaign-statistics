package com.project.CampaignStatistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.CampaignStatistics.model.ApiResponse;
import com.project.CampaignStatistics.model.ApiResponseCode;
import com.project.CampaignStatistics.model.Campaign;
import com.project.CampaignStatistics.model.Engagement;
import com.project.CampaignStatistics.repository.custom.CampaignCustomRepository;
import com.project.CampaignStatistics.repository.custom.EngagementCustomRepository;

@RestController
@RequestMapping("/campaign")

public class CampaignController {
	ApiResponse response;
	@Autowired
	CampaignCustomRepository campaignRepo;
	@Autowired
	EngagementCustomRepository engagementRepo;

	@PostMapping
	public ApiResponse createCampaign(@RequestBody Campaign campaign) {

		Campaign x = campaignRepo.createCampaign(campaign);
		if (x != null) {
			return ApiResponse.getInstance().setCode(ApiResponseCode.SUCCESS)
					.addData("Campaign", x);
		}
		return ApiResponse.getInstance().setCode(ApiResponseCode.BAD_REQUEST)
				.addData("Campaign", null);
	}

	@GetMapping
	public ApiResponse getCampaigns() {

		return ApiResponse.getInstance().setCode(ApiResponseCode.SUCCESS)
				.addData("Campaigns", campaignRepo.findAll());
	}

	@GetMapping("{id}")
	public ApiResponse getCampaignById(@PathVariable("id") int id) {

		Campaign c = campaignRepo.findById(id);
		if (c == null) {
			return ApiResponse.getInstance().setCode(ApiResponseCode.NOT_FOUND)
					.addData("Campaign",null);
		}
		return ApiResponse.getInstance().setCode(ApiResponseCode.SUCCESS)
				.addData("Campaign", c);
	}

	@PatchMapping("{id}") // {name, url}
	public ApiResponse updateCampaign(@PathVariable("id") int id, @RequestBody Campaign campaign) {
		campaign.setId(id);
		Campaign c = campaignRepo.updateCampaign(campaign);
		if (c == null) {
			return ApiResponse.getInstance().setCode(ApiResponseCode.FAILED)
					.addData("Campaign", null);
		} else
			return ApiResponse.getInstance().setCode(ApiResponseCode.SUCCESS)
					.addData("Campaign", c);
	}

	@DeleteMapping
	public ApiResponse deleteCampaign(@RequestBody Campaign campaign) {

		// if referenced => cascade does the job
		int id = campaign.getId();
		if (id <= 0) {
			return ApiResponse.getInstance().setCode(ApiResponseCode.BAD_REQUEST)
					.addData("Campaign", null);
		}
		Campaign c = campaignRepo.deleteById(id);

		if (c != null) {
			return ApiResponse.getInstance().setCode(ApiResponseCode.SUCCESS)
					.addData("Campaign Deleted", c);
		}
		return ApiResponse.getInstance().setCode(ApiResponseCode.FAILED)
				.addData("Campaign Deleted", null);
	}

	@GetMapping("delete/{id}")
	public ApiResponse deleteCampaignUrl(@PathVariable("id") int id) {
		if (id <= 0) {
			return ApiResponse.getInstance().setCode(ApiResponseCode.BAD_REQUEST)
					.addData("Campaign", null);
		}
		Campaign c = campaignRepo.deleteById(id);
		if (c != null) {
			return ApiResponse.getInstance().setCode(ApiResponseCode.SUCCESS)
					.addData("Campaign Deleted", c);
		}
		return ApiResponse.getInstance().setCode(ApiResponseCode.NOT_FOUND)
				.addData("Campaign Deleted", null);
	}

	// add engagement to campaign
	@GetMapping("addnumber/{id}/{msisdn}")
	public ApiResponse addNumber(@PathVariable("id") int id, @PathVariable("msisdn") String msisdn) {

		Campaign campaign = campaignRepo.findById(id);
		if (campaign != null) {
			Campaign c = campaignRepo.addEngagement(campaign, msisdn);
			if (c != null) {
				return ApiResponse.getInstance().setCode(ApiResponseCode.SUCCESS)
						.addData("Campaign after addition", campaignRepo.findById(id));
			}
		}
		return ApiResponse.getInstance().setCode(ApiResponseCode.FAILED)
				.addData("Campaign after addition", null);
	}

	// remove engagement from campaign
	@GetMapping("removenumber/{id}/{msisdn}")
	public ApiResponse removeNumber(@PathVariable("id") int id, @PathVariable("msisdn") String msisdn) {

		// discard from array of engagements
		Campaign campaign = campaignRepo.findById(id);
		Engagement engagement = engagementRepo.findByMsisdnAndCampaign(msisdn, campaign);
		Engagement e = campaignRepo.removeEngagement(campaign, engagement);
		if (e != null) {
			return ApiResponse.getInstance().setCode(ApiResponseCode.SUCCESS)
					.addData("Engagement Removed", e)
					.addData("Campaign",campaign);

		}
		return ApiResponse.getInstance().setCode(ApiResponseCode.NOT_FOUND)
				.addData("Engagement Removed", null)
				.addData("Campaign", campaign);
	}
}

package com.project.CampaignStatistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.CampaignStatistics.model.ApiResponse;
import com.project.CampaignStatistics.model.ApiResponseCode;
import com.project.CampaignStatistics.model.Engagement;
import com.project.CampaignStatistics.repository.custom.EngagementCustomRepository;

@RestController
@RequestMapping("/engagement")
public class EngagementController {

	@Autowired
	EngagementCustomRepository engagementRepo;


	@GetMapping
	public ApiResponse getEngagements() {
		return ApiResponse.getInstance().setCode(ApiResponseCode.SUCCESS)
				.addData("Engagements", engagementRepo.findAll());
	}

	@PatchMapping
	public ApiResponse updateEngagement(@RequestBody Engagement e) {

		Engagement engagement = engagementRepo.updateEngagement(e);
		if (engagement != null) {
			return ApiResponse.getInstance().setCode(ApiResponseCode.SUCCESS)
					.addData("Updated Engagement", engagement);
		}
		return ApiResponse.getInstance().setCode(ApiResponseCode.FAILED)
				.addData("Update Engagement", null);
	}

	@DeleteMapping
	public ApiResponse deleteEngagement(@RequestBody Engagement e) {

		Engagement engagement = engagementRepo.deleteEngagement(e);
		if (engagement != null) // so deleted
			return ApiResponse.getInstance().setCode(ApiResponseCode.SUCCESS)
					.addData("Deleted Engagement", engagement);
		else
			return ApiResponse.getInstance().setCode(ApiResponseCode.NOT_FOUND)
					.addData("Deleted Engagement", null);
	}

}

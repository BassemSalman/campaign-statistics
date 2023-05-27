package com.project.CampaignStatistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.CampaignStatistics.model.ApiResponse;
import com.project.CampaignStatistics.model.ApiResponseCode;
import com.project.CampaignStatistics.repository.custom.CampaignCustomRepository;
import com.project.CampaignStatistics.repository.custom.EngagementCustomRepository;
import com.project.CampaignStatistics.service.URLService;

@RestController // linktrack-consultant
@RequestMapping("/requestlink") // needed to access this controller
public class RequestController {
	@Autowired
	EngagementCustomRepository engagementRepo;

	@Autowired
	CampaignCustomRepository campaignRepo;

	@Autowired
	URLService urlService;

	@Value("${myapp.url}")
	String appUrl;

	@Value("${base.url}")
	String baseUrl;


	@GetMapping("/")
	public String hello() {
		return "Hello";
	}

	// if already has token => no token generated
	@GetMapping("/{campaignId}/{MSISDN}")
	public ApiResponse requestLink(@PathVariable(name = "campaignId") int id,
			@PathVariable(name = "MSISDN") String msisdn) {
		String url = urlService.findUrl(id, msisdn, baseUrl, appUrl);

		if (url != null) {
			return ApiResponse.getInstance().setCode(ApiResponseCode.SUCCESS).addData("url", url);
		}
		return ApiResponse.getInstance().setCode(ApiResponseCode.BAD_REQUEST).addData("url", null);
	}
}

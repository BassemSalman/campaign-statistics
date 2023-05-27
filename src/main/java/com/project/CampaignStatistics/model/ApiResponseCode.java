package com.project.CampaignStatistics.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
//@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum ApiResponseCode {
	SUCCESS(200, "Success"), 
	BAD_REQUEST(400, "Bad Request"), 
	NOT_FOUND(404, "Not Found"),
    FAILED(501, "Failed");
	
	private int code;
	private String description;

}

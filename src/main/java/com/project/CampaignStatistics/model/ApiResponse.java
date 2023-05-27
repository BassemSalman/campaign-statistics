package com.project.CampaignStatistics.model;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import lombok.Getter;
@Component
@Getter
public class ApiResponse {
	private int code;
	private String description;
	private HashMap<String, Object> data;

	public static ApiResponse getInstance() {
		return new ApiResponse();
	}
	public ApiResponse setCode(ApiResponseCode responseCode) {
		this.code = responseCode.getCode();
		this.description = responseCode.getDescription();
		return this;
	}

	public ApiResponse addData(String key, Object value) {
		if (data == null)
			data = new HashMap<>();
		data.put(key, value);
		return this;
	}
}

package com.project.CampaignStatistics.service;

import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class URIValidationService {
	public static boolean isValidURL(String urlString) {
	    try {
	        URL url = new URL(urlString);
	        url.toURI();
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
}

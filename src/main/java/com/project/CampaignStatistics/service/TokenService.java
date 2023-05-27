package com.project.CampaignStatistics.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CampaignStatistics.repository.EngagementRepository;

@Service
public class TokenService {
	@Autowired
	EngagementRepository engagementRepo;

	public String generate(String phoneNumber) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(phoneNumber.getBytes());
			
			String hashed = bytesToHex(md.digest());
			String token = hashed.substring(0,7);
			
			int i = 0;
			while(engagementRepo.existsByToken(token)) { 
				token = hashed.substring(i, i+7); // shift right as long as it exists
				i++;
			}
			return token;			
		}
		catch (NoSuchAlgorithmException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b & 0xff)); 
            // %02x makes sure theres a minimum of 2 chars for each hex number
            // b & 0xff ensures it is positive
        }
        return sb.toString();
    }
}

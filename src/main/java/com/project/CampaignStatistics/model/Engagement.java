package com.project.CampaignStatistics.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Component

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


@Table(name="engagement")
public class Engagement {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private int engagementId;
	
	@Column(name="MSISDN")
	private String msisdn;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="campaign_id")
	private Campaign campaign;
	
	@Column(name="token") 
	private String token;

	
	// remove engagement => remove auditTrail
//	@JsonIgnore
//	@OneToMany(mappedBy="auditEngagement", cascade=CascadeType.ALL)
//	private List<AuditTrail> auditTrails;
	
}

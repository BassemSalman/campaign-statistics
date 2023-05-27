package com.project.CampaignStatistics.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
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

@Table(name = "campaign")
public class Campaign {

	@Id
	@Column(name = "campaign_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "campaign_name")
	private String name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@CreationTimestamp
	@Column(name = "creation")
	private LocalDateTime creation;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "expiry")
	private LocalDateTime expiry;

	@Column(name = "url")
	private String url;

	@OneToMany(mappedBy = "campaign", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Engagement> engagements;

	// so that cascade works
	@JsonIgnore
	@OneToOne(mappedBy = "counterCampaign", cascade = CascadeType.ALL)
	private Counter counters;

//	@JsonIgnore
//	@OneToMany(mappedBy="auditCampaign", cascade=CascadeType.ALL)
//	private List<AuditTrail> auditTrails;

}

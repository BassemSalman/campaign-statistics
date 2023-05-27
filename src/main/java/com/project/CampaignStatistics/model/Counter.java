package com.project.CampaignStatistics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Component

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "counter")
public class Counter {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	int counterId;

	@OneToOne
	@JoinColumn(name = "campaign_id") // foreign key owner
	Campaign counterCampaign;

	@Column(name = "nb_requested")
	int requestedUrl;

	@Column(name = "nb_successful")
	int successfulClicks;

	@Column(name = "total_clicks")
	int totalClicks;
}
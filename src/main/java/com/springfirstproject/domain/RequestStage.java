package com.springfirstproject.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.springfirstproject.domain.enuns.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity(name = "request_stage")
public class RequestStage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 75, nullable = false)
	private String description;
	
	@Column(name = "realization_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date realizationDate;
	
	@Column(length = 12, nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestState state;
	
	@ManyToOne
	@JoinColumn(name = "request_id", nullable = false)
	private Request request;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	
}
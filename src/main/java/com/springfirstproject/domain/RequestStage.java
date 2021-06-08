package com.springfirstproject.domain;

import java.util.Date;

import com.springfirstproject.domain.enuns.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RequestStage {
	private Long id;
	private String description;
	private Date realizationDate;
	private RequestState state;
	private Request request;
	private User user;
	
}

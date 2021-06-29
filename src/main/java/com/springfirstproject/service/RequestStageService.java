package com.springfirstproject.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springfirstproject.domain.RequestStage;
import com.springfirstproject.domain.enuns.RequestState;
import com.springfirstproject.exception.NotFoundException;
import com.springfirstproject.repository.RequestRepository;
import com.springfirstproject.repository.RequestStageRepository;

@Service
public class RequestStageService {
	
	@Autowired private RequestStageRepository requestStageRepository;
	@Autowired private RequestRepository requestRepository;
	
	public RequestStage save(RequestStage stage) {
		
		stage.setRealizationDate(new Date());
		RequestStage createdRequestStage = requestStageRepository.save(stage);
		
		Long requestId = stage.getRequest().getId();
		RequestState state = stage.getState();
		
		requestRepository.updateStatus(requestId, state);
		return createdRequestStage;
	}
	
	public RequestStage getById(Long id) {
		Optional<RequestStage> result = requestStageRepository.findById(id);
		return result.orElseThrow(()-> new NotFoundException("There are not request stage with id = " + id));
	}
	
	public List<RequestStage> listAllByRequestId(Long requestId) {
		List<RequestStage> stages = requestStageRepository.findAllByRequestId(requestId);
		return stages;
	}
	
	

}

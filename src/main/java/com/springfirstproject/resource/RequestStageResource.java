package com.springfirstproject.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springfirstproject.domain.Request;
import com.springfirstproject.domain.RequestStage;
import com.springfirstproject.service.RequestService;
import com.springfirstproject.service.RequestStageService;

@RestController
@RequestMapping(value = "stages")
public class RequestStageResource {
	@Autowired private RequestStageService stageService;
	
	@PostMapping
	public ResponseEntity<RequestStage> save(@RequestBody RequestStage requestStage) {
		RequestStage createdStage = stageService.save(requestStage);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdStage);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RequestStage> getById(@PathVariable(name = "id") Long id) {
		RequestStage requestStage = stageService.getById(id);
		return ResponseEntity.ok(requestStage);
		
	}

}

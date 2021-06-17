package com.springfirstproject.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springfirstproject.domain.Request;
import com.springfirstproject.domain.RequestStage;
import com.springfirstproject.domain.User;
import com.springfirstproject.domain.enuns.RequestState;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class RequestStageRepositoryTests {
	
	@Autowired private RequestStageRepository requestStageRepository;
	
	@Test
	public void AsaveTest() {

		User owner = new User();
		owner.setId(6L);
		
		Request request = new Request();
		request.setId(2L);
		
		RequestStage stage = new RequestStage(null, "Fui comprado um novo laptop HP", new Date(), RequestState.CLOSED, request, owner);
		RequestStage createdStage = requestStageRepository.save(stage);
		
		assertThat(createdStage.getId()).isEqualTo(1L);
	}

	
	@Test
	public void getByIdTest() {
		
		Optional<RequestStage> result = requestStageRepository.findById(1L);
		RequestStage stage = result.get();
		
		assertThat(stage.getDescription()).isEqualTo("Fui comprado um novo laptop HP");
		
		
	}
	
	@Test
	public void listByRequestIdTest() {
		
		List<RequestStage> stages = requestStageRepository.findAllByRequestId(2L);
		assertThat(stages.size()).isEqualTo(3);
		
		
	}
	
}

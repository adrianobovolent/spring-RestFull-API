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
public class RequestRepositoryTests {
	
	@Autowired private RequestRepository requestRepository;
	
	@Test
	public void AsaveTest() {
		User owner = new User();
		owner.setId(6L);
		Request request = new Request(null, "Novo LapTop HP","Pretendo obter um novo LapTop HP", new Date(), RequestState.OPEN, owner, null);
		
		Request createdRequest = requestRepository.save(request);
		
		assertThat(createdRequest.getId()).isEqualTo(1L);
	}
	
	@Test
	public void updateTest() {
		
		User owner = new User();
		owner.setId(6L);
		Request request = new Request(2L, "Novo LapTop HP","Pretendo obter um novo LapTop HP com memória RAM de 64 GB", null, RequestState.OPEN, owner, null);
		
		Request updatedRequest = requestRepository.save(request);
		
		assertThat(updatedRequest.getId()).isEqualTo("Pretendo obter um novo LapTop HP com memória RAM de 64 GB");
		
	}
	
	@Test
	public void getByIdTest() {
		
		Optional<Request> result = requestRepository.findById(2L);
		Request request = result.get();
		
		assertThat(request.getSubject()).isEqualTo("Novo LapTop HP");
		
	}
	
	@Test
	public void listTest() {
		
		List<Request> requests = requestRepository.findAll();
		assertThat(requests.size()).isEqualTo(1);
		
		
	}
	
	@Test
	public void listByOwnerIdTest() {
		
		List<Request> requests = requestRepository.findAllByOwnerId(6L);
		assertThat(requests.size()).isEqualTo(1);
		
		
	}
	
	@Test
	public void updateStatusTests() {
		
		int affectedRows = requestRepository.updateStatus(2L, RequestState.IN_PROGRESS);
		assertThat(affectedRows).isEqualTo(1);
		
	}
	
	
	

}

package com.springfirstproject.repository;

import java.util.Date;

import org.junit.FixMethodOrder;
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
	
	public void saveTest() {
		User owner = new User();
		owner.setId(1L);
		Request request = new Request(null, "Novo LapTop HP","Pretendo obter um novo LapTop HP", new Date(), RequestState.OPEN, owner, null);
		
		requestRepository.save(request);
	}

}

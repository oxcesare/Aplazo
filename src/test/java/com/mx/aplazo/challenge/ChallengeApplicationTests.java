package com.mx.aplazo.challenge;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mx.aplazo.challenge.component.SimpleInterestComponent;
import com.mx.aplazo.challenge.dto.SimpleInterestResponseDTO;

public class ChallengeApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(ChallengeApplicationTests.class);

	
	@InjectMocks
	SimpleInterestComponent simpleInterestComponent;
	
	
	public ChallengeApplicationTests() {
		// TODO Auto-generated constructor stub
	}

	@BeforeAll
	static void setup() {
		logger.info("@BeforeAll");
	}

	@BeforeEach
	void init() {
		logger.info("@BeforeEach");
	}

	@DisplayName("Test Spring Integration")
	@Test
	public void test() {

		SimpleInterestResponseDTO simpleInterestResponseDTO = new SimpleInterestResponseDTO();
		simpleInterestResponseDTO.setAmount(55.05);
		simpleInterestResponseDTO.setPayment_date("2022-01-05");
		simpleInterestResponseDTO.setPayment_number(1);
		
		List<SimpleInterestResponseDTO> lsWeeksOfPaysTest = new ArrayList<SimpleInterestResponseDTO>();
		lsWeeksOfPaysTest.add(simpleInterestResponseDTO);
		
	    Mockito.when(simpleInterestComponent.calculateWeeksOfPay(55.05, 0.05, 5)).then((Answer<?>) lsWeeksOfPaysTest);
		
		assertEquals(5, lsWeeksOfPaysTest.size());

	}

}

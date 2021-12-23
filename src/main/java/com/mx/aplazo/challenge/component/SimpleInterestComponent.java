package com.mx.aplazo.challenge.component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.aplazo.challenge.dto.SimpleInterestDTO;
import com.mx.aplazo.challenge.dto.SimpleInterestResponseDTO;
import com.mx.aplazo.challenge.entity.SimpleInterestEntity;
import com.mx.aplazo.challenge.repository.SimpleInterestRepository;

@Component
public class SimpleInterestComponent {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleInterestComponent.class);
	
	SimpleInterestRepository simpleInterestRepository;
	
	@Autowired
	SimpleInterestComponent(SimpleInterestRepository simpleInterestRepository) {
	    this.simpleInterestRepository=simpleInterestRepository;
	}
	
	
	public  List<SimpleInterestResponseDTO> calculateWeeksOfPay(double cantidad, double rate,Integer termino) {

		LocalDateTime localDateTime                    = LocalDateTime.now();
		LocalDate localDate                            = localDateTime.toLocalDate();
		LocalDate returnvalue 						   = null;
		List<SimpleInterestResponseDTO> lsWeeksOfPays  = new ArrayList<SimpleInterestResponseDTO>();
		SimpleInterestResponseDTO payments 			   = new SimpleInterestResponseDTO();
		SimpleInterestDTO         request              = new SimpleInterestDTO();
		SimpleInterestEntity      saveInfo             = new SimpleInterestEntity();
		double interesCalculado                        = cantidad*rate;
		double amount                                  = 0.00;
		int x                                          = 1;
		LocalDate date                                 = LocalDate.parse(localDate.toString());
		int semanas                                    = termino;
		int dias                                       = 7;
		String req                                     = "";
		String rep                                     = "";

		
		try {
		
			req = createJsonRequest(cantidad, rate, termino, request);
			while (semanas > 0) {

				returnvalue = date.plusDays(dias);

				System.out.println("Dias de Pago" + " " + returnvalue);

				semanas--;
				dias += 7;

				amount = cantidad + interesCalculado;

				payments = new SimpleInterestResponseDTO();
				
				payments.setPayment_number(x++);
				payments.setAmount(amount);
				payments.setPayment_date(returnvalue.toString());
				lsWeeksOfPays.add(payments);
			
			}
			rep = createJsonResponse(lsWeeksOfPays);
			saveInfo.setFechaOperacion(new Date());
			saveInfo.setRequest(req);
			saveInfo.setResponse(rep);
			simpleInterestRepository.save(saveInfo);
			
		} catch (Exception e) {
		     throw new SimpleInterestException ("No se puede realizar el calculo");
		}
		
		return lsWeeksOfPays;

	}


	private String createJsonRequest(double cantidad, double rate, Integer termino, SimpleInterestDTO request) {
		
		request.setAmount(cantidad);
		request.setRate(rate);
		request.setTerms(termino);

		String json="";
		
		ObjectMapper mapper = new ObjectMapper();
		try {
		  json = mapper.writeValueAsString(request);
		  logger.info("{Request }"+""+json);
		} catch (JsonProcessingException e) {
		   e.printStackTrace();
		}
		
		return json;
	}
	
	
	private String createJsonResponse(List<SimpleInterestResponseDTO> lsWeeksOfPays) {
		
		String json="";
		ObjectMapper mapper = new ObjectMapper();
		try {
		  json = mapper.writeValueAsString(lsWeeksOfPays);
		  logger.info("{ Response }"+""+json);
		} catch (JsonProcessingException e) {
		   e.printStackTrace();
		}
		
		return json;
	}
	

}

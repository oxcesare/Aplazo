package com.mx.aplazo.challenge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.aplazo.challenge.component.SimpleInterestComponent;
import com.mx.aplazo.challenge.dto.SimpleInterestDTO;
import com.mx.aplazo.challenge.dto.SimpleInterestResponseDTO;

@RestController
@RequestMapping("/calculate")
public class SimpleInterestController {
	
	
	SimpleInterestComponent simpleInterestComponent;
	
	@Autowired
	SimpleInterestController(SimpleInterestComponent simpleInterestComponent) {
		this.simpleInterestComponent=simpleInterestComponent;
	}

	@GetMapping("/info")
	public String hello() {
		return "Examen Aplazo -  22 Diciembre 2021 -  Version 1.0 " + "  " + "Autor: M.I.S. César Ricardo Alducin Ruiz";
	}
	
	@PostMapping("/payments")
	public ResponseEntity<?> saveTransaction(@RequestBody SimpleInterestDTO simpleInterestDTO) {
		
		List<SimpleInterestResponseDTO> lsPayments = new ArrayList<>();

		try {
			lsPayments = simpleInterestComponent.calculateWeeksOfPay(simpleInterestDTO.getAmount(), simpleInterestDTO.getRate(), simpleInterestDTO.getTerms());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(lsPayments);
		}

		return ResponseEntity.status(HttpStatus.OK).body(lsPayments);
	}

	
	
	
	
}

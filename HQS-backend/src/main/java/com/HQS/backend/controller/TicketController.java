package com.HQS.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HQS.backend.domain.Ticket;
import com.HQS.backend.service.TicketService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	public TicketService service;

	public TicketController(TicketService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/readAll")
	public ResponseEntity<List<Ticket>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}
}

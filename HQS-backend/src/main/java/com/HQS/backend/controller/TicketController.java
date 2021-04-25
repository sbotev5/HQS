package com.HQS.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HQS.backend.domain.Ticket;
import com.HQS.backend.service.TicketService;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	public TicketService service;

	public TicketController(TicketService service) {
		super();
		this.service = service;
	}

	@GetMapping("/tickets")
	public ResponseEntity<List<Ticket>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}

	@GetMapping("/tickets/{id}")
	public ResponseEntity<Ticket> readById(@PathVariable int id) {
		return ResponseEntity.ok(this.service.readById(id));
	}

	@PostMapping("/tickets")
	public ResponseEntity<Ticket> create(@RequestBody Ticket ticket) {
		return new ResponseEntity<>(this.service.create(ticket), HttpStatus.CREATED);
	}

	@PutMapping("/tickets/{id}")
	public ResponseEntity<Ticket> update(@PathVariable Long id, @RequestBody Ticket ticket) {
		return new ResponseEntity<>(this.service.updateById(id, ticket), HttpStatus.OK);
	}

	@DeleteMapping("/tickets/{id}")
	public ResponseEntity<Ticket> delete(@PathVariable Long id) {
		this.service.deleteById(id);
		return ResponseEntity.noContent().build();

	}

}

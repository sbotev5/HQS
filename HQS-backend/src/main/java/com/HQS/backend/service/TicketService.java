package com.HQS.backend.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HQS.backend.domain.Ticket;
import com.HQS.backend.repository.TicketRepository;


@Service
public class TicketService {

	@Autowired
	TicketRepository repository;

	public TicketService(TicketRepository repository) {
		super();
		this.repository = repository;
	}

	public List<Ticket> readAll() {
		return this.repository.findAll();
	}
	
	public Ticket readById(long id) {
		Optional<Ticket> ticket = this.repository.findById(id);
		return ticket.get();
	}

	public Ticket create(Ticket ticket) {
		return this.repository.save(ticket);
	}

	public Ticket updateById(Long id, Ticket newValues) {
		Ticket toUpdate = this.repository.findById(id).orElseThrow(EntityNotFoundException::new);

		toUpdate.setAuthor(newValues.getAuthor());
		toUpdate.setTitle(newValues.getTitle());
		toUpdate.setDescription(newValues.getDescription());
		toUpdate.setUrgency(newValues.getUrgency());
		toUpdate.setSolution(newValues.getSolution());
		return this.repository.save(toUpdate);
	}

}
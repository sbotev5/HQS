package com.HQS.backend.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.HQS.backend.domain.Ticket;
import com.HQS.backend.repository.TicketRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TicketServiceIntegrationTest {

	@Autowired
	private TicketService service;

	@Autowired
	private TicketRepository repo;
	
	@Test 
	void testTicketOverridenMethods() {
		Ticket ticket1 = new Ticket(1, "t1", "a1", "d1", 1, "sol1", "tc1");
		Ticket ticket2 = new Ticket(2, "t2", "a2", "d2", 2, "sol2", "tc2");
		
		Ticket ticket1Clone = new Ticket(1, "t1", "a1", "d1", 1, "sol1", "tc1");

		Assertions.assertThat(ticket1).isEqualTo(ticket1Clone);
		Assertions.assertThat(ticket1).isNotEqualTo(ticket2);

		Assertions.assertThat(ticket1.hashCode()).isEqualTo(ticket1Clone.hashCode());
		Assertions.assertThat(ticket1.hashCode()).isNotEqualTo(ticket2.hashCode());

		Assertions.assertThat(ticket1.toString()).isEqualTo(ticket1Clone.toString());
		Assertions.assertThat(ticket1.toString()).isNotEqualTo(ticket2.toString());

		Assertions.assertThat(ticket1.getId()).isEqualTo(ticket1Clone.getId());
		Assertions.assertThat(ticket1.getTitle()).isEqualTo(ticket1Clone.getTitle());
		Assertions.assertThat(ticket1.getAuthor()).isEqualTo(ticket1Clone.getAuthor());
		Assertions.assertThat(ticket1.getDescription()).isEqualTo(ticket1Clone.getDescription());
		Assertions.assertThat(ticket1.getUrgency()).isEqualTo(ticket1Clone.getUrgency());
		Assertions.assertThat(ticket1.getSolution()).isEqualTo(ticket1Clone.getSolution());
		Assertions.assertThat(ticket1.getTimeCreated()).isEqualTo(ticket1Clone.getTimeCreated());
	}

	@Test
	void readAllTest() {
		Ticket ticket1 = new Ticket(1, "t1", "a1", "d1", 1, "sol1", "tc1");
		Ticket ticket2 = new Ticket(2, "t2", "a2", "d2", 2, "sol2", "tc2");
		List<Ticket> toSave = List.of(ticket1, ticket2);

		this.repo.saveAll(toSave);

		assertThat(this.service.readAll()).isEqualTo(toSave);
	}
}

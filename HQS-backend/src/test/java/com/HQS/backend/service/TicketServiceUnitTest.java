package com.HQS.backend.service;


import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;

import com.HQS.backend.domain.Ticket;
import com.HQS.backend.repository.TicketRepository;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TicketServiceUnitTest {

	@Autowired
	private TicketService service;

	@MockBean
	private TicketRepository repo;

	@Test
	// @Order(1)
	@Sql({ "/data.sql" })
	void testReadAll() {
		Ticket ticket1 = new Ticket(1L, "t1", "a1", "d1", 1, "sol1");
		Ticket ticket2 = new Ticket(2L, "t2", "a2", "d2", 2, "sol2");
		List<Ticket> expected = List.of(ticket1, ticket2);
		Mockito.when(this.repo.findAll()).thenReturn(expected);
		Assertions.assertThat(this.service.readAll()).isEqualTo(expected);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	// @Order(2)
	@Sql({ "/data.sql" })
	void testReadById() {
		Ticket expected = new Ticket(1L, "t1", "a1", "d1", 1, "sol1");
		Mockito.when(this.repo.findById(1L)).thenReturn(Optional.of(expected));
		System.out.println("CHECK THISSS!!!!!!!" + this.service.readById(1L).toString());
		Assertions.assertThat(this.service.readById(1L)).isEqualTo(expected);
		// Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	}

	@Test
	// @Order(2)
	@Sql({ "/data.sql" })
	void testCreated() {
		Ticket toSave = new Ticket(1L, "t1", "a1", "d1", 1, "sol1");
		Ticket saved = new Ticket(1L, "t1", "a1", "d1", 1, "sol1");
		Mockito.when(this.repo.save(toSave)).thenReturn(saved);
		Assertions.assertThat(this.service.create(toSave)).isEqualTo(saved);
		Mockito.verify(this.repo, Mockito.times(1)).save(toSave);
	}
}
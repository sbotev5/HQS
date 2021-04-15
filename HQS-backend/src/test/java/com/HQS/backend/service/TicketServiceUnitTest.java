package com.HQS.backend.service;


import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.HQS.backend.domain.Ticket;
import com.HQS.backend.repository.TicketRepository;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class TicketServiceUnitTest {

	@Autowired
	private TicketService service;

	@MockBean
	private TicketRepository repo;

	@Test
	void readAllTest() {
		Ticket ticket1 = new Ticket(1, "t1", "a1", "d1", 1, "sol1", "tc1");
		Ticket ticket2 = new Ticket(2, "t2", "a2", "d2", 2, "sol2", "tc2");
		List<Ticket> expected = List.of(ticket1, ticket2);
		Mockito.when(this.repo.findAll()).thenReturn(expected);
		Assertions.assertThat(this.service.readAll()).isEqualTo(expected);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
}
package com.HQS.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HQS.backend.domain.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}

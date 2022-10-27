package com.examen.service;
import com.examen.entity.Ticket;
import java.util.List;

public interface ITicketService {
    public List<Ticket> getAllTicket();
    public Ticket getTicketById(long id);
    public void saveTicket (Ticket ticket);
    public void delete(long id);
}

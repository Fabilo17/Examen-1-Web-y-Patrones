package com.examen.service;
import com.examen.entity.Ticket;
import com.examen.repository.TicketRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService{
    @Autowired
    private TicketRepository ticketRepository;
    
    @Override
    public List<Ticket> getAllTicket(){
        return(List<Ticket>) ticketRepository.findAll();
    }
    @Override
    public Ticket getTicketById(long id){
        return ticketRepository.findById(id).orElse(null);
    }
    @Override
    public void saveTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }
    @Override
    public void delete(long id){
        ticketRepository.deleteById(id);
    }
}

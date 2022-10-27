package com.examen.controller;
import com.examen.entity.Ticket;
import com.examen.service.ITicketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TicketController {
    @Autowired
    private ITicketService ticketService;
    
    @GetMapping("/tickets")
    public String index (Model model){
        List<Ticket> listaTicket = ticketService.getAllTicket();
        model.addAttribute("titulo", "Historial de Conciertos");
        model.addAttribute("tickets", listaTicket);
        return "tickets";
    }
    @GetMapping("/ticketN")
    public String crearTicket(Model model){
        model.addAttribute("tickets", new Ticket());
        return "crear";
    }
    @PostMapping("/save")
    public String guardarTicket(@ModelAttribute Ticket ticket){
        ticketService.saveTicket(ticket);
        return "redirect:/tickets";
    }
    @GetMapping("/editTicket/{id}")
    public String editarTicket(@PathVariable("id") Long idTicket, Model model){
        Ticket ticket = ticketService.getTicketById(idTicket);
        model.addAttribute("tickets", ticket);
        return "crear";
    }
    @GetMapping("/delete/{id}")
    public String eliminaTicket(@PathVariable("id") Long idTicket){
        ticketService.delete(idTicket);
        return "redirect:/tickets";
    }
}

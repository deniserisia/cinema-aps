package asimo.v.services;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import asimo.v.entities.Event;
import asimo.v.entities.Session;
import asimo.v.entities.Ticket;
import asimo.v.entities.User;
import asimo.v.entities.enums.EventStatus;
import asimo.v.entities.operation.SessionOperation;
import asimo.v.exceptions.InvalidEvent;
import asimo.v.repositories.SessionRepository;

@Service
public class SessionService {

    private SessionRepository sessionRepository;
    
	private TicketService ticketService;

	private EventService eventService;


	public SessionService(SessionRepository sessionRepository, TicketService ticketService, EventService eventService) {
		this.sessionRepository = sessionRepository;
		this.ticketService = ticketService;
		this.eventService = eventService;
	}

	public List<Session> listAllAvailable(){
    	List<Session> findAll = sessionRepository.findAll();
    	
    	return findAll.stream()
    			.filter(s -> s.getSessiosStatus() != EventStatus.FINALIZADO)
    			.collect(Collectors.toList());
    }

	public List<Session> listToFinalize(){
    	List<Session> sessions = sessionRepository.findBySessiosStatus(EventStatus.EM_ANDAMENTO);
    	
    	return sessions.stream()
    			.filter(s -> s.getSessionEndDate().before(new Date()))
    			.collect(Collectors.toList());
    }

	public List<Session> listToInitializer(){
    	List<Session> sessions = sessionRepository.findBySessiosStatus(EventStatus.AGENDADO);
    	
    	return sessions.stream()
    			.filter(s -> s.getSessionStartDate().before(new Date()))
    			.collect(Collectors.toList());
    }

	public Integer availableSeats(Session session) {
		List<Ticket> tickets = ticketService.findAllTicketsBySessionIdentifier(session.getSessionIdentifier());
		return tickets.stream
				().filter(t -> t.getOccupied() == true && Objects.equals(t.getUseridentifier(), null))
				.collect(Collectors.toList()).size();
	}
    public Session create(SessionOperation sessionOperation, User user) {
		if(user.isAdmin()){
			validateCreationSession(sessionOperation);
			Event event = eventService.findByEventIdentifier(sessionOperation.getEventIdentifier());

			Session session = new Session(sessionOperation ,event);
			sessionRepository.save(session);
			ticketService.generateSessionTicket(session.getNumberOfSeats(),event.getEventIdentifier(), session.getSessionIdentifier());
			return session;
		}
		throw new RuntimeException("Você não pode criar.");
    }

	public Session findBySessionIdentifier(String sessionIdentifier){
		Optional<Session> session = this.sessionRepository.findBySessionIdentifier(sessionIdentifier);
		if (session.isPresent()) {
			return session.get();
		}
		throw new RuntimeException("Sessão não encontrada");
	}

	private void validateCreationSession(SessionOperation sessionOperation) {
		Event event = eventService.findByEventIdentifier(sessionOperation.getEventIdentifier());
		if (sessionRepository.findByEventAndSessionStartDate(event,sessionOperation.getSessionStartDate()).isPresent()) {
			throw new InvalidEvent("Sessão Inválida");
		}
	}
}

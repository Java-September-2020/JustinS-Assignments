package com.EventsBeltReviewer.justin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EventsBeltReviewer.justin.models.Events;
import com.EventsBeltReviewer.justin.repositories.EventRepository;

@Service
public class EventsService {
	@Autowired
	private EventRepository ERepo;
	
	public Events findEvent(Long id) {
	Events events = this.ERepo.findById(id).orElse(null);
	
	return events;
	}
	
	public List<Events> allEvents(){
		return this.ERepo.findAll();
		}
	
	
}
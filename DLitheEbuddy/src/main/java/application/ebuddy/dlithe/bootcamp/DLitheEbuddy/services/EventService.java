package application.ebuddy.dlithe.bootcamp.DLitheEbuddy.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model.Event;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.repositories.EventRepo;

@Service
public class EventService
{
	@Autowired
	EventRepo erepo;
	
	public Event addEvent(Event object)
	{
		return erepo.save(object);
	}
	
	public List<Event> getEventsByAvailable()
	{
		
		List<Event> tmp=erepo.findAll(); List<Event> hai=new ArrayList<Event>();
		for(Event t: tmp) 
		{ 
			if(!(t.getEventEnded().before(new Date()))) 
			{ 
				hai.add(t);
			} 
		} 
		return hai;
		
		//return erepo.findAllByAvailable();
	}
}

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
	
	public String remove(Integer id)
	{
		String info=getByIdentity(id).getEventName();
		erepo.deleteById(id);
		System.out.println("Deleted in service");
		return info;
	}
	
	public Event getByIdentity(Integer id)
	{
		return erepo.findById(id).orElse(new Event());
	}
	
	public List<Event> every()
	{
		return erepo.findAll();
	}
	
	public List<Event> getEventsByPast()
	{
		return erepo.findAllByPast();
	}
	
	public List<Event> getEventsByExpert(String expert)
	{
		return erepo.findAllByEventExpert(expert);
	}
	
	public List<Event> getEventsByNameMatch(String name)
	{
		return erepo.findAllByEventName(name);
	}
	
	public void alterStatus()
	{
		List<Event> temp=getEventsByPast();
		for(Event one:temp)
		{
			one.setEventStatus("past");
			addEvent(one);
		}
	}
	
	public List<Event> getEventsByAvailable()
	{
		
		/*
		 * List<Event> tmp=erepo.findAll(); List<Event> hai=new ArrayList<Event>();
		 * for(Event t: tmp) { if(!(t.getEventEnded().before(new Date()))) { hai.add(t);
		 * } } return hai;
		 */
		
		return erepo.findAllByAvailable();
	}
}

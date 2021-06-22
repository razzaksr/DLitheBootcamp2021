package application.ebuddy.dlithe.bootcamp.DLitheEbuddy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model.Event;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model.Students;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.repositories.StudentsRepo;

@Service
public class StudentsService 
{
	@Autowired
	StudentsRepo srepo;
	
	public String remove(Integer id)
	{
		String  info=getViaId(id).getStudentName();
		srepo.deleteById(id);
		return info+" has deleted";
	}
	
	public String multipleDelete(Integer id)
	{
		List<Students> tmp = getByEventId(id);
		
		srepo.deleteAll(tmp);
		
		return "done";
	}
	
	public Students addStudent(Students object)
	{
		return srepo.save(object);
	}
	
	public List<Students> getByEvent(Event event)
	{
		return srepo.findAllByEvent(event);
	}
	
	public List<Students> getByEventId(Integer id)
	{
		return srepo.findAllByEventEventId(id);
	}
	
	public Students getViaId(Integer id)
	{
		return srepo.findById(id).orElse(new Students());
	}
}

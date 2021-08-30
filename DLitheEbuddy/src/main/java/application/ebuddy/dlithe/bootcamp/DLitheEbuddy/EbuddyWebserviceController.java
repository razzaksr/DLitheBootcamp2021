package application.ebuddy.dlithe.bootcamp.DLitheEbuddy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model.Event;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model.Students;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.services.EventService;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.services.StudentsService;


/*
 * GetMapping>> fetch
 * PostMapping>> insertion
 * PutMapping>> update
 * DeleteMapping>> delete
 */


@RestController
@RequestMapping("/ws")
@CrossOrigin(origins = "http://localhost:3000")
public class EbuddyWebserviceController 
{
	
	@Autowired
	EventService eserv;
	
	@Autowired
	StudentsService serv;
	
	@GetMapping("/")
	public List<Event> listAll()
	{
		return eserv.every();
	}
	@GetMapping(value = "/xml",produces = "application/xml")
	public List<Event> listAllAsXML()
	{
		return eserv.every();
	}
	@PostMapping(value="/new",consumes = "application/xml")
	public Event newEvent(@RequestBody Event event)
	{
		return eserv.addEvent(event);
	}
	@PostMapping("/new/json")
	public Event newEventAsJSON(@RequestBody Event event)
	{
		return eserv.addEvent(event);
	}
	
	@GetMapping("/studs")
	public List<Students> listStuds()
	{
		return serv.getAll();
	}
	
	@PostMapping("/studs/new")
	public Students newStudent(@RequestBody Students student)
	{
		int tmp=student.getEvent().getEventParticipants()+1;
		student.getEvent().setEventParticipants(tmp);
		student.setStudentCeriticate(false);
		return serv.addStudent(student);
	}
	
	@PutMapping("/edit")
	public Event updateEvent(@RequestBody Event event)
	{
		return eserv.addEvent(event);
	}
	
	@PutMapping("/studs/edit")
	public Students updateStudent(@RequestBody Students students)
	{
		return serv.addStudent(students);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEvent(@PathVariable("id") Integer id)
	{
		return eserv.remove(id);
	}
	
	@DeleteMapping("/studs/delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id)
	{
		return serv.remove(id);
	}
	
	@DeleteMapping("/studs/deletemany/{eid}")
	public String deleteMany(@PathVariable("eid") Integer eid)
	{
		return serv.multipleDelete(eid);
	}
	
}

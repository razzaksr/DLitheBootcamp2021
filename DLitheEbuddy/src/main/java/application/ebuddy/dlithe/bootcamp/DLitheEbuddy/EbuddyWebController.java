package application.ebuddy.dlithe.bootcamp.DLitheEbuddy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model.Event;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model.Students;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.services.EventService;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.services.StudentsService;

@Controller
public class EbuddyWebController 
{
	@Autowired
	EventService eserv;
	
	@Autowired
	StudentsService serv;
	
	@RequestMapping("/")
	public String open()
	{
		return "index";
	}
	
	@RequestMapping("/neweve")
	public String createEvent(Model model)
	{
		Event event=new Event();
		model.addAttribute("object", event);
		return "eventnew";
	}
	
	@RequestMapping(value="/sub",method=RequestMethod.POST)
	public String addingEvent(Model model, @ModelAttribute("object") Event object)
	{
		String name=eserv.addEvent(object).getEventName();
		model.addAttribute("eve", name+" is new event and it's about to start");
		return "eventnew";
	}
	
	@RequestMapping("/add")
	public String addPeople(Model model)
	{
		Students stu=new Students();
		model.addAttribute("student", stu);
		List<Event> news=eserv.getEventsByAvailable();
		model.addAttribute("available", news);
		return "peopleadd";
	}
	
	@RequestMapping(value="/enroll",method=RequestMethod.POST)
	public String addingPeople(Model model,@ModelAttribute("student") Students student)
	{
		//student.setEvent();
		serv.addStudent(student);
		model.addAttribute("info", student.getStudentName()+" enrolled");
		return "peopleadd";
	}
}

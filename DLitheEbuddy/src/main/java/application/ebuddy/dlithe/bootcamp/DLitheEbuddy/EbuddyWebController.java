package application.ebuddy.dlithe.bootcamp.DLitheEbuddy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		eserv.alterStatus();
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
		object.setEventStatus("live");
		object.setEventParticipants(0);
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
		int tmp=student.getEvent().getEventParticipants()+1;
		student.getEvent().setEventParticipants(tmp);
		student.setStudentCeriticate(false);
		serv.addStudent(student);
		model.addAttribute("info", student.getStudentName()+" enrolled");
		return "peopleadd";
	}
	
	
	@RequestMapping("/del/{id}")
	public String removePeople(Model model,@PathVariable("id") Integer id) 
	{
		Event eve = serv.getViaId(id).getEvent();
		eve.setEventParticipants(eve.getEventParticipants()-1);
		
		String info=serv.remove(id);
		model.addAttribute("msg", info);
		return update(model, eve);
	}
	
	@RequestMapping("/editstudent/{id}")
	public String editPeople(Model model,@PathVariable("id") Integer id)
	{
		Students stu = serv.getViaId(id);
		model.addAttribute("student", stu);
		return "editstudent";
	}
	
	@RequestMapping(value="/stuedit",method=RequestMethod.POST)
	public String editingPeople(Model model,@ModelAttribute("student") Students student)
	{
		serv.addStudent(student);
		model.addAttribute("info", student.getStudentName()+" updated");
		return listing(model);
	}
	
	@RequestMapping("/list")
	public String listing(Model model)
	{
		model.addAttribute("bulk", eserv.every());
		return "viewevents";
	}
	
	/*@RequestMapping("/students/{tmp}") 
	public String listingCandidates(Model model,@PathVariable("tmp") Event tmp) 
	{
	 	System.out.println("Receiving "+tmp+"  @ controller"); 
	 	List<Students> tmps = serv.getByEvent(tmp); 
	 	model.addAttribute("people", tmps); 
	 	return "viewstuds";
	}*/
	
	@RequestMapping("/students/{event}")
	public String listingCandidates(Model model,@PathVariable("event") Integer event)
	{
		//System.out.println("Receiving "+event+"  @ controller");
		List<Students> tmps = serv.getByEventId(event);
		model.addAttribute("people", tmps);
		return "viewstuds";
	}
	
	@RequestMapping("/shortlist")
	public String shortlist(Model model)
	{
		model.addAttribute("eves", eserv.every());
		return "filter";
	}
	
	@RequestMapping(value="/filter",method = RequestMethod.POST)
	public String finding(Model model, @RequestParam(required = false,value="status") String status,@RequestParam(required = false,value="expert") String expert,@RequestParam(required = false,value="tech") String tech)
	{
		//System.out.println(status+" "+expert+" "+tech);
		List<Event> object=null;
		if(status!=null&&expert.equals("Select Any Expert")&&tech=="")
		{
			if(status.equalsIgnoreCase("live"))
			{
				//System.out.println("Live will be generated");
				object=eserv.getEventsByAvailable();
				//System.out.println("Live events "+object);
			}
			else
			{
				//System.out.println("Past will be generated");
				object=eserv.getEventsByPast();
				//System.out.println("Past events "+object);
			}
		}
		else if(status==null&&!expert.equals("Select Any Expert")&&tech=="")
		{
			object=eserv.getEventsByExpert(expert);
		}
		else if(status==null&&expert.equals("Select Any Expert")&&tech!="")
		{
			object=eserv.getEventsByNameMatch(tech);
		}
		model.addAttribute("bulk", object);
		return "viewevents";
	}
	
	@RequestMapping("/offer/{id}")
	public String updateCertificate(Model model,@PathVariable("id") Integer id)
	{
		Students obj=serv.getViaId(id);
		
		if(obj.getStudentCeriticate()==false&&!(eserv.getEventsByAvailable().contains(obj.getEvent())))
		{
			obj.setStudentCeriticate(true);
			serv.addStudent(obj);
		}
		model.addAttribute("bulk",eserv.every());
		return "viewevents";
	}
	
	@RequestMapping("/edit/{id}")
	public String letEdit(Model model,@PathVariable("id") Integer id)
	{
		Event eve=eserv.getByIdentity(id);
		model.addAttribute("object", eve);
		return "edit";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Model model, @ModelAttribute("object") Event object)
	{
		Date date1=object.getEventStarted();
		Date date2=object.getEventEnded();
		
		SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
		object.setEventStarted(new Date(formatter.format(date1)));
		object.setEventEnded(new Date(formatter.format(date2)));
		
		String name = eserv.addEvent(object).getEventName();
		model.addAttribute("msg", name+" updated successfully");
		return listing(model);
	}
	
	@RequestMapping("/erase/{id}")
	public String erasing(Model model,@PathVariable("id") Integer id)
	{
		System.out.println("REceived id "+id);
		
		if(serv.multipleDelete(id).equals("done")) 
		{
			String msg= eserv.remove(id);
			model.addAttribute("msg", msg);
		}
		return listing(model);
	}
	
}

package application.web.dlithe.bootcamp.DLitheBoot.DLitheBoot;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController 
{
	@Autowired
	StoreRepository store;
	
	@RequestMapping(value="/simple",method=RequestMethod.GET)
	public String simple()
	{
		return "greeting";
	}
	@RequestMapping("/sample")
	public String sample(Model model)
	{
		model.addAttribute("resource","Prasad");
		return "demosample";
	}
	
	@RequestMapping("/view")
	public String display(Model model)
	{
		ArrayList<Store> every=new ArrayList<Store>();
		store.findAll().forEach(every::add);
		model.addAttribute("all", every);
		return "mylist";
	}
}

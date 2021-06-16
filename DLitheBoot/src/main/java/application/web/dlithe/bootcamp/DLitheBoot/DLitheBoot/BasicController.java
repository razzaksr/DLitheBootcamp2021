package application.web.dlithe.bootcamp.DLitheBoot.DLitheBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController 
{
	@RequestMapping(value="/simple",method=RequestMethod.GET)
	public String simple()
	{
		return "greeting";
	}
}

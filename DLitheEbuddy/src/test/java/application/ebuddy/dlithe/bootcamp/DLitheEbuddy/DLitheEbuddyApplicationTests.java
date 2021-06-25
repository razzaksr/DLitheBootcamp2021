package application.ebuddy.dlithe.bootcamp.DLitheEbuddy;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model.Event;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model.Students;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.repositories.EventRepo;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.repositories.StudentsRepo;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.services.EventService;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.services.StudentsService;

@SpringBootTest
@RunWith(SpringRunner.class)
class DLitheEbuddyApplicationTests 
{
	@MockBean
	EventRepo erepo;
	@MockBean
	StudentsRepo srepo;
	
	@Autowired
	EventService eserv;
	@Autowired
	StudentsService serv;
	
	@Test
	public void testCreateEvent()
	{
		Event eve1=new Event(91, "Internship", new Date("06/01/2021"), new Date("06/25/2021"), "Razak Mohamed S", "Google Meet", 30, 0, "live");
		Event eve2=new Event(11, "Hackathon", new Date("06/01/2021"), new Date("06/25/2021"), "Razak Mohamed S", "Google Meet", 30, 0, "live");
		when(erepo.save(eve1)).thenReturn(eve1);
		when(erepo.save(eve2)).thenReturn(eve2);
		assertEquals(eve1,eserv.addEvent(eve1));
		assertSame(eve2,eserv.addEvent(eve2));
	}
	
	@Test
	public void testAddStudent()
	{
		Event eve1=new Event(91, "Internship", new Date("06/01/2021"), new Date("06/25/2021"), "Razak Mohamed S", "Google Meet", 30, 0, "live");
		Students stud1=new Students(102, "Prasad", "Reva", eve1, 98765678876L, "prasad@gmail.com", false);
		Students stud2=new Students(101, "Ganavi", "Reva", eve1, 1234543234L, "ganavi@gmail.com", true);
		when(erepo.save(eve1)).thenReturn(eve1);
		when(srepo.save(stud1)).thenReturn(stud1);
		
		//assertTrue(serv.addStudent(stud1).getStudentCeriticate());
		Assert.assertFalse(serv.addStudent(stud1).getStudentCeriticate());
		
		//Assert.assertNotNull(serv.addStudent(stud2));
		
		Assert.assertNull(serv.addStudent(stud2));
	}
	
	@Test
	public void testEvents()
	{
		Event eve1=new Event(91, "Internship", new Date("06/01/2021"), new Date("06/25/2021"), "Razak Mohamed S", "Google Meet", 30, 0, "live");
		Event eve2=new Event(11, "Hackathon", new Date("06/01/2021"), new Date("06/25/2021"), "Sridhar", "Google Meet", 30, 0, "live");
		Event eve3=new Event(874, "Bootcamp", new Date("03/05/2021"), new Date("03/20/2021"), "Arun", "Google Meet", 30, 0, "live");
		Event eve4=new Event(3, "Mock Interview", new Date("01/10/2021"), new Date("01/25/2021"), "Sobin", "Google Meet", 30, 0, "live");
		when(erepo.findAll()).thenReturn(Stream.of(eve1,eve2,eve3,eve4).collect(Collectors.toList()));
		
		Assert.assertTrue(eserv.every().size()>=3);
		
		Assert.assertNotSame(eve3, eserv.every().get(0));
	}
	
	@Test
	public void testDeleteEvent()
	{
		Event eve1=new Event(91, "Internship", new Date("06/01/2021"), new Date("06/25/2021"), "Razak Mohamed S", "Google Meet", 30, 0, "live");
		Event eve2=new Event(11, "Hackathon", new Date("06/01/2021"), new Date("06/25/2021"), "Sridhar", "Google Meet", 30, 0, "live");
		Event eve3=new Event(874, "Bootcamp", new Date("03/05/2021"), new Date("03/20/2021"), "Arun", "Google Meet", 30, 0, "live");
		Event eve4=new Event(3, "Mock Interview", new Date("01/10/2021"), new Date("01/25/2021"), "Sobin", "Google Meet", 30, 0, "live");
		when(erepo.save(eve1)).thenReturn(eve1);when(erepo.save(eve2)).thenReturn(eve2);
		when(erepo.save(eve4)).thenReturn(eve3);when(erepo.save(eve4)).thenReturn(eve4);
		
		//verify(erepo,times(1)).delete(eve1);
		
		//assertEquals("Internship", eserv.remove(91));
	}
}

package application.ebuddy.dlithe.bootcamp.DLitheEbuddy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model.Students;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.repositories.StudentsRepo;

@Service
public class StudentsService 
{
	@Autowired
	StudentsRepo srepo;
	
	public Students addStudent(Students object)
	{
		return srepo.save(object);
	}
}

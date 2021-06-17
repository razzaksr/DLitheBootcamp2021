package application.ebuddy.dlithe.bootcamp.DLitheEbuddy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model.Students;

@Repository
public interface StudentsRepo extends JpaRepository<Students, Integer>
{
	
}

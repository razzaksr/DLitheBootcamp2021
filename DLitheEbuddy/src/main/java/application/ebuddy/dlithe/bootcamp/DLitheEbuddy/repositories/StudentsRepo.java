package application.ebuddy.dlithe.bootcamp.DLitheEbuddy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model.Event;
import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model.Students;

@Repository
public interface StudentsRepo extends JpaRepository<Students, Integer>
{
	public List<Students> findAllByEvent(Event object);
	public List<Students> findAllByEventEventId(Integer id);
}

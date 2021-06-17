package application.ebuddy.dlithe.bootcamp.DLitheEbuddy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model.Event;

@Repository
public interface EventRepo extends JpaRepository<Event, Integer>
{
	/*
	 * @Query("from Event where eventEnded >= new Date()") public List<Event>
	 * findAllByAvailable();
	 */
}

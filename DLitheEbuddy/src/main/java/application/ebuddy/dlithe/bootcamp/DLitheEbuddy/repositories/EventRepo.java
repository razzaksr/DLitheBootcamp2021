package application.ebuddy.dlithe.bootcamp.DLitheEbuddy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import application.ebuddy.dlithe.bootcamp.DLitheEbuddy.model.Event;

@Repository
public interface EventRepo extends JpaRepository<Event, Integer>
{
	
	 @Query("from Event where eventEnded >= current_date")
	 // select * from event where event_ended >= currentdate()
	 public List<Event> findAllByAvailable();
	 
	 @Query("from Event where eventEnded < current_date")
	 public List<Event> findAllByPast();
	 
	 public List<Event> findAllByEventExpert(String expert);
	 
	 
		/*
		 * @Query("update Event set eventStatus='past' where eventEnded < current_date")
		 * public void updateByEnded();
		 */
}

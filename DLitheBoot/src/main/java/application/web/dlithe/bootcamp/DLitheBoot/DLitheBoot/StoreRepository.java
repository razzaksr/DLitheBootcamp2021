package application.web.dlithe.bootcamp.DLitheBoot.DLitheBoot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer>
{
	
}

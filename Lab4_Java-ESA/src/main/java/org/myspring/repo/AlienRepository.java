package org.myspring.repo;

import org.myspring.model.Alien;
import org.springframework.data.repository.CrudRepository;

public interface AlienRepository extends CrudRepository<Alien,Integer> {
}

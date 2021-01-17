package org.spring.repo;

import org.spring.model.Alien;
import org.springframework.data.repository.CrudRepository;

public interface AlienRepository extends CrudRepository<Alien,Integer> {
}

package org.spring.repo;

import org.spring.model.Race;
import org.springframework.data.repository.CrudRepository;

public interface RaceRepository extends CrudRepository<Race,Integer> {
}

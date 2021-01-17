package org.myspring.repo;

import org.myspring.model.Race;
import org.springframework.data.repository.CrudRepository;

public interface RaceRepository extends CrudRepository<Race,Integer> {
}

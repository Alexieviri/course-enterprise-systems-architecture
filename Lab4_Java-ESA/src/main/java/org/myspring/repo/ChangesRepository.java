package org.myspring.repo;

import org.myspring.model.Change;
import org.springframework.data.repository.CrudRepository;

public interface ChangesRepository extends CrudRepository<Change,Integer> {
}

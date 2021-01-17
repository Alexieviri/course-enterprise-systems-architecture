package org.myspring.repo;

import org.myspring.model.Email;
import org.springframework.data.repository.CrudRepository;

public interface EmailsRepository extends CrudRepository<Email, Integer> {
}

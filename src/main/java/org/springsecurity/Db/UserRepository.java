package org.springsecurity.Db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springsecurity.Model.User;

public interface UserRepository extends MongoRepository<User, Long> {
	User findByUsername(String username);

}

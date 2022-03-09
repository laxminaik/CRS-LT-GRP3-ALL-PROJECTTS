package com.crs.lt.repository;

import com.crs.lt.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserId(String userId);

 //   boolean save(User user);
    
    
}

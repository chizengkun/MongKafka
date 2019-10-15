package com.ksboot.mongd.demo.dao;

import com.ksboot.mongd.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,Long> {
    //@Query(value="{'name':?0}",fields="{'name':1}")
    public Page<User> findByNameLike(String name, Pageable pageable);
}

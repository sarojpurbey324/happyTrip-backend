package com.verscend.HappyTrip.Entity.Repository;

import org.springframework.data.repository.CrudRepository;

import com.verscend.HappyTrip.Entity.UserQuery;

public interface UserMessageRepository extends CrudRepository<UserQuery,Integer>{

}

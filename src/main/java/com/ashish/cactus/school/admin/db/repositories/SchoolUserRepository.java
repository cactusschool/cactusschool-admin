package com.ashish.cactus.school.admin.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.admin.db.model.SchoolUser;

@Component
public interface SchoolUserRepository extends CrudRepository <SchoolUser, Integer>{
}

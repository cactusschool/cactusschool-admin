package com.ashish.cactus.school.admin.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.admin.db.model.SchoolMaster;
import com.ashish.cactus.school.admin.db.model.User;

@Component
public interface SchoolMasterRepository extends CrudRepository <SchoolMaster, Long>{
}

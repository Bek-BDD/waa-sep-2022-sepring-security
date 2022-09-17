package com.example.springsecurity.Repository;


import com.example.springsecurity.Model.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog,Integer> {
}

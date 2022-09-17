package com.example.springsecurity.Service;

import com.example.springsecurity.Model.ActivityLog;

import java.util.List;

public interface ActivityLogService {
    public List<ActivityLog> findAll();
    public ActivityLog findById(int id);
    public ActivityLog addActivity(ActivityLog activityLog);

}

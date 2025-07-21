package com.example.selfstudyroom.model;

import java.time.LocalDateTime;

public class AccessPermission {
    private String userId;
    private String location;
    private String serviceType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public AccessPermission() {
    }

    public AccessPermission(String userId, String location, String serviceType, LocalDateTime startTime, LocalDateTime endTime) {
        this.userId = userId;
        this.location = location;
        this.serviceType = serviceType;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}

package com.example.selfstudyroom.service;

import com.example.selfstudyroom.model.AccessPermission;
import com.example.selfstudyroom.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    private final PermissionRepository repository;

    public PermissionService(PermissionRepository repository) {
        this.repository = repository;
    }

    public void addPermission(AccessPermission permission) {
        repository.addPermission(permission);
    }

    public List<AccessPermission> getPermissionsForUser(String userId) {
        return repository.findByUserId(userId);
    }
}

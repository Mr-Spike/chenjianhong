package com.example.selfstudyroom.repository;

import com.example.selfstudyroom.model.AccessPermission;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PermissionRepository {
    private final List<AccessPermission> permissions = new ArrayList<>();

    public void addPermission(AccessPermission permission) {
        permissions.add(permission);
    }

    public List<AccessPermission> findByUserId(String userId) {
        return permissions.stream()
                .filter(p -> p.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}

package com.project.autodealz.service;

import com.project.autodealz.service.models.RoleServiceModel;

import java.util.Set;

public interface RoleService {

    void seedRolesInDB();

    RoleServiceModel findByAuthority(String role);

    Set<RoleServiceModel> findAllRoles();
}

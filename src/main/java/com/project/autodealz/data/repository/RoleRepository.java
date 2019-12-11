package com.project.autodealz.data.repository;

import com.project.autodealz.data.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {

    Role findByAuthority(String authority);
}

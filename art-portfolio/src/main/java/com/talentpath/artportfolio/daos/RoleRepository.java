package com.talentpath.artportfolio.daos;

import com.talentpath.artportfolio.models.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName( Role.RoleName name );

}

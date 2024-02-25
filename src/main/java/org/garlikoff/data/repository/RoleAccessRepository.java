package org.garlikoff.data.repository;

import org.garlikoff.data.RoleAccess;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleAccessRepository extends CrudRepository<RoleAccess, String> {
    Optional<RoleAccess> findById(String id);
}

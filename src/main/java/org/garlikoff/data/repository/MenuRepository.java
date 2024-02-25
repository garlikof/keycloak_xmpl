package org.garlikoff.data.repository;

import org.garlikoff.data.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MenuRepository extends CrudRepository<Menu, String> {
    Optional<Menu> findById(String id);
}

package org.garlikoff.data.repository;

import com.sun.istack.NotNull;
import org.garlikoff.data.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MenuRepository extends CrudRepository<Menu, String> {
    Optional<Menu> findById(@NotNull String id);
}

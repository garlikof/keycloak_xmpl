package org.garlikoff.data;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "meta_role_menu_access")
public class RoleAccess {
    @Id
    @Column(name = "role")
    private String name;

    @OneToOne()
    @JoinColumn(name = "menu")
    private Menu menu;
}

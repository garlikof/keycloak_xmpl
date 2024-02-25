package org.garlikoff.data;

import lombok.Data;
import org.springframework.data.annotation.Reference;

import javax.persistence.*;

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

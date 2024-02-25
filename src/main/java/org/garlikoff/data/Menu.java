package org.garlikoff.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity(name="meta_menu")
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    @Id
    @Column(name = "menu_id")
    private String id;

    @Column(name = "menu_type")
    private String type;

    @Column(name = "menu_name")
    private String name;
}

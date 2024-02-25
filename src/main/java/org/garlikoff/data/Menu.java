package org.garlikoff.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

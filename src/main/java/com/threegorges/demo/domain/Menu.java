package com.threegorges.demo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "MENU")
public class Menu {

    @Id
    @GeneratedValue(generator = "uuid.hex")
    @GenericGenerator(name = "uuid.hex", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String menuId;

    private String url;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    public void setRole(Role role) {
        this.role = role;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Role getRole() {
        return role;
    }

    public String getMenuId() {
        return menuId;
    }

    public String getUrl() {
        return url;
    }
}

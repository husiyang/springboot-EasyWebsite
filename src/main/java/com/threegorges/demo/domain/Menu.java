package com.threegorges.demo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Menu {

    @Id
    @GeneratedValue(generator = "uuid.hex")
    @GenericGenerator(name = "uuid.hex", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String menuId;

    private String url;

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuId() {
        return menuId;
    }

    public String getUrl() {
        return url;
    }
}

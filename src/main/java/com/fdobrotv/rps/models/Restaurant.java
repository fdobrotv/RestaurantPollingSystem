package com.fdobrotv.rps.models;

import com.fdobrotv.rps.models.base.AbstractEntity;
import org.springframework.util.Assert;

import javax.persistence.Entity;

/**
 * Created by Fedor Dobrotvorsky on 03.11.2016.
 */
@Entity
public class Restaurant extends AbstractEntity {
    private String name;

    public Restaurant(String name) {
        Assert.hasText(name);
        this.name = name;
    }

    protected Restaurant() {}

    public String getName() {
        return name;
    }
}

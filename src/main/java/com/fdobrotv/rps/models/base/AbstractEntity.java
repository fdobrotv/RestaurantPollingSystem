package com.fdobrotv.rps.models.base;

/**
 * Created by Fedor Dobrotvorsky on 03.11.2016.
 */
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }
}


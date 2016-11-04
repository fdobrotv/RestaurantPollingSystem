package com.fdobrotv.rps.models.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity extends AbstractPersistable<Integer> {

    public BaseEntity() {
    }

    protected BaseEntity(Integer id) {
        setId(id);
    }

    @JsonIgnore
    public boolean isNew() {
        return super.isNew();
    }
}

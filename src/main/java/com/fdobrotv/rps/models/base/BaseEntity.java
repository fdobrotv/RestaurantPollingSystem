package com.fdobrotv.rps.models.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity extends AbstractPersistable<Long> {

    public BaseEntity() {
    }

    protected BaseEntity(Long id) {
        setId(id);
    }

    @JsonIgnore
    public boolean isNew() {
        return super.isNew();
    }
}

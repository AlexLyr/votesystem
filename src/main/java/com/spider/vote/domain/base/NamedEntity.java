package com.spider.vote.domain.base;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class NamedEntity extends BaseEntity {
    @Column(name = "name", nullable = false)
    @NotBlank
    protected String name;

    public NamedEntity() {
    }

    protected NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("Entity %s (%s, '%s')", getClass().getName(), super.getId(), name);
    }
}

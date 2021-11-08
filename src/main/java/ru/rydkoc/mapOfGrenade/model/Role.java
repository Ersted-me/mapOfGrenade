package ru.rydkoc.mapOfGrenade.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity {

    @Column(name = "role_name")
    private String name;

}

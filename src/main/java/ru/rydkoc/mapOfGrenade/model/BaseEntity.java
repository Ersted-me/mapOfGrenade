package ru.rydkoc.mapOfGrenade.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;


@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created")
    private LocalDate created;

    @Column(name = "updated")
    private LocalDate updated;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}

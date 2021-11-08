package ru.rydkoc.mapOfGrenade.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import sun.util.resources.LocaleData;

import javax.persistence.*;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created")
    private LocaleData created;

    @LastModifiedDate
    @Column(name = "updated")
    private LocaleData updated;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

}

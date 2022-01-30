package com.ambero.locationservice.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "geo_department")
public class Department {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "dpto_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "dpto_name", nullable = false, length = 100, unique = true)
    private String name;

    // TODO: Implementar esto
    //dpto_geom

    @Column(name = "dpto_created")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created;

    @Column(name = "dpto_updated")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date updated;
}

package com.ambero.sectorservice.entity;


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
@Table(name = "op_sector")
public class Sector {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "sector_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "sector_name", nullable = false, length = 100, unique = true)
    private String name;

    @Column(name = "sector_created")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created;

    @Column(name = "sector_updated")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date updated;
}

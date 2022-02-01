package com.ambero.authservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user_user")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "user_given_name", nullable = false, length = 255, unique = true)
    private String givenName;

    @Column(name = "user_family_name", nullable = false, length = 255)
    private String familyName;

    @Column(name = "user_nickname", length = 255)
    private String nickname;

    @Column(name = "user_email", nullable = false, length = 100, unique = true)
    private String email;

    @JsonIgnore
    @Column(name = "user_password", nullable = false, length = 255)
    private String password;

    @Column(name = "user_picture", length = 255)
    private String picture;

    @Column(name = "user_created")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created;

    @Column(name = "user_updated")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date updated;
}
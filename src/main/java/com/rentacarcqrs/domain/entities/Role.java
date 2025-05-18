package com.rentacarcqrs.domain.entities;

import io.github.mhmmedinan.core_persistence.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
@SQLRestriction(value = "deleted_date IS NULL")
public class Role extends BaseEntity implements GrantedAuthority {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private Set<UserRole> userRoles;

    @Override
    public String getAuthority() {
        return this.name.toLowerCase();
    }
}

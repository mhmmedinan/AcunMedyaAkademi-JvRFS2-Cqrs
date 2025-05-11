package com.rentacarcqrs.persistence.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rentacarcqrs.domain.entities.Brand;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID>{
    Brand getByNameIgnoreCase(String name);

}
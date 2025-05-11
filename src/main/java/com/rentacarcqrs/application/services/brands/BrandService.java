package com.rentacarcqrs.application.services.brands;

import com.rentacarcqrs.domain.entities.Brand;
import java.util.List;
import java.util.UUID;

public interface BrandService
{
     Brand add(Brand brand);
     Brand update(Brand brand);
     Brand delete(UUID id);
     List<Brand> getList();
     Brand getById(UUID id);

}
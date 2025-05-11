package com.rentacarcqrs.application.features.brands.mappers;

import com.rentacarcqrs.application.features.brands.commands.create.*;
import com.rentacarcqrs.application.features.brands.commands.delete.*;
import com.rentacarcqrs.application.features.brands.queries.getlist.*;
import com.rentacarcqrs.application.features.brands.commands.update.*;
import com.rentacarcqrs.domain.entities.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    Brand brandFromCreateBrandCommand(CreateBrandCommand createBrandCommand);
    CreatedBrandResponse createdBrandResponseFromBrand(Brand brand);
    DeletedBrandResponse deletedBrandResponseFromBrand(Brand brand);
    UpdatedBrandResponse updatedBrandResponseFromBrand(Brand brand);
    GetListBrandResponse brandToGetListBrandResponse(Brand brand);

    default List<GetListBrandResponse> getListBrandResponseFromBrands(List<Brand> brands) {
        return brands.stream()
                .map(this::brandToGetListBrandResponse)
                .collect(Collectors.toList());
    }
}

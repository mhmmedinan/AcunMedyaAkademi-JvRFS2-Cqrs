package com.rentacarcqrs.application.features.brands.mappers;

import com.rentacarcqrs.application.features.brands.commands.create.CreateBrandCommand;
import com.rentacarcqrs.application.features.brands.commands.create.CreatedBrandResponse;
import com.rentacarcqrs.application.features.brands.commands.delete.DeletedBrandResponse;
import com.rentacarcqrs.application.features.brands.commands.update.UpdatedBrandResponse;
import com.rentacarcqrs.application.features.brands.queries.getlist.GetListBrandResponse;
import com.rentacarcqrs.domain.entities.Brand;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-11T14:53:31+0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class BrandMapperImpl implements BrandMapper {

    @Override
    public Brand brandFromCreateBrandCommand(CreateBrandCommand createBrandCommand) {
        if ( createBrandCommand == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setName( createBrandCommand.getName() );

        return brand;
    }

    @Override
    public CreatedBrandResponse createdBrandResponseFromBrand(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        CreatedBrandResponse createdBrandResponse = new CreatedBrandResponse();

        createdBrandResponse.setId( brand.getId() );
        createdBrandResponse.setName( brand.getName() );

        return createdBrandResponse;
    }

    @Override
    public DeletedBrandResponse deletedBrandResponseFromBrand(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        DeletedBrandResponse deletedBrandResponse = new DeletedBrandResponse();

        deletedBrandResponse.setId( brand.getId() );

        return deletedBrandResponse;
    }

    @Override
    public UpdatedBrandResponse updatedBrandResponseFromBrand(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        UpdatedBrandResponse updatedBrandResponse = new UpdatedBrandResponse();

        updatedBrandResponse.setId( brand.getId() );
        updatedBrandResponse.setName( brand.getName() );

        return updatedBrandResponse;
    }

    @Override
    public GetListBrandResponse brandToGetListBrandResponse(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        GetListBrandResponse getListBrandResponse = new GetListBrandResponse();

        getListBrandResponse.setId( brand.getId() );
        getListBrandResponse.setName( brand.getName() );

        return getListBrandResponse;
    }
}

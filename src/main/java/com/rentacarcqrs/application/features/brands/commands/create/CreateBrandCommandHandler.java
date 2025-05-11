package com.rentacarcqrs.application.features.brands.commands.create;

import an.awesome.pipelinr.Command;
import com.rentacarcqrs.application.features.brands.mappers.BrandMapper;
import com.rentacarcqrs.application.features.brands.rules.BrandBusinessRules;
import com.rentacarcqrs.domain.entities.Brand;
import com.rentacarcqrs.persistence.repositories.BrandRepository;
import org.springframework.stereotype.Component;
import lombok.*;

@Component
@RequiredArgsConstructor
public class CreateBrandCommandHandler implements Command.Handler<CreateBrandCommand, CreatedBrandResponse> {
    private final BrandRepository brandRepository;
    private final BrandBusinessRules brandBusinessRules;



    @Override
    public CreatedBrandResponse handle(CreateBrandCommand createBrandCommand) {
        brandBusinessRules.checkIfBrandNameExists(createBrandCommand.getName());
        Brand brand = BrandMapper.INSTANCE
                .brandFromCreateBrandCommand(createBrandCommand);
        Brand createdBrand = brandRepository.save(brand);
        return BrandMapper.INSTANCE.createdBrandResponseFromBrand(createdBrand);
    }
}

package com.rentacarcqrs.application.features.brands.commands.update;

import an.awesome.pipelinr.Command;
import com.rentacarcqrs.application.features.brands.mappers.BrandMapper;
import com.rentacarcqrs.domain.entities.Brand;
import com.rentacarcqrs.persistence.repositories.BrandRepository;
import org.springframework.stereotype.Component;
import io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.types.BusinessException;
import lombok.*;

@Component
@RequiredArgsConstructor
public class UpdateBrandCommandHandler implements Command.Handler<UpdateBrandCommand, UpdatedBrandResponse> {
    private final BrandRepository brandRepository;

    @Override
    public UpdatedBrandResponse handle(UpdateBrandCommand updateBrandCommand) {
        Brand existingBrand = brandRepository.findById(updateBrandCommand.getId()).orElseThrow(() -> new BusinessException("Brand not found"));
        Brand updatedBrand = brandRepository.save(existingBrand);
        return BrandMapper.INSTANCE.updatedBrandResponseFromBrand(updatedBrand);
    }
}

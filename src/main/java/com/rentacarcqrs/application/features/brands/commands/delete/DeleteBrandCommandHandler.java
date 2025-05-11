package com.rentacarcqrs.application.features.brands.commands.delete;

import an.awesome.pipelinr.Command;
import com.rentacarcqrs.application.features.brands.mappers.BrandMapper;
import com.rentacarcqrs.domain.entities.Brand;
import com.rentacarcqrs.persistence.repositories.BrandRepository;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.types.BusinessException;
import lombok.*;

@Component
@RequiredArgsConstructor
public class DeleteBrandCommandHandler implements Command.Handler<DeleteBrandCommand, DeletedBrandResponse> {
    private final BrandRepository brandRepository;


    @Override
    public DeletedBrandResponse handle(DeleteBrandCommand deleteBrandCommand) {
        Brand existingBrand = brandRepository.findById(deleteBrandCommand.getId()).orElseThrow(() -> new BusinessException("Brand not found"));
        existingBrand.setDeletedDate(LocalDateTime.now());
        Brand deletedBrand = brandRepository.save(existingBrand);
        DeletedBrandResponse deletedBrandResponse =
                BrandMapper.INSTANCE.deletedBrandResponseFromBrand(deletedBrand);
        return deletedBrandResponse;
    }
}

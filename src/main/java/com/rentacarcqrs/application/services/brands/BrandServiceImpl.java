package com.rentacarcqrs.application.services.brands;

import com.rentacarcqrs.domain.entities.Brand;
import com.rentacarcqrs.persistence.repositories.BrandRepository;
import org.springframework.stereotype.Service;
import io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.types.BusinessException;
import java.util.List;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

private final BrandRepository brandRepository;


    @Override
    public Brand add(Brand brand) {
      return brandRepository.save(brand);
    }

    @Override
    public Brand update(Brand brand) {
        Brand existingBrand = brandRepository.findById(brand.getId()).orElseThrow(() -> new BusinessException("Brand not found"));
        Brand updatedBrand = brandRepository.save(existingBrand);
        return updatedBrand;
    }

    @Override
    public Brand delete(UUID id) {
        Brand existingBrand = brandRepository.findById(id).orElseThrow(() -> new BusinessException("Brand not found"));
        existingBrand.setDeletedDate(LocalDateTime.now());
        Brand deletedBrand = brandRepository.save(existingBrand);
        return deletedBrand;
    }

    @Override
    public List<Brand> getList() {
      return brandRepository.findAll();
    }

    @Override
    public Brand getById(UUID id) {
        return brandRepository.findById(id)
        .orElseThrow(() -> new BusinessException("Brand not found"));
    }
}

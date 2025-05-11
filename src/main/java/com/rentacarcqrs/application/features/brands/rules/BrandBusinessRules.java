package com.rentacarcqrs.application.features.brands.rules;

import com.rentacarcqrs.domain.entities.Brand;
import lombok.*;
import org.springframework.stereotype.Service;
import com.rentacarcqrs.application.features.brands.constants.Messages;
import com.rentacarcqrs.persistence.repositories.BrandRepository;
import io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.types.BusinessException;
import io.github.mhmmedinan.core_localization.abstraction.TranslationService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandBusinessRules {
    private final BrandRepository brandRepository;
    private final TranslationService translationService;

    public void brandIdShouldExistWhenSelected(UUID id) {
         brandRepository.findById(id).orElseThrow(() ->
            new BusinessException(translationService.getMessage(Messages.BusinessErrors.BrandNotExists)));
    }

    public void checkIfBrandNameExists(String name){
        Brand brand = brandRepository.getByNameIgnoreCase(name);
        if(brand!=null)
            throw new BusinessException(translationService.getMessage(Messages.BusinessErrors.BrandNameExists));
    }
}

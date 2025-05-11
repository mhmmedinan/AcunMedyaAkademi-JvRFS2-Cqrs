package com.rentacarcqrs.application.features.brands.queries.getlist;

import an.awesome.pipelinr.Command;
import com.rentacarcqrs.application.features.brands.mappers.BrandMapper;
import com.rentacarcqrs.domain.entities.Brand;
import com.rentacarcqrs.persistence.repositories.BrandRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import lombok.*;

@Component
@RequiredArgsConstructor
public class GetListBrandQueryHandler implements Command.Handler<GetListBrandQuery, List<GetListBrandResponse>> {
    private final BrandRepository brandRepository;

    @Override
    public List<GetListBrandResponse> handle(GetListBrandQuery getListBrandQuery) {
        List<Brand> brandList = brandRepository.findAll();
        List<GetListBrandResponse> responses = BrandMapper.INSTANCE.getListBrandResponseFromBrands(brandList);
        return responses;
    }
}

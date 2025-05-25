package com.rentacarcqrs.application.features.brands.queries.getlist;

import an.awesome.pipelinr.Command;
import com.rentacarcqrs.common.application.pipelines.auth.AuthorizedRequest;

import java.util.List;

public class GetListBrandQuery implements Command<List<GetListBrandResponse>>, AuthorizedRequest {
    @Override
    public List<String> getRoles() {
        return List.of("ADMIN");
    }
}

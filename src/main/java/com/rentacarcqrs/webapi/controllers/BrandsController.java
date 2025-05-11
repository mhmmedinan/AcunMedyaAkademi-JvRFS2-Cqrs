package com.rentacarcqrs.webapi.controllers;

import com.rentacarcqrs.application.features.brands.commands.create.*;
import com.rentacarcqrs.application.features.brands.commands.delete.*;
import com.rentacarcqrs.application.features.brands.commands.update.*;
import com.rentacarcqrs.application.features.brands.queries.getlist.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import an.awesome.pipelinr.Pipeline;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private final Pipeline pipeline;

    public BrandsController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping
    public ResponseEntity<CreatedBrandResponse> add(@RequestBody CreateBrandCommand command) {
        CreatedBrandResponse response = command.execute(pipeline);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<UpdatedBrandResponse> update(@RequestBody UpdateBrandCommand command) {
        UpdatedBrandResponse response = command.execute(pipeline);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletedBrandResponse> delete(@PathVariable UUID id) {
        DeleteBrandCommand command = new DeleteBrandCommand(id);
        DeletedBrandResponse response = command.execute(pipeline);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<GetListBrandResponse>> getAll() {
        GetListBrandQuery query = new GetListBrandQuery();
        List<GetListBrandResponse> responses = query.execute(pipeline);
        return ResponseEntity.ok(responses);
    }
}

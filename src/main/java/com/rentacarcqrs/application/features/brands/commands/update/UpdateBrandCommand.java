package com.rentacarcqrs.application.features.brands.commands.update;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandCommand implements Command<UpdatedBrandResponse> {

    private UUID id;
    private String name;
}

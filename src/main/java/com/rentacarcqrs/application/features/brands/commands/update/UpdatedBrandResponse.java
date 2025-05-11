package com.rentacarcqrs.application.features.brands.commands.update;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatedBrandResponse {

    private UUID id;
    private String name;
}

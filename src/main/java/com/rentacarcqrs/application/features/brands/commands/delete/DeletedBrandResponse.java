package com.rentacarcqrs.application.features.brands.commands.delete;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeletedBrandResponse {
    private UUID id;
}

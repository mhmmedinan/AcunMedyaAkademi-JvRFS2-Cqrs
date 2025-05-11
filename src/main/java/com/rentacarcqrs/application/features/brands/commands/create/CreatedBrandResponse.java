package com.rentacarcqrs.application.features.brands.commands.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedBrandResponse {
       private UUID id;
       private String name;
}

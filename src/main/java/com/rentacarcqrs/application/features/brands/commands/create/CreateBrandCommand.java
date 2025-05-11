package com.rentacarcqrs.application.features.brands.commands.create;

import an.awesome.pipelinr.Command;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateBrandCommand implements Command<CreatedBrandResponse> {
     private String name;
}

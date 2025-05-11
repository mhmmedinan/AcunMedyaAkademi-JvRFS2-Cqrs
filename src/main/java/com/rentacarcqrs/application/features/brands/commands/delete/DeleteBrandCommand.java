package com.rentacarcqrs.application.features.brands.commands.delete;

import an.awesome.pipelinr.Command;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DeleteBrandCommand implements Command<DeletedBrandResponse> {
    private UUID id;
}

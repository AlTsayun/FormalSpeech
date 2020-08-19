package com.tsayun.formalspeech.api.rest.component.model;

import com.tsayun.formalspeech.api.rest.component.controller.SectionsController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import com.tsayun.formalspeech.business.component.Section;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SectionModelAssemblerImpl implements SectionModelAssembler {

    @Override
    public EntityModel<Section> toModel(Section entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(SectionsController.class).getByIdentifier(entity.getIdentifier())).withSelfRel()
//                        .andAffordance(afford(methodOn(SectionsController.class).saveToId(null, entity.getIdentifier())))
                        .andAffordance(afford(methodOn(SectionsController.class).deleteByIdentifier(entity.getIdentifier()))),
                linkTo(methodOn(SectionsController.class).getAll()).withRel("Sections"));
    }

    @Override
    public CollectionModel<EntityModel<Section>> toCollectionModel(Iterable<? extends Section> entities) {
        return CollectionModel.of(StreamSupport.stream(entities.spliterator(), false)
                .map(this::toModel)
                .collect(Collectors.toList()), linkTo(methodOn(SectionsController.class).getAll()).withSelfRel());
    }
}

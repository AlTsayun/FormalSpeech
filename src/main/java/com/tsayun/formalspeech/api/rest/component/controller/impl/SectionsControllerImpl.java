package com.tsayun.formalspeech.api.rest.component.controller.impl;


import com.tsayun.formalspeech.api.rest.component.controller.SectionsController;
import com.tsayun.formalspeech.api.rest.component.model.SectionModelAssembler;
import com.tsayun.formalspeech.business.component.Section;
import com.tsayun.formalspeech.business.component.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SectionsControllerImpl implements SectionsController {

    private final SectionModelAssembler assembler;
    private final SectionRepository repository;

    @Override
    public ResponseEntity<CollectionModel<EntityModel<Section>>> getAll() {
        return ResponseEntity.ok(assembler.toCollectionModel(repository.findAll()));
    }

    @Override
    public ResponseEntity<?> create(Section newSection) {
        EntityModel<Section> entityModel = assembler.toModel(repository.save(newSection));
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @Override
    public ResponseEntity<EntityModel<Section>> getByIdentifier(String identifier) {
        return repository.findById(identifier)
                .map(assembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> deleteByIdentifier(String identifier) {
        repository.deleteById(identifier);
        return ResponseEntity.noContent().build();
    }
}

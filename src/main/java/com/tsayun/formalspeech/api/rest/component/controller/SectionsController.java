package com.tsayun.formalspeech.api.rest.component.controller;

import com.tsayun.formalspeech.business.component.Section;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/sections")
public interface SectionsController {

    @GetMapping
    ResponseEntity<CollectionModel<EntityModel<Section>>> getAll();

    @PostMapping
    ResponseEntity<?> create(@RequestBody Section newSection);

    @GetMapping("/{identifier}")
    ResponseEntity<EntityModel<Section>> getByIdentifier(@PathVariable String identifier);

    @DeleteMapping("/{identifier}")
    ResponseEntity<?> deleteByIdentifier(@PathVariable String identifier);
}

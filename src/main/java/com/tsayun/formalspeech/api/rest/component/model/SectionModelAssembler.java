package com.tsayun.formalspeech.api.rest.component.model;

import com.tsayun.formalspeech.business.component.Section;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

public interface SectionModelAssembler extends RepresentationModelAssembler<Section, EntityModel<Section>> {
}

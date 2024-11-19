package com.playground.backend.core.logic.model;

import com.playground.backend.core.model.CategoryEntity;
import com.playground.backend.core.model.OfferEntity;
import com.playground.backend.outbound.database.tag.TagEntity;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
  private Long id;

  private String title;
  private String description;
  private Double price;
  private String condition;
  private Instant dateAdded;

  private List<Tag> tags;
  //private Category categoryEntity;

  //private List<OfferEntity> offerEntities;

}

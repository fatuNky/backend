package com.playground.backend.core.model;

import java.time.Instant;
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
}

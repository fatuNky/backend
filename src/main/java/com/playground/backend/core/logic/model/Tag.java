package com.playground.backend.core.logic.model;


import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tag {

  private Long id;
  private String name;
}
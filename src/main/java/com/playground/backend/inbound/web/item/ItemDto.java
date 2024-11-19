package com.playground.backend.inbound.web.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.playground.backend.core.logic.model.Tag;
import com.playground.backend.core.model.CategoryEntity;
import com.playground.backend.core.model.OfferEntity;
import com.playground.backend.inbound.web.tag.TagDto;
import com.playground.backend.outbound.database.tag.TagEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonSerialize
public class ItemDto {

  @Schema(description = "ID of the item", example = "1", requiredMode = RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  private String id;

  @Schema(description = "Title of the item", example = "Vintage Chair", requiredMode = RequiredMode.REQUIRED)
  @JsonProperty("title")
  private String title;

  @Schema(description = "Description of the item", example = "A comfortable vintage chair", requiredMode = RequiredMode.REQUIRED)
  @JsonProperty("description")
  private String description;

  @Schema(description = "Price of the item", example = "199.99", requiredMode = RequiredMode.REQUIRED)
  @JsonProperty("price")
  private Double price;

  @Schema(description = "Condition of the item", example = "Good", requiredMode = RequiredMode.REQUIRED)
  @JsonProperty("condition")
  private String condition;

  @Schema(description = "The date when the item was added", example = "2024-11-17", requiredMode = RequiredMode.NOT_REQUIRED)
  @JsonProperty("date_added")
  private Instant dateAdded;

  //@Schema(description = "Category of the item", requiredMode = RequiredMode.NOT_REQUIRED)
  //@JsonProperty("category_entity")
  //private CategoryDto categoryEntity;

  @Schema(description = "List of tags associated with the item")
  @JsonProperty("tags")
  private List<TagDto> tags;

  //@Schema(description = "List of offers available for the item")
  //@JsonProperty("offer_entities")
  //private List<OfferDto> offerEntities;

}

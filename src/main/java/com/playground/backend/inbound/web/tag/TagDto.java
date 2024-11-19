package com.playground.backend.inbound.web.tag;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.playground.backend.core.logic.model.Item;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.Max;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TagDto {

  @Schema(description = "ID of the tag", example = "1", requiredMode = RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  private Long id;

  @Schema(description = "Name of the tag", example = "Electronics", requiredMode = RequiredMode.REQUIRED)
  @JsonProperty("name")
  @Max(value = 20, message = "Tag names are limited to 20 chars")  // Validation constraint
  private String name;

  @Schema(description = "List of items associated with this tag", requiredMode = RequiredMode.NOT_REQUIRED)
  @JsonProperty("items")
  private List<Item> items;  // Assuming Item is another DTO or entity related to this tag
}

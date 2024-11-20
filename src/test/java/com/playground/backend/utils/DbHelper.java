package com.playground.backend.utils;

import com.playground.backend.core.model.Item;
import com.playground.backend.core.model.Tag;
import com.playground.backend.inbound.web.item.ItemDto;
import com.playground.backend.inbound.web.tag.TagDto;
import com.playground.backend.outbound.database.item.ItemEntity;
import com.playground.backend.outbound.database.tag.TagEntity;
import java.time.Instant;

public class DbHelper {

  // Constants for default data
  public static final String DEFAULT_TAG_NAME = "Electronics";
  public static final String DEFAULT_ITEM_TITLE = "Smartphone";
  public static final String DEFAULT_ITEM_DESCRIPTION = "Latest model with high-end specs";
  public static final double DEFAULT_ITEM_PRICE = 799.99;
  public static final String DEFAULT_ITEM_CONDITION = "New";

  // Default Tag Entity
  public static TagEntity getDefaultTagEntity() {
    return TagEntity.builder()
        .name(DEFAULT_TAG_NAME)
        .build();
  }

  // Default Item Entity
  public static ItemEntity getDefaultItemEntity() {
    return ItemEntity.builder()
        .title(DEFAULT_ITEM_TITLE)
        .description(DEFAULT_ITEM_DESCRIPTION)
        .price(DEFAULT_ITEM_PRICE)
        .condition(DEFAULT_ITEM_CONDITION)
        .dateAdded(Instant.now())
        .build();
  }

  // Default Tag (Logic Model)
  public static Tag getDefaultTag() {
    return Tag.builder()
        .name(DEFAULT_TAG_NAME)
        .build();
  }

  // Default Item (Logic Model)
  public static Item getDefaultItem() {
    return Item.builder()
        .title(DEFAULT_ITEM_TITLE)
        .description(DEFAULT_ITEM_DESCRIPTION)
        .price(DEFAULT_ITEM_PRICE)
        .condition(DEFAULT_ITEM_CONDITION)
        .dateAdded(Instant.now())
        .build();
  }

  // Default ItemDto
  public static ItemDto getDefaultItemDto() {
    return ItemDto.builder()
        .title(DEFAULT_ITEM_TITLE)
        .description(DEFAULT_ITEM_DESCRIPTION)
        .price(DEFAULT_ITEM_PRICE)
        .condition(DEFAULT_ITEM_CONDITION)
        .dateAdded(Instant.now())
        .build();
  }

  // Default TagDto
  public static TagDto getDefaultTagDto() {
    return TagDto.builder()
        .name(DEFAULT_TAG_NAME)
        .build();
  }

}
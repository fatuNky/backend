package com.playground.backend.inbound.web.item;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playground.backend.core.logic.model.Item;
import com.playground.backend.core.logic.item.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@Tag(name = "Item Management", description = "Endpoints for managing items")
public class ItemController {

  private final ItemService itemService;
  private final ItemDtoMapper itemDtoMapper;
  private final ObjectMapper objectMapper;

  public ItemController(final ItemService itemService, final ItemDtoMapper itemDtoMapper, final ObjectMapper objectMapper) {
    this.itemService = itemService;
    this.itemDtoMapper = itemDtoMapper;
    this.objectMapper = objectMapper;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create a new item", description = "Create a new item with provided details")
  public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
    Item item = itemDtoMapper.fromDto(itemDto);
    Item createdItem = itemService.saveItem(item);
    return new ResponseEntity<>(itemDtoMapper.toDto(createdItem), HttpStatus.CREATED);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all items", description = "Retrieve a list of all items")
  public ResponseEntity<List<ItemDto>> getAllItems() {
    List<Item> items = itemService.getAllItems();
    List<ItemDto> itemDtos = itemDtoMapper.toDtoList(items);
    return new ResponseEntity<>(itemDtos, HttpStatus.OK);
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get item by ID", description = "Retrieve a single item by its ID")
  public ResponseEntity<ItemDto> getItemById(@PathVariable Long id) {
    Item item = itemService.getItemById(id);
    if (item != null) {
      return new ResponseEntity<>(itemDtoMapper.toDto(item), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update an item", description = "Update an existing item's details")
  public ResponseEntity<ItemDto> updateItem(@PathVariable Long id, @RequestBody ItemDto newItemDetails) {
    Item updatedItem = itemDtoMapper.fromDto(newItemDetails);
    Item item = itemService.updateItem(id, updatedItem);
    if (item != null) {
      return new ResponseEntity<>(itemDtoMapper.toDto(item), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete an item", description = "Remove an item by its ID")
  public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
    boolean isDeleted = itemService.deleteItem(id);
    if (isDeleted) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}

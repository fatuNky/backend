package com.playground.backend.inbound.web.tag;

import com.playground.backend.core.logic.model.Tag;
import com.playground.backend.core.logic.tag.TagService;
import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tags")
@io.swagger.v3.oas.annotations.tags.Tag(name = "Tag Management", description = "Endpoints for managing tags")
public class TagController {

  private final TagService tagService;
  private final TagDtoMapper tagDtoMapper = TagDtoMapper.INSTANCE;

  public TagController(final TagService tagService) {
    this.tagService = tagService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create a new tag", description = "Create a new tag with provided details")
  public ResponseEntity<TagDto> createTag(@RequestBody @Valid TagDto tagDto) {
    Tag tag = tagDtoMapper.fromDto(tagDto);
    Tag createdTag = tagService.saveTag(tag);
    return new ResponseEntity<>(tagDtoMapper.toDto(createdTag), HttpStatus.CREATED);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get all tags", description = "Retrieve a list of all tags")
  public ResponseEntity<List<TagDto>> getAllTags() {
    List<Tag> tags = tagService.getAllTags();
    List<TagDto> tagDtos = tagDtoMapper.toDtoList(tags);
    return new ResponseEntity<>(tagDtos, HttpStatus.OK);
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Get tag by ID", description = "Retrieve a single tag by its ID")
  public ResponseEntity<TagDto> getTagById(@PathVariable Long id) {
    Tag tag = tagService.getTagById(id);
    if (tag != null) {
      return new ResponseEntity<>(tagDtoMapper.toDto(tag), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update a tag", description = "Update an existing tag's details")
  public ResponseEntity<TagDto> updateTag(@PathVariable Long id, @RequestBody TagDto newTagDetails) {
    Tag updatedTag = tagDtoMapper.fromDto(newTagDetails);
    Tag tag = tagService.updateTag(id, updatedTag);
    if (tag != null) {
      return new ResponseEntity<>(tagDtoMapper.toDto(tag), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete a tag", description = "Remove a tag by its ID")
  public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
    boolean isDeleted = tagService.deleteTag(id);
    if (isDeleted) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}

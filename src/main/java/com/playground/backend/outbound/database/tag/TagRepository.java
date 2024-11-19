package com.playground.backend.outbound.database.tag;

import com.playground.backend.core.logic.model.Tag;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TagRepository {

  private final TagRepositoryJpa tagRepositoryJpa;
  private static final TagEntityMapper tagEntityMapper = TagEntityMapper.INSTANCE;

  public TagRepository(final TagRepositoryJpa tagRepositoryJpa) {
    this.tagRepositoryJpa = tagRepositoryJpa;
  }

  public Tag saveTag(Tag tag) {
    TagEntity tagEntity = tagEntityMapper.toEntity(tag);
    TagEntity savedEntity = tagRepositoryJpa.save(tagEntity);
    return tagEntityMapper.fromEntity(savedEntity);
  }

  public List<Tag> getAllTags() {
    List<TagEntity> tagEntities = tagRepositoryJpa.findAll();
    return tagEntityMapper.fromEntityList(tagEntities);
  }

  public Tag getTagById(Long id) {
    return tagRepositoryJpa.findById(id)
        .map(tagEntityMapper::fromEntity)
        .orElse(null);
  }

  public Tag updateTag(Long id, Tag newTagDetails) {
    return tagRepositoryJpa.findById(id)
        .map(existingTag -> {
          updateEntityWithNewDetails(existingTag, newTagDetails);
          return tagRepositoryJpa.save(existingTag);
        })
        .map(tagEntityMapper::fromEntity)
        .orElse(null);
  }

  public boolean deleteTag(Long id) {
    if (tagRepositoryJpa.existsById(id)) {
      tagRepositoryJpa.deleteById(id);
      return true;
    }
    return false;
  }

  private void updateEntityWithNewDetails(TagEntity existingTag, Tag newTagDetails) {
    existingTag.setName(newTagDetails.getName());
  }
}
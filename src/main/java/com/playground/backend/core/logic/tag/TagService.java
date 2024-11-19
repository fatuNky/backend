package com.playground.backend.core.logic.tag;

import com.playground.backend.core.logic.model.Tag;
import com.playground.backend.outbound.database.tag.TagRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TagService {

  private final TagRepository tagRepository;

  public TagService(final TagRepository tagRepository) {
    this.tagRepository = tagRepository;
  }

  public Tag saveTag(Tag tag) {
    return tagRepository.saveTag(tag);
  }

  public List<Tag> getAllTags() {
    return tagRepository.getAllTags();
  }

  public Tag getTagById(Long id) {
    return tagRepository.getTagById(id);
  }

  public Tag updateTag(Long id, Tag newTagDetails) {
    return tagRepository.updateTag(id, newTagDetails);
  }

  public boolean deleteTag(Long id) {
    return tagRepository.deleteTag(id);
  }
}

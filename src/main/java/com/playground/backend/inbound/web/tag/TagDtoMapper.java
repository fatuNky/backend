package com.playground.backend.inbound.web.tag;

import com.playground.backend.core.model.Tag;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagDtoMapper {

  TagDtoMapper INSTANCE = Mappers.getMapper(TagDtoMapper.class);

  TagDto toDto(Tag tag);

  Tag fromDto(TagDto tagDto);

  List<TagDto> toDtoList(List<Tag> tags);

  List<Tag> fromDtoList(List<TagDto> tagDtos);
}

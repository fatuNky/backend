package com.playground.backend.outbound.database.tag;

import com.playground.backend.core.model.Tag;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagEntityMapper {

  TagEntityMapper INSTANCE = Mappers.getMapper(TagEntityMapper.class);

  TagEntity toEntity(Tag tag);

  Tag fromEntity(TagEntity tagEntity);

  List<Tag> fromEntityList(List<TagEntity> tagEntities);
}

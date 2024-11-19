package com.playground.backend.outbound.database.item;

import com.playground.backend.core.logic.model.Item;
import com.playground.backend.core.logic.model.Tag;
import com.playground.backend.core.model.OfferEntity;
import com.playground.backend.outbound.database.tag.TagEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemDbMapper {

  ItemDbMapper INSTANCE = Mappers.getMapper(ItemDbMapper.class);

  List<Item> fromEntityList(List<ItemEntity> itemEntityList);

  ItemEntity toEntity(Item item);

  Item fromEntity(ItemEntity itemEntity);

  Tag fromEntity(TagEntity tagEntity);

  List<TagEntity> foo(List<Tag> tags);


}

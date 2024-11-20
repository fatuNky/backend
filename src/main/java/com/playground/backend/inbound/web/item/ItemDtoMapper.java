package com.playground.backend.inbound.web.item;

import com.playground.backend.core.model.Item;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemDtoMapper {

  ItemDto toDto(Item item);

  Item fromDto(ItemDto itemDTO);

  List<ItemDto> toDtoList(List<Item> item);

  List<Item> fromDtoList(List<ItemDto> itemDTO);

}
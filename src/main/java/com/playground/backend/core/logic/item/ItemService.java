package com.playground.backend.core.logic.item;

import com.playground.backend.core.logic.model.Item;
import com.playground.backend.outbound.database.item.ItemRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

  private final ItemRepository itemRepository;


  public ItemService(final ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public Item saveItem(Item item) {
    return itemRepository.saveItem(item);
  }

  public List<Item> getAllItems() {
    return itemRepository.getAllItems();
  }

  public Item getItemById(Long id) {
    return itemRepository.getItemById(id);
  }

  public Item updateItem(Long id, Item newItemDetails) {
    return itemRepository.updateItem(id, newItemDetails);
  }

  public boolean deleteItem(Long id) {
    return itemRepository.deleteItem(id);
  }
}

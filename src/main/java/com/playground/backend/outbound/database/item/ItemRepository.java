package com.playground.backend.outbound.database.item;

import com.playground.backend.core.model.Item;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {

  private final ItemRepositoryJpa itemRepositoryJpa;
  private final ItemDbMapper itemDbMapper = ItemDbMapper.INSTANCE;

  public ItemRepository(final ItemRepositoryJpa itemRepositoryJpa) {
    this.itemRepositoryJpa = itemRepositoryJpa;
  }

  public Item saveItem(Item item) {
    ItemEntity itemEntity = itemDbMapper.toEntity(item);
    ItemEntity savedEntity = itemRepositoryJpa.save(itemEntity);
    return itemDbMapper.fromEntity(savedEntity);
  }

  public List<Item> getAllItems() {
    List<ItemEntity> itemEntities = itemRepositoryJpa.findAll();
    return itemDbMapper.fromEntityList(itemEntities);
  }

  public Item getItemById(Long id) {
    final Optional<ItemEntity> itemEntityOptional = itemRepositoryJpa.findById(id);
    return itemEntityOptional.map(itemDbMapper::fromEntity).orElse(null);
  }

  public Item updateItem(Long id, Item newItemDetails) {
    return itemRepositoryJpa.findById(id)
        .map(existingItem -> {
          updateEntityWithNewDetails(existingItem, newItemDetails);
          return itemRepositoryJpa.save(existingItem);
        })
        .map(itemDbMapper::fromEntity)
        .orElse(null);
  }

  public boolean deleteItem(Long id) {
    if (itemRepositoryJpa.existsById(id)) {
      itemRepositoryJpa.deleteById(id);
      return true;
    }
    return false;
  }

  // Helper method to update the fields in the existing entity
  private void updateEntityWithNewDetails(ItemEntity existingItem, Item newItemDetails) {
    existingItem.setTitle(newItemDetails.getTitle());
    existingItem.setDescription(newItemDetails.getDescription());
    existingItem.setPrice(newItemDetails.getPrice());
    existingItem.setCondition(newItemDetails.getCondition());
    existingItem.setDateAdded(newItemDetails.getDateAdded());
    existingItem.setTags(itemDbMapper.toTagEntityList(newItemDetails.getTags()));
  }
}

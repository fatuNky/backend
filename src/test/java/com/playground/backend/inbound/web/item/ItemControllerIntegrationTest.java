package com.playground.backend.inbound.web.item;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playground.backend.core.logic.item.ItemService;
import com.playground.backend.core.model.Item;
import com.playground.backend.outbound.database.item.ItemRepositoryJpa;
import com.playground.backend.utils.DbHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ItemService itemService;

  @Autowired
  private ItemRepositoryJpa itemRepositoryJpa;

  @Autowired
  private ObjectMapper objectMapper;

  @AfterEach
  void setUp() {
    itemRepositoryJpa.deleteAll();
  }

  @Test
  public void testCreateItem() throws Exception {
    final ItemDto dto = DbHelper.getDefaultItemDto();

    mockMvc.perform(post("/api/items")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(dto)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.title").value(DbHelper.DEFAULT_ITEM_TITLE));
  }

  @Test
  public void testGetAllItems() throws Exception {
    final Item item = DbHelper.getDefaultItem();
    itemService.saveItem(item);

    mockMvc.perform(get("/api/items"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].title").value(DbHelper.DEFAULT_ITEM_TITLE));
  }

  @Test
  public void testGetItemById() throws Exception {
    final Item item = DbHelper.getDefaultItem();
    Item savedItem = itemService.saveItem(item);

    mockMvc.perform(get("/api/items/" + savedItem.getId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.title").value(DbHelper.DEFAULT_ITEM_TITLE));
  }

  @Test
  public void testUpdateItem() throws Exception {
    final Item item = DbHelper.getDefaultItem();
    Item savedItem = itemService.saveItem(item);

    savedItem.setTitle("Updated Item");

    mockMvc.perform(put("/api/items/" + savedItem.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(savedItem)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.title").value("Updated Item"));
  }

  @Test
  public void testDeleteItem() throws Exception {
    final Item item = DbHelper.getDefaultItem();
    Item savedItem = itemService.saveItem(item);

    mockMvc.perform(delete("/api/items/" + savedItem.getId()))
        .andExpect(status().isNoContent());
  }
}

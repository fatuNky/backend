package com.playground.backend.inbound.web.tag;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playground.backend.core.logic.model.Tag;
import com.playground.backend.core.logic.tag.TagService;
import com.playground.backend.inbound.web.item.ItemDto;
import com.playground.backend.outbound.database.tag.TagRepositoryJpa;
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
class TagControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private TagService tagService;

  @Autowired
  private TagRepositoryJpa tagRepositoryJpa;

  @Autowired
  private ObjectMapper objectMapper;

  @AfterEach
  void setUp() {
    tagRepositoryJpa.deleteAll();
  }

  @Test
  public void testCreateTag() throws Exception {
    final TagDto dto = DbHelper.getDefaultTagDto();

    mockMvc.perform(post("/api/tags")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(dto)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.name").value(DbHelper.DEFAULT_TAG_NAME));
  }

  @Test
  public void testGetAllTags() throws Exception {
    final Tag tag = DbHelper.getDefaultTag();
    tagService.saveTag(tag);

    // Perform the GET request and check the response
    mockMvc.perform(get("/api/tags"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name").value(DbHelper.DEFAULT_TAG_NAME));
  }

  @Test
  public void testGetTagById() throws Exception {
    final Tag tag = DbHelper.getDefaultTag();
    Tag savedTag = tagService.saveTag(tag);

    mockMvc.perform(get("/api/tags/" + savedTag.getId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value(DbHelper.DEFAULT_TAG_NAME));
  }

  @Test
  public void testUpdateTag() throws Exception {
    final Tag tag = DbHelper.getDefaultTag();
    Tag savedTag = tagService.saveTag(tag);

    savedTag.setName("foo");

    // Perform the PUT request and check the response
    mockMvc.perform(put("/api/tags/" + savedTag.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(savedTag)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("foo"));
  }

  @Test
  public void testDeleteTag() throws Exception {
    final Tag tag = DbHelper.getDefaultTag();
    Tag savedTag = tagService.saveTag(tag);

    mockMvc.perform(delete("/api/tags/" + savedTag.getId()))
        .andExpect(status().isNoContent());
  }
}
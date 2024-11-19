package com.playground.backend.outbound.database.item;

import com.playground.backend.core.model.CategoryEntity;
import com.playground.backend.core.model.OfferEntity;
import com.playground.backend.outbound.database.tag.TagEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ITEM")
public class ItemEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;
  private Double price;
  private String condition;
  private Instant dateAdded;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private CategoryEntity categoryEntity;

  @ManyToMany
  @JoinTable(
      name = "ITEM_TAG",
      joinColumns = @JoinColumn(name = "item_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id")
  )
  private List<TagEntity> tags;

  @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
  private List<OfferEntity> offerEntities;

}
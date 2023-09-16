package com.example.foodorderingsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "lunch")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lunch {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "name")
	String name;

	@OneToMany(mappedBy = "lunch")
	@ToString.Exclude
	List<Order> orders;

	@ManyToOne
	@JoinColumn(name = "cuisine_id", referencedColumnName = "id")
	Cuisine cuisine;

	@ManyToOne
	@JoinColumn(name = "meal_id", referencedColumnName = "id")
	Meal meal;

	@ManyToOne
	@JoinColumn(name = "dessert_id", referencedColumnName = "id")
	Dessert dessert;
}

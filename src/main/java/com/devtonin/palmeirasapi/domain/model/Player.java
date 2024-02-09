package com.devtonin.palmeirasapi.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PLAYERS")
public class Player {

	@Id
	@Column(name="PLAYER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long playerId;

	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="NAME")
	private String name;

	@NotNull
	@Column(name="SHIRTNUMBER")
	private Integer shirtNumber;

	@Column(name="AGE")
	private Integer age;

	@Column(name="HEIGHT")
	private String height;

	@Column(name="WEIGHT")
	private String weight;

	@NotNull
	@Column(name="POSITION")
	private PositionEnum position;

	@Column(name="IS_BAGRE")
	private Boolean isBagre;
}

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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PLAYERS")
@Builder
public class Player {

	@Id
	@Column(name="PLAYER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long playerId;

	@NotEmpty
	@NotBlank
	@Column(name="NAME", nullable = false)
	private String name;

	@Column(name="SHIRTNUMBER", nullable = false)
	private Integer shirtNumber;

	@Column(name="AGE", nullable = false)
	private Integer age;

	@NotEmpty
	@NotBlank
	@Column(name="HEIGHT")
	private String height;

	@NotEmpty
	@NotBlank
	@Column(name="WEIGHT")
	private String weight;

	@Column(name="POSITION", nullable = false)
	private PositionEnum position;

	@Column(name="IS_BAGRE")
	private Boolean isBagre;
}

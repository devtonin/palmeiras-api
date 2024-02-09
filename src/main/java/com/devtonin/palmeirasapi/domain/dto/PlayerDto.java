package com.devtonin.palmeirasapi.domain.dto;

import com.devtonin.palmeirasapi.domain.model.PositionEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class PlayerDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long playerId;

	@NotNull
	@NotEmpty
	@NotBlank
	private String name;

	@NotNull
	private Integer shirtNumber;

	private Integer age;

	private String height;

	private String weight;

	@NotNull
	private PositionEnum position;

	private Boolean isBagre;
}
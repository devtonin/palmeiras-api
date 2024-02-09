package com.devtonin.palmeirasapi.domain.exception.util;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatusCode;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class MessageException implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	protected String code;

	@NotNull
	protected String detail;

	@NotNull
	private ZonedDateTime requestDateTime;

	public MessageException(HttpStatusCode code, String detail, ZonedDateTime requestDateTime) {
		this.code = String.valueOf(code.value());
		this.detail = detail;
		this.requestDateTime = requestDateTime;
	}
}
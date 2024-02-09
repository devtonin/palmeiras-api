package com.devtonin.palmeirasapi.domain.exception;

import com.devtonin.palmeirasapi.domain.exception.util.MessageException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final HttpStatusCode httpStatusCode;

	private final List<MessageException> messages = new ArrayList<>();

	public BusinessException() {
		this.httpStatusCode = loadDefaultStatusCode();
	}

	public BusinessException(List<MessageException> messages) {
		super(CollectionUtils.isNotEmpty(messages) ? messages.stream().map(MessageException::toString).collect(Collectors.joining(";")) : null);
		this.httpStatusCode = loadDefaultStatusCode();
		this.messages.clear();
		this.messages.addAll(messages);
	}

	private HttpStatusCode loadDefaultStatusCode() {
		return HttpStatusCode.valueOf(422);
	}

	private HttpStatusCode loadDefaultStatusCode(HttpStatusCode statusCode) {
		return statusCode != null ? statusCode : HttpStatusCode.valueOf(422);
	}

	public BusinessException(List<MessageException> messages, HttpStatusCode statuscode) {
		super(CollectionUtils.isNotEmpty(messages) ? messages.stream().map(MessageException::toString).collect(Collectors.joining(";")) : null);
		this.httpStatusCode = loadDefaultStatusCode(statuscode);
		this.messages.clear();
		this.messages.addAll(messages);
	}

	public BusinessException(MessageException message) {
		super(message != null ? message.toString() : null);
		this.httpStatusCode = loadDefaultStatusCode();
		if (message != null) {
			this.messages.clear();
			this.messages.add(message);
		}
	}

	public BusinessException(MessageException message, HttpStatusCode statuscode) {
		super(message != null ? message.toString() : null);
		this.httpStatusCode = loadDefaultStatusCode(statuscode);
		if (message != null) {
			this.messages.clear();
			this.messages.add(message);
		}
	}

	public BusinessException(String message) {
		super(message);
		this.httpStatusCode = loadDefaultStatusCode();
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		this.httpStatusCode = loadDefaultStatusCode();
	}

	public BusinessException(Throwable cause) {
		super(cause);
		this.httpStatusCode = loadDefaultStatusCode();
	}

}
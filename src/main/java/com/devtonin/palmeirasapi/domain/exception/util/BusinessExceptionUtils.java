package com.devtonin.palmeirasapi.domain.exception.util;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import com.devtonin.palmeirasapi.domain.exception.BusinessException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BusinessExceptionUtils {

	public static void throwsIf(boolean condition, @NonNull MessageException... message) throws BusinessException {

		if (condition) {
			throwsException(message);
		}
	}

    public static void throwsIf(boolean condition, HttpStatus httpStatusCode, @NonNull MessageException... message) throws BusinessException {

		if (condition) {
			throwsException(httpStatusCode, message);
		}
	}

	public static void throwsException(@NonNull MessageException... message) throws BusinessException {

		throw new BusinessException(Arrays.asList(message));
	}

	public static void throwsException(@NonNull List<MessageException> messages) throws BusinessException {

		throw new BusinessException(messages);
	}
	
	public static void throwsException(HttpStatus httpStatusCode, @NonNull MessageException... message) throws BusinessException {

		throw new BusinessException(Arrays.asList(message), httpStatusCode);
	}

	public static void throwsException(HttpStatus httpStatusCode, @NonNull List<MessageException> messages) throws BusinessException {

		throw new BusinessException(messages, httpStatusCode);
	}

}

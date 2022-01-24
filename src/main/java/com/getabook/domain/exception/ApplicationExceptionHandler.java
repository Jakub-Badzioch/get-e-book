package com.getabook.domain.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handleException(HttpServletRequest request, IllegalArgumentException e) {
        final String exceptionMessage = e.getMessage();
        log.error(request.getMethod() + " " + request.getRequestURL() + " with error: " + exceptionMessage);
        log.error(ExceptionUtils.getStackTrace(e));

        return ErrorResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .message(exceptionMessage)
                .path(request.getRequestURI())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
    }
}

package com.getabook.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Builder
public class ErrorResponseDto {

    private LocalDateTime timestamp;
    private String message;
    private Integer status;
    private String path;

}

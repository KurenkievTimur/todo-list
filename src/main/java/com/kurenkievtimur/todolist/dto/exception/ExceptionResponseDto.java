package com.kurenkievtimur.todolist.dto.exception;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExceptionResponseDto {
    LocalDateTime timestamp;
    String message;
    Throwable throwable;
    HttpStatus httpStatus;
}

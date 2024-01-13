package com.kurenkievtimur.todolist.dto.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EditTaskDto {
    @NotBlank(message = "Title cannot be blank")
    String title;

    @NotBlank(message = "Description cannot be blank")
    String description;

    @NotNull(message = "Status cannot be null")
    @Pattern(regexp = "COMPLETED|NOT_COMPLETED", message = "Invalid status value")
    String status;
}

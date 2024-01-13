package com.kurenkievtimur.todolist.dto.task;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateTaskDto {
    @NotBlank(message = "Title cannot be blank")
    String title;

    @NotBlank(message = "Description cannot be blank")
    String description;
}

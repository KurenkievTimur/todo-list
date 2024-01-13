package com.kurenkievtimur.todolist.dto.task;

import com.kurenkievtimur.todolist.util.enums.TaskStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDto {
    Long id;
    String title;
    String description;
    TaskStatus status;
}

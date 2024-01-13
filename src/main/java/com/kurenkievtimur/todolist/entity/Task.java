package com.kurenkievtimur.todolist.entity;

import com.kurenkievtimur.todolist.util.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task extends BaseEntity {
    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    TaskStatus status;
}

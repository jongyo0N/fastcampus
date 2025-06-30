package com.example.exception.user.model;


import com.example.exception.entity.Entity;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends Entity {
    private String name;
    private Integer score;
}

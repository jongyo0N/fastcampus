package com.example.simpleboard.common;

public interface Converter<DTO,ENTITY> {
    DTO toDto(ENTITY entity);
    ENTITY toEntity(DTO dto);
}

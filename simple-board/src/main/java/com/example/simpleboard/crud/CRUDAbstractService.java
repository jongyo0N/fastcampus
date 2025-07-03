package com.example.simpleboard.crud;

import com.example.simpleboard.common.Api;
import com.example.simpleboard.common.Converter;
import com.example.simpleboard.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class CRUDAbstractService<DTO, ENTITY> implements CRUDInterface<DTO> {

    @Autowired
    private JpaRepository<ENTITY, Long> jpaRepository;

    @Autowired(required = false)
    private Converter<DTO,ENTITY> converter;

    @Override
    public DTO create(DTO dto) {
        // dto -> entity -> save -> dto
        var entity=converter.toEntity(dto);
        jpaRepository.save(entity);
        return converter.toDto(entity);
    }

    @Override
    public Optional<DTO> read(Long id) {

        var optionalEntity=jpaRepository.findById(id);

        var dto=optionalEntity.map(
                it ->{
                    return converter.toDto(it);
                }
        ).orElseGet(() -> null);

        return Optional.ofNullable(dto);
    }

    @Override
    public DTO update(DTO dto) {

        var entity=converter.toEntity(dto);
        jpaRepository.save(entity);
        return converter.toDto(entity);
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Api<List<DTO>> List(Pageable pageable) {
        var list = jpaRepository.findAll((org.springframework.data.domain.Pageable) pageable);

        var pagination = Pagination.builder()
                .page(list.getNumber())
                .size(list.getSize())
                .currentElements(list.getNumberOfElements())
                .totalElements(list.getTotalElements())
                .totalPage(list.getTotalPages())
                .build();

        var dtoList=list.stream()
                .map(it->{
                    return converter.toDto(it);
                })
                .collect(Collectors.toList());

        return Api.<List<DTO>>builder()
                .body(dtoList)
                .pagination(pagination)
                .build();
    }
}

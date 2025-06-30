package com.example.exception.db;

import com.example.exception.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T,ID> {
    private List<T> dataList = new ArrayList<T>();

    private static long index =0;

    @Override
    public T save(T data){

        if(Objects.isNull(data)){
            throw new RuntimeException("data is null");
        }

        var prevData = dataList.stream()
                        .filter(it ->{
                            return it.getId().equals(data.getId());
                        }).findFirst();

        if(prevData.isPresent()){
            dataList.remove(prevData.get());
            dataList.add(data);
        }else{
            index ++;
            data.setId(index);
            dataList.add(data);

            index ++;
        }

        return null;
    }

    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream()
                .filter(it ->{
                    return (it.getId().equals(id));
                }).findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList;
    }

    @Override
    public void delete(ID id) {
        var deleteEntity=dataList.stream()
                .filter(it ->{
                    return (it.getId().equals(id));
                }).findFirst();

        if (deleteEntity.isPresent()){
            dataList.remove(deleteEntity);
        }
    }
}

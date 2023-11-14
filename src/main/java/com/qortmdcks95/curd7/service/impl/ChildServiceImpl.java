package com.qortmdcks95.curd7.service.impl;

import com.qortmdcks95.curd7.entity.Child;
import com.qortmdcks95.curd7.payload.ChildDto;
import com.qortmdcks95.curd7.repository.ChildRepository;
import com.qortmdcks95.curd7.service.ChildService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ChildServiceImpl implements ChildService {
    private final ChildRepository childRepository;
    private final ModelMapper modelMapper;

    public ChildServiceImpl(ChildRepository childRepository, ModelMapper modelMapper){
        this.childRepository = childRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ChildDto createChild(ChildDto childDto){
        Child child = modelMapper.map(childDto, Child.class);
        Child saveChild = childRepository.save(child);

        return modelMapper.map(saveChild, ChildDto.class);
    }
}

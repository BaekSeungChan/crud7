package com.qortmdcks95.curd7.service.impl;

import com.qortmdcks95.curd7.entity.Child;
import com.qortmdcks95.curd7.payload.ChildDto;
import com.qortmdcks95.curd7.repository.ChildRepository;
import com.qortmdcks95.curd7.service.ChildService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<ChildDto> getAllChild(){
        List<Child> childs = childRepository.findAll();

        return childs.stream().map((child) -> modelMapper.map(child, ChildDto.class)).collect(Collectors.toList());
    }

    @Override
    public ChildDto getChildById(long id){
        Child child = childRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));
        return modelMapper.map(child, ChildDto.class);
    }
}

package com.qortmdcks95.curd7.service.impl;

import com.qortmdcks95.curd7.entity.Parent;
import com.qortmdcks95.curd7.payload.ParentDto;
import com.qortmdcks95.curd7.repository.ParentRepository;
import com.qortmdcks95.curd7.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;
    private final ModelMapper modelMapper;

    public ParentServiceImpl(ParentRepository parentRepository, ModelMapper modelMapper){
        this.parentRepository = parentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ParentDto createParent(ParentDto parentDto){
        Parent parent = modelMapper.map(parentDto, Parent.class);

        Parent saveParent = parentRepository.save(parent);

        return modelMapper.map(saveParent, ParentDto.class);
    }

    @Override
    public List<ParentDto> getAllParent(){
        List<Parent> parents = parentRepository.findAll();

        return parents.stream().map((parent) -> modelMapper.map(parent, ParentDto.class)).collect(Collectors.toList());
    }


    @Override
    public ParentDto getParentById(long id){
        Parent parent = parentRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        return modelMapper.map(parent, ParentDto.class);
    }

    @Override
    public void deleteParentById(long id){
        Parent parent = parentRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));
        parentRepository.delete(parent);
    }

}

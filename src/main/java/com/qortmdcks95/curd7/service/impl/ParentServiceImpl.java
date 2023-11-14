package com.qortmdcks95.curd7.service.impl;

import com.qortmdcks95.curd7.entity.Parent;
import com.qortmdcks95.curd7.payload.ParentDto;
import com.qortmdcks95.curd7.repository.ParentRepository;
import com.qortmdcks95.curd7.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

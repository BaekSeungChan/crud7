package com.qortmdcks95.curd7.service;

import com.qortmdcks95.curd7.payload.ParentDto;

import java.util.List;

public interface ParentService {

    ParentDto createParent(ParentDto parentDto);

    List<ParentDto> getAllParent();

    ParentDto getParentById(long id);
}

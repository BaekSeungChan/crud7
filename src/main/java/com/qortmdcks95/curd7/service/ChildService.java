package com.qortmdcks95.curd7.service;

import com.qortmdcks95.curd7.payload.ChildDto;

import java.util.List;

public interface ChildService {

    ChildDto createChild(ChildDto childDto);

    List<ChildDto> getAllChild();

    ChildDto getChildById(long id);

    void deleteChildById(long id);

    ChildDto updateChild(ChildDto childDto, long id);
}

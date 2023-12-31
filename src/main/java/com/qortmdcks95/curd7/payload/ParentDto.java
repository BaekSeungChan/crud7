package com.qortmdcks95.curd7.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ParentDto {
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "you have least 10 characters")
    private String name;

    private Integer age = 10;

    private Long childId;
}

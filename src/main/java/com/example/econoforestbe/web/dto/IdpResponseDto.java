package com.example.econoforestbe.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IdpResponseDto {
    private String year;
    private String name;
    private Long id;

    public void setIdpId(IdpResponseDto dto){
        id=dto.getId();
    }
}

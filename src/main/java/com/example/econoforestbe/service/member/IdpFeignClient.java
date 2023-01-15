package com.example.econoforestbe.service.member;

import com.example.econoforestbe.web.dto.IdpResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name="IdpConnect",url="${idp.api.uri}")
public interface IdpFeignClient {
    @GetMapping
    IdpResponseDto getIdp(@RequestHeader(value="Authorization") String accessToken);

}

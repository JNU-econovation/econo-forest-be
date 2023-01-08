package com.example.econoforestbe.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberApi {
    @Value("${idp.api.uri}")
    private final String IDP_URI;

    public Member getMember(String accesToken){
        /**
         * IDP 서버에 accessToken으로 요청해서 Member정보 얻기
         */
        return Member.builder()
                .id(1L)
                .ipdId(1L)
                .build();
    }
}

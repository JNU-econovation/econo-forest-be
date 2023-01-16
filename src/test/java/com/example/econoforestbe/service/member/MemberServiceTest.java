package com.example.econoforestbe.service.member;

import com.example.econoforestbe.web.dto.IdpResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    WebClientConfig webClientConfig;
    private static final String LOGIN_URL = "http://168.131.30.127:8080/api/accounts/login/process";
    private static final String BASE_URL = "http://168.131.30.127:8080/api/users/token";
    private static String ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5bWVjY2E3MzBAZ21haWwuY29tIiwicm9sZXMiOiJVU0VSIiwiaWF0IjoxNjczNzc0OTY5LCJleHAiOjE2NzM3NzUxNDl9.CbC7km9CVrU2bWUyawlF7-5IZrRzO9ZQ92wAc5JjR0E";
//    private static String ACCESS_TOKEN;

//    @Test
//    public void ACCESS_TOKEN_가져오기() {
//        WebClient webClient = webClientConfig.webClient()
//                .mutate()
//                .baseUrl(LOGIN_URL)
//                .build();
//
//        class LoginResponseDto {
//            public Strin g expiredTime;
//            public String accessToken;
//            public String refreshToken;
//
//            public String getAccessToken() {
//                return accessToken;
//            }
//        }
//
//
//        Mono<LoginResponseDto> loginResponseDtoMono = webClient.post()
//                .uri(uriBuilder -> uriBuilder.path("")
//                        .queryParam("userEmail", "ymecca730@gmail.com")
//                        .queryParam("password", "Qwer1234!@%23")
//                        .queryParam("redirectUrl", "https://www.naver.com")
//                        .build())
//                .retrieve()
//                .bodyToMono(LoginResponseDto.class);
//
//        loginResponseDtoMono.block().getAccessToken();
//    }


    @Test
    public void IDP_ID_가져오기() {
//        WebClient webClient = WebClient.builder()
//                .baseUrl(BASE_URL)
//                .build();

        WebClient webClient = webClientConfig.webClient();
        IdpResponseDto id = webClient.get()
                .headers(h -> h.setBearerAuth(ACCESS_TOKEN))
                .retrieve()
                .bodyToMono(IdpResponseDto.class)
                .flux()
                .toStream()
                .findAny()
                .get();


        System.out.println(id.getId());

        Assertions.assertEquals(1, id.getId());
    }

}
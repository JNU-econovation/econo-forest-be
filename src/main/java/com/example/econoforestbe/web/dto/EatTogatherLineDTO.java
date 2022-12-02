package com.example.econoforestbe.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EatTogatherLineDTO {

    private Long memberId;
    private Long eatTogatherId;

    private EatTogatherLineDTOInfo eatTogatherLineDTOInfo;


    public EatTogatherLineDTO(Long memberId, Long eatTogatherId, EatTogatherLineDTOInfo eatTogatherLineDTOInfo) {
        this.memberId = memberId;
        this.eatTogatherId = eatTogatherId;
        this.eatTogatherLineDTOInfo = eatTogatherLineDTOInfo;
    }

    @Data
    public static class EatTogatherLineDTOInfo {
        private LocalDateTime localDateTime;
        private String location;

        public EatTogatherLineDTOInfo(LocalDateTime localDateTime, String location) {
            this.localDateTime = localDateTime;
            this.location = location;
        }
    }

}

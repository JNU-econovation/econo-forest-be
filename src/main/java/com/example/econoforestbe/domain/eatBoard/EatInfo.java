package com.example.econoforestbe.domain.eatBoard;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Builder
@Getter
@Slf4j
public class EatInfo {
    private static final String ONLY_SUBSEQUENT_TIME_CREATED = "현재 시간보다 이후 시간으로만 정보 생성가능합니다";
    private static final String NOT_MATCH_EAT_BOARD_STATUS ="해당 밥 먹어요 글이 수정되었습니다.";
    private LocalDateTime eatDateTime;


    public EatInfo(LocalDateTime localDateTime) {
        this.eatDateTime = localDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EatInfo)) return false;
        EatInfo compareEatInfo = (EatInfo) o;
        return Objects.equals(eatDateTime, compareEatInfo.eatDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eatDateTime);
    }

    private Info convertToInfo() {
        return Info.builder()
                .localDateTime(eatDateTime)
                .build();
    }

    public void validateStatus(Info info) {
        if (!this.convertToInfo().equals(info)) {
            throw new IllegalArgumentException(NOT_MATCH_EAT_BOARD_STATUS);
        }
    }

}


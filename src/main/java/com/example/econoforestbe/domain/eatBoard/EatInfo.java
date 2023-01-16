package com.example.econoforestbe.domain.eatBoard;

import com.example.econoforestbe.domain.Timestamped;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.transaction.Transactional;
import javax.validation.constraints.Future;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Builder
@Getter
@Slf4j
@Access(AccessType.FIELD)
public class EatInfo {
    private static final String ONLY_SUBSEQUENT_TIME_CREATED = "현재 시간보다 이후 시간으로만 정보 생성가능합니다";
    private static final String NOT_MATCH_EAT_BOARD_STATUS = "해당 밥 먹어요 글이 수정되었습니다.";
    @Future
    private LocalDateTime eatDateTime;


    public EatInfo(LocalDateTime localDateTime) {
        this.eatDateTime = localDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Info)) return false;
        Info compareEatInfo = (Info) o;
        return Objects.equals(eatDateTime, compareEatInfo.getLocalDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(eatDateTime);
    }

    private Info convertToInfo() {
        return Info.builder().localDateTime(eatDateTime).build();
    }

    public void validateStatus(Info info) {
        log.info(info.getLocalDateTime().toString());
        log.info(String.valueOf(!(this.equals(info))));
        if (!(this.equals(info))) {
            throw new IllegalArgumentException(NOT_MATCH_EAT_BOARD_STATUS);
        }
    }

    public boolean isBefore() {
        LocalDate localDate = eatDateTime.atZone(ZoneId.systemDefault()).toLocalDate();
        log.info("드러오기는 했다.");
        return localDate.isBefore(LocalDate.now());
    }

}


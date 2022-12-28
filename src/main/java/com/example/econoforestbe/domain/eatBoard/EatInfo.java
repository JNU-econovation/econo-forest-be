package com.example.econoforestbe.domain.eatBoard;

import lombok.Builder;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Builder
public class EatInfo {
    private static final String ONLY_SUBSEQUENT_TIME_CREATED = "현재 시간보다 이후 시간으로만 정보 생성가능합니다";
    private LocalDate eatDate;
    private LocalTime eatTime;


    public EatInfo(LocalDate eatDate, LocalTime eatTime) {
        validateSubsequentTime(eatDate, eatTime);
        this.eatDate = eatDate;
        this.eatTime = eatTime;
    }

    private void validateSubsequentTime(LocalDate eatDate, LocalTime eatTime) {
        if (eatDate.isBefore(LocalDate.now()) || eatTime.isBefore(LocalTime.now())) {
            throw new IllegalArgumentException(ONLY_SUBSEQUENT_TIME_CREATED);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EatInfo)) return false;
        EatInfo compareEatInfo = (EatInfo) o;
        return Objects.equals(eatDate, compareEatInfo.eatDate) && Objects.equals(eatTime, compareEatInfo.eatTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eatDate, eatTime);
    }

    public boolean isEqualInfo(Info info) {
        return this.equals(info);
    }

    /**
     * @return boolean 밥 먹는 날짜/시간 지남 -> 더 이상 참여버튼 누르지 못함
     */
    public boolean overTime() {
        return eatTime.isAfter(LocalTime.now());
    }

    /**
     * @return boolean 밥 먹는 날짜가 당일 지났는지 확인
     */
    public boolean overDate() {
        return eatDate.isAfter(LocalDate.now()) && eatTime.isAfter(LocalTime.now());
    }

    public Info convertToInfo(){
        return Info.builder()
                .eatDate(eatDate)
                .eatTime(eatTime)
                .build();
    }

}


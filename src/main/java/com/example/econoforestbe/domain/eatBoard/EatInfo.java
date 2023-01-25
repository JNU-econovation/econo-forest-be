package com.example.econoforestbe.domain.eatBoard;

import com.example.econoforestbe.domain.Timestamped;
import com.example.econoforestbe.global.config.response.error.exception.eatBoard.ChangedInfoException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
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
@Getter
@Slf4j
@Access(AccessType.FIELD)
public class EatInfo {
    @Future
    private LocalDateTime eatDateTime;
    @Column(name = "LOCATION_CATEGORY_EAT_BOARD")
    @Enumerated(EnumType.STRING)
    private LocationCategory locationCategory;

    @Builder
    public EatInfo(LocalDateTime localDateTime, LocationCategory locationCategory) {
        this.eatDateTime = localDateTime;
        this.locationCategory = locationCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Info)) return false;
        Info info = (Info) o;
        return Objects.equals(eatDateTime, info.getLocalDateTime()) && Objects.equals(locationCategory.getLocation(), info.getLocationCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(eatDateTime);
    }

    public void validateStatus(Info info) {
        if (!(this.equals(info))) {
            throw new ChangedInfoException();
        }
    }

    public boolean isBefore() {
        LocalDate localDate = eatDateTime.atZone(ZoneId.systemDefault()).toLocalDate();
        log.info("드러오기는 했다.");
        return localDate.isBefore(LocalDate.now());
    }

}


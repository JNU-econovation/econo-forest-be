package com.example.econoforestbe.domain.join;

import com.example.econoforestbe.domain.eatBoard.Info;
import com.example.econoforestbe.domain.eatBoard.LocationCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Slf4j
public class JoinInfo {
    private LocalDateTime eatInfoWhenJoin;
    private LocationCategory locationCategory;

    public Info convertToInfo() {
        log.info(eatInfoWhenJoin.toString());
        return Info.builder()
                .localDateTime(eatInfoWhenJoin)
                .build();
    }
}

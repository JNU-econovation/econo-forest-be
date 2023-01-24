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
@NoArgsConstructor
@Getter
@Slf4j
public class JoinInfo {
    private LocalDateTime localDateTime;
    private LocationCategory locationCategory;

    @Builder
    public JoinInfo(LocalDateTime localDateTime, LocationCategory locationCategory){
        this.localDateTime=localDateTime;
        this.locationCategory=locationCategory;
    }

    public Info convertToInfo() {
        return Info.builder()
                .localDateTime(localDateTime)
                .locationCategory(locationCategory)
                .build();
    }
}

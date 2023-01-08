package com.example.econoforestbe.domain.join;

import com.example.econoforestbe.domain.eatBoard.Info;
import com.example.econoforestbe.domain.eatBoard.LocationCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class JoinInfo {
    private LocalDateTime eatInfoWhenJoin;
    private LocationCategory locationCategory;

    public Info convertToInfo() {
        return Info.builder()
                .localDateTime(eatInfoWhenJoin)
                .locationCategory(locationCategory)
                .build();
    }
}

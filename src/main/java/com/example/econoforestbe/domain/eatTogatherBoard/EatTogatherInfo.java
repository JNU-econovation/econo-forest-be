package com.example.econoforestbe.domain.eatTogatherBoard;

import com.example.econoforestbe.domain.withEatTogather.WithEatTogatherInfo;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class EatTogatherInfo {

    private LocalDateTime dateTime;

    private String location;

    public EatTogatherInfo(LocalDateTime dateTime, String location) {
        this.dateTime = dateTime;
        this.location = location;
    }

    public void validateWith(WithEatTogatherInfo withEatTogatherInfo) {
        if (!this.equals(withEatTogatherInfo)) {
            throw new IllegalStateException("there are change in eatTogather meeting");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if(!(o instanceof WithEatTogatherInfo)) return false;
        WithEatTogatherInfo other = (WithEatTogatherInfo) o;
        return Objects.equals(dateTime, other.getDateTime()) && Objects.equals(location, other.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, location);
    }
}

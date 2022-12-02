package com.example.econoforestbe.domain.eatTogatherBoard;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class EatTogatherInfo {

    @Column(name = "eat_togather_dateTime")
    private LocalDateTime dateTime;

    @Column(name = "eat_togather_location")
    private String location;

    public EatTogatherInfo(LocalDateTime dateTime, String location) {
        this.dateTime = dateTime;
        this.location = location;
    }

    public void validateWith(Info info) {
        if (!this.equals(info)) {
            throw new IllegalStateException("there are change in eatTogather meeting");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if(!(o instanceof Info)) return false;
        Info other = (Info) o;
        return Objects.equals(dateTime, other.getDateTime()) && Objects.equals(location, other.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, location);
    }
}

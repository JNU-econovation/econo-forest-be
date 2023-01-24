package com.example.econoforestbe.domain.eatBoard;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Builder
@Getter
public class Title {
    private static final String NOT_EMPTY_TITLE = "제목은 비어있으면 안됩니다.";
    @Column(name = "EAT_BOARD_TITLE")
    private String title;

    public Title(String title) {
        validationSize(title);
        this.title = title;
    }

    private void validationSize(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException(NOT_EMPTY_TITLE);
        }
    }
}

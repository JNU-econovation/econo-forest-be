package com.example.econoforestbe.domain;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class SQLDate {

    @Column(name = "created_at")
    private final LocalDateTime createdAt;

    @Column(name = "deleted_at")
    private final LocalDateTime deletedAt;

    @Column(name = "modified_at")
    private final LocalDateTime modifiedAt;

    public SQLDate() {
        this.createdAt = LocalDateTime.now();
        this.deletedAt = LocalDateTime.MAX;
        this.modifiedAt = LocalDateTime.now();
    }

}

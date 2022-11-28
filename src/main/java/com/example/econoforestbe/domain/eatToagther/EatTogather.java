package com.example.econoforestbe.domain.eatToagther;

import com.example.econoforestbe.domain.Member.Member;
import com.example.econoforestbe.domain.SQLDate;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class EatTogather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eat_togather_id")
    private Long id;
    private String title;
    @Embedded
    private EatTogatherInfo eatTogatherInfo;
    @ElementCollection
    @CollectionTable(name = "eat_togatehr_members",
            joinColumns = @JoinColumn(name = "eat_togatehr_id"))
    @OrderColumn(name = "eat_togatehr_member_idx")
    private final List<EatTogatherMember> eatTogatherMembers = new ArrayList<>();
    @Embedded
    private SQLDate sqlDate;

    public EatTogather(String title, EatTogatherInfo eatTogatherInfo, Member member) {
        this.title = title;
        this.eatTogatherInfo = eatTogatherInfo;
        this.eatTogatherMembers.add(new EatTogatherMember(member));
        this.sqlDate = new SQLDate();
    }

    public Long getId() {
        return id;
    }
}

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

    @Transient
    private final String WARM = "[ERROR]";

    @Transient
    private final String WARM_DUPLICATE_MEMBER = WARM + " exist duplicate member";

    @Transient
    private final String WARM_NO_SUCH_MEMBER = WARM + " there are no such member";

    @Transient
    private final String WARM_REMOVE = WARM + " there are something wrong during remove";

    @Transient
    private final String WARM_WRITER_CANT_CANCEL = WARM + " writer can't cancel eatTogather";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eat_togather_id")
    private Long id;
    private String title;
    @Embedded
    private EatTogatherInfo eatTogatherInfo;
    @Embedded
    private EatTogatherMembers eatTogatherMembers;
    @Embedded
    private SQLDate sqlDate;


    public EatTogather(String title, EatTogatherInfo eatTogatherInfo, Member member) {
        this.title = title;
        this.eatTogatherInfo = eatTogatherInfo;
        this.eatTogatherMembers = new EatTogatherMembers(converMemberToEatTogatherMemberLists(member));
        this.sqlDate = new SQLDate();
    }

    private static List<EatTogatherMember> converMemberToEatTogatherMemberLists(Member member) {
        EatTogatherMember eatTogatherMember = new EatTogatherMember(member);
        List<EatTogatherMember> eatTogatherMemberLists = new ArrayList<>();
        eatTogatherMemberLists.add(eatTogatherMember);
        return eatTogatherMemberLists;
    }

    public Long getId() {
        return id;
    }

    public EatTogatherMembers getEatTogatherMembers() {
        return eatTogatherMembers;
    }
}

package com.example.econoforestbe.domain.eatToagther;

import com.example.econoforestbe.domain.Member.Member;
import com.example.econoforestbe.domain.SQLDate;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public boolean isWriter(Member member) {
        if (this.eatTogatherMembers.get(0)
                .isEqualMember(member)) {
            return true;
        }
        return false;
    }
}

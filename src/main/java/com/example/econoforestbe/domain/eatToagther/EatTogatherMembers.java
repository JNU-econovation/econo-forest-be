package com.example.econoforestbe.domain.eatToagther;

import com.example.econoforestbe.domain.Member.Member;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Embeddable
@NoArgsConstructor
public class EatTogatherMembers {

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

    @Transient
    private final int WRITER_INDEX = 0;

    @ElementCollection
    @CollectionTable(name = "eat_togatehr_members",
            joinColumns = @JoinColumn(name = "eat_togatehr_id"))
    @OrderColumn(name = "eat_togatehr_member_idx")
    private List<EatTogatherMember> eatTogatherMembers;

    public EatTogatherMembers(List<EatTogatherMember> eatTogatherMembers) {
        this.eatTogatherMembers = eatTogatherMembers;
    }

    public boolean isWriter(Member member) {
        if (this.eatTogatherMembers.get(WRITER_INDEX)
                .isEqualMember(member)) {
            return true;
        }
        return false;
    }

    public void addEatTogatherMember(Member member) {
        validateDuplicate(member);
        this.eatTogatherMembers.add(new EatTogatherMember(member));

    }

    private void validateDuplicate(Member member) {
        Optional<EatTogatherMember> findDuplicate = findEatTogatherMember(member);
        if (findDuplicate.isPresent()) {
            throw new IllegalArgumentException(WARM_DUPLICATE_MEMBER);
        }
    }

    public void cancleEatTogather(Member member) {
        if (isWriter(member)) {
            throw new IllegalArgumentException(WARM_WRITER_CANT_CANCEL);
        }

        Optional<EatTogatherMember> findEatTogatherMember = findEatTogatherMember(member);

        if (!findEatTogatherMember.isPresent()) {
            throw new IllegalArgumentException(WARM_NO_SUCH_MEMBER);
        }

        if (!this.eatTogatherMembers.remove(findEatTogatherMember.get())) {
            throw new IllegalStateException(WARM_REMOVE);
        }
    }

    private Optional<EatTogatherMember> findEatTogatherMember(Member member) {
        return this.eatTogatherMembers.stream()
                .filter(eatTogatherMember -> eatTogatherMember.isEqualMember(member))
                .findFirst();
    }

    public int memberCount() {
        return this.eatTogatherMembers.size();
    }
}

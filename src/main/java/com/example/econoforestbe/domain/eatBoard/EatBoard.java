package com.example.econoforestbe.domain.eatBoard;

import com.example.econoforestbe.domain.Timestamped;
import com.example.econoforestbe.util.EpochTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import static com.example.econoforestbe.util.EpochTime.toLocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Where(clause = "deleted_at IS NULL")
@SQLDelete(sql="UPDATE eat_board SET deleted_at=CURRENT_DATE where eat_board_id=?")
public class EatBoard extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EAT_BOARD_ID")
    private Long id;
    @Embedded
    @Column(name = "EAT_BOARD_NAME")
    private Title title;
    @Enumerated(EnumType.STRING)
    @Column(name = "EAT_BOARD_LOCATION_CATEGORY")
    private LocationCategory locationCategory;
    @Embedded
    private EatMembers eatMembers;
    @Embedded
    private EatInfo eatInfo;
}

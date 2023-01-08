package com.example.econoforestbe.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
/**
 * 일반회원은 idp server에서 accessToken으로 정보를 가져오지만, 관리자의 경우에는 우리 서버에서 따로 관리해야 한다.
 * 따라서 이 클래스는 관리자를 관리하기 위한 용도
 */
public class Member {
    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    private Long ipdId;
}

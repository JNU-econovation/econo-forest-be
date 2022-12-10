package com.example.econoforestbe.domain.eatBoard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EatBoardRepository extends JpaRepository<EatBoard,Long> {
}

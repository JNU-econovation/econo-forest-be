package com.example.econoforestbe.domain.eatBoard;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EatBoardRepository extends JpaRepository<EatBoard,Long> {
    Page<EatBoard> findByLocationCategory(LocationCategory locationCategory, Pageable pageable);
}

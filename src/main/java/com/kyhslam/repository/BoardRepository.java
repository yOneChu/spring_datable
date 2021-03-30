package com.kyhslam.repository;

import com.kyhslam.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public Long regist(Board board) {
        em.persist(board);
        return board.getId();
    }

    public List<Board> findAll() {
        return em.createQuery("select b from Board b", Board.class)
                .getResultList();
    }

    public List<Board> findPage(int start, int total) {
        return em.createQuery("select b from Board b", Board.class)
                .setFirstResult(start)
                .setMaxResults(total)
                .getResultList();
    }

}

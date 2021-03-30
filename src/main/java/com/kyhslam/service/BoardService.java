package com.kyhslam.service;

import com.kyhslam.domain.Board;
import com.kyhslam.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long regist(Board board) {
        return boardRepository.regist(board);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public List<Board> findPage(int start, int total) {
        return boardRepository.findPage(start, total);
    }

}

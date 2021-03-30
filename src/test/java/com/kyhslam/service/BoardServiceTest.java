package com.kyhslam.service;

import com.kyhslam.domain.Board;
import com.kyhslam.repository.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class BoardServiceTest {

    @Autowired BoardService boardService;
    @Autowired BoardRepository boardRepository;

    @Test
    @Rollback(value = false)
    public void registTest() {
        //given
        for(int i=0; i < 200; i++) {
            Board board = new Board();
            board.setContent("오류가 발생했음_" + i  );
            board.setWriter("김영환");
            boardService.regist(board);
        }

    }

    @Test
    public void search() {
        List<Board> all = boardService.findPage(20, 10);

        for(int i=0;i<all.size();i++) {
            Board b = all.get(i);
            System.out.println((i+1) + " == " + b.getContent() + " :: " + b.getWriter());
        }
    }

    @Test
    public void pageSearch() {

    }


}
package com.kyhslam.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter @Getter
@Table(name = "a_board")
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;
    private String content;
    private String writer;


}

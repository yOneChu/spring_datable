package com.kyhslam.controller;

import com.kyhslam.domain.Board;
import com.kyhslam.service.BoardService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/index")
    public String main(Model model) {
        return "index";
    }

    @PostMapping("/search")
    @ResponseBody
    public DataTableDto search(DataTableDto dto, @RequestBody MultiValueMap<String,String> formData){
        log.info("search =============== ");
        int draw = Integer.parseInt(formData.get("draw").get(0));
        int start = Integer.parseInt(formData.get("start").get(0));
        int length = Integer.parseInt(formData.get("length").get(0));

        List<Board> all = boardService.findAll();
        log.info("draw :: " + draw);
        log.info("start :: " + start);
        log.info("length :: " + length);

        int total = all.size();
        List data = boardService.findPage(start, length);
        log.info(" -- " + data.size());
        dto.setDraw(draw);
        dto.setRecordsFiltered(total);
        dto.setRecordsTotal(total);
        dto.setData(data);

        log.info(" -- " + dto);

        return dto;
    }



    @Data
    static class DataTableDto {
        private int draw;
        private int recordsTotal;
        private int recordsFiltered;
        private List data;
    }
}

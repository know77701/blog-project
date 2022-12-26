package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.Board;
import com.cos.blog.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping({"","/"})
	public String index(Model model, @PageableDefault(size = 3,sort="id",direction = Sort.Direction.DESC) Pageable pageablel) {
		model.addAttribute("boards", boardService.boardList(pageablel));
		return "index";
	}
	
	@GetMapping("/board/saveForm")
	public String boardWrite() {
		return "board/saveForm";
	}
	
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board",boardService.boardDetail(id));
		return "board/detail";
	}

	@GetMapping("/board/{id}/updateForm")
	public String updateBoard(@PathVariable int id, Model model) {
		model.addAttribute("board",boardService.boardDetail(id));
		return "board/updateForm";
	}
	
}

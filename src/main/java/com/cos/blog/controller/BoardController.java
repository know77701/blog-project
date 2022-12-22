package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}

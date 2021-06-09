package xyz.kraken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import xyz.kraken.domain.BoardVO;
import xyz.kraken.domain.Criteria;
import xyz.kraken.domain.PageDTO;
import xyz.kraken.service.BoardService;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("list")
	public void list(Criteria cri ,Model model){
		log.info("list.....");
		model.addAttribute("list",service.getList(cri));
		model.addAttribute("pageMaker",new PageDTO(cri, service.getTotal(cri)));
	}
	@GetMapping({"get","modify"})
	public void get(@RequestParam Long bno,@ModelAttribute("cri") Criteria cri, Model model){
		log.info("get or modify.....");
		model.addAttribute("board",service.get(bno));
		model.addAttribute("cri",cri);
	}
	@GetMapping("register")
	public void register(){
		
	}
	
	@PostMapping("register")
	public String register(BoardVO boardVO,RedirectAttributes rttr){
		log.info("register...");
		service.register(boardVO);
		rttr.addFlashAttribute("result",boardVO.getBno());
		
		return "redirect:/board/list";
		
	}
	@PostMapping("modify")
	public String modify(BoardVO boardVO,@ModelAttribute("cri") Criteria cri,RedirectAttributes rttr){
		log.info("modify...");
		service.modify(boardVO);
		
		if(service.modify(boardVO)){
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list" +cri.getListLink();
	}
	
	
	@PostMapping("remove")
	public String remove(@RequestParam Long bno,@ModelAttribute("cri")Criteria cri,RedirectAttributes rttr){
		log.info("remove...");
		if(service.remove(bno)){
			log.info("remove...성공");
			rttr.addFlashAttribute("result","success");
		}
		
		return "redirect:/board/list"+cri.getListLink();
	}

}

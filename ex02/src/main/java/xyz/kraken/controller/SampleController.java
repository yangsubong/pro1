package xyz.kraken.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;
import xyz.kraken.domain.BoardVO;
import xyz.kraken.domain.Criteria;
import xyz.kraken.domain.SampleVO;
import xyz.kraken.domain.Ticket;
import xyz.kraken.service.BoardService;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping(value="getText",produces="text/plain; charset=utf-8")
	public String getText(){
		log.info("Mime type :: " + MediaType.TEXT_PLAIN_VALUE);
		return "안니하으아";

	}
	@GetMapping(value="getSample", produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample(){
		return new SampleVO(112,"스타로두","으앙");
	}
	@GetMapping("listTest")
	public List<BoardVO> getList(){
		return boardService.getList(new Criteria());
	}
	@GetMapping("listTest2")
	public List<SampleVO> getList2(){
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i+"first",i+"last")).collect(Collectors.toList());
	}
	
	@GetMapping(value="check",params={"height","weight"})
	public ResponseEntity<SampleVO> check(double height,double weight){
		SampleVO vo = new SampleVO(0,""+height,""+weight);
	
		ResponseEntity<SampleVO> result = null;
		
		if(height < 150){
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}
		else {
			 
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
			
		}
		return result;
	}
	@GetMapping("product")
	public String[] getPath(String cat, Integer pid){
		return new String[]{"catehory:   " + cat, "productid" + pid};
	}
	@GetMapping("product/{cat}/{pid}")
	public String[] getPath2(@PathVariable String cat,@PathVariable Integer pid){
		return new String[]{"catehory:   " + cat, "productid" + pid};
	}
	
	@PostMapping("ticket")
	public Ticket convert(@RequestBody Ticket ticket){
		log.info(ticket);
		return ticket;
	}
}

package xyz.kraken.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Delegate;
import lombok.extern.log4j.Log4j;
import xyz.kraken.domain.Criteria;
import xyz.kraken.domain.ReplyVO;
import xyz.kraken.service.ReplyService;

@RestController
@RequestMapping("/replies/")
@Log4j
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService service;
	
	//등록
	@PostMapping("new")
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info(vo);
		int insertCount = service.register(vo);
		log.info("inserCount ::" +insertCount);
		return insertCount == 1 ?
					new ResponseEntity<>("success",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//조회
	@GetMapping("{rno}")
	public ResponseEntity<ReplyVO> get(@PathVariable long rno){
		log.info(rno);
		return new ResponseEntity<ReplyVO>(service.get(rno), HttpStatus.OK);
	}
	
	//수정
	@RequestMapping(value="{rno}",method={RequestMethod.PUT,RequestMethod.PATCH})
	public ResponseEntity<String> modify( @PathVariable("rno") long rno,@RequestBody ReplyVO vo){
		log.info(vo);
		vo.setRno(rno);
		int updateCount= service.modify(vo);
		log.info("updateCount ::" +updateCount);
		return updateCount == 1 ?
					new ResponseEntity<>("success",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//삭제
	@DeleteMapping("{rno}")
	public ResponseEntity<String> remove( @PathVariable long rno){
		log.info(rno);
		int removeCount= service.remove(rno);
		log.info("removeCount ::" + removeCount);
		return removeCount == 1 ?
					new ResponseEntity<>("success",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//페이지(목록)
	@GetMapping("pages/{page}/{bno}")
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable int page,@PathVariable long bno){
		log.info("getList");
		Criteria cri = new Criteria(page, 10);
		log.info(cri);
		
		return new ResponseEntity<>(service.getList(cri, bno),HttpStatus.OK);
	}
}

package xyz.kraken.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import xyz.kraken.domain.BoardVO;
import xyz.kraken.domain.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j//로그
public class BoardServiceTests {
	
	@Autowired //탐색
	private BoardService service;
	
	@Test
	public void testExist(){
			assertNotNull(service);
			log.info(service);
	}
	
	@Test
	public void testRegister(){
		
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("단위 테스트 작성 제목 in Service");
		boardVO.setContent("단위 테스트 작성 내용 in Service");
		boardVO.setWriter("newbie");
		
		service.register(boardVO);
		log.info("생성된 게시글의 번호  : " + boardVO.getBno());
	}
	
	@Test
	public void testGetList(){
		service.getList(new Criteria()).forEach(log::info);
	}
	

	@Test
	public void testModify(){
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("수정된 단위 테스트 작성 제목 in Service");
		boardVO.setContent("수정된 단위 테스트 작성 내용 in Service");
		boardVO.setWriter("newbie");
		boardVO.setBno(5l);
		
		log.info(service.modify(boardVO));
	}
	
	@Test
	public void testGet(){
		 log.info(service.get(5l));
	}
	@Test
	public void testRemove(){
		log.info(service.remove(10L));
	}
	
	@Test
	public void testGetTotal(){
		log.info(service.getTotal(new Criteria()));
	}
	
}

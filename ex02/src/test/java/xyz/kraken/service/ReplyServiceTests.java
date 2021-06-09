package xyz.kraken.service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import xyz.kraken.domain.Criteria;
import xyz.kraken.domain.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTests {

	@Autowired
	private ReplyService service;

	@Test
	public void Exit() {
		log.info(service);
	}

	@Test
	public void testRegister() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(196653l);
		vo.setReply("서비스 :: 서비스");
		vo.setReplyer("번째 댓글러");
		log.info("regisert" + service.register(vo));
	}

	@Test
	public void testGet() {
		long rno = 8l;
		log.info("testGet :::" + service.get(rno));
	}

	@Test
	public void testModify() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(8l);
		vo.setReply("서비스 작성글");
		log.info("modify" + service.modify(vo));
	}

	@Test
	public void testRemove() {
		long rno = 8l;
		log.info(service.remove(rno));
	}
	@Test
	public void testGetList() {
		service.getList(new Criteria(), 193865l).forEach(log::info);
	}
}

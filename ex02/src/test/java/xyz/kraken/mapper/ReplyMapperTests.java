package xyz.kraken.mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import xyz.kraken.domain.BoardVO;
import xyz.kraken.domain.Criteria;
import xyz.kraken.domain.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Test
	public void testExist(){
		log.info(replyMapper);
	}
	
	@Test
	public void testInsert(){
		IntStream.range(1, 21).forEach(i->{
			ReplyVO vo = new ReplyVO();
			vo.setBno(193865l);
			vo.setReply("junit에서 작성한 댓글 ::" + i);
			vo.setReplyer( i +"번째 댓글러");
			
			replyMapper.insert(vo);
		});
	}
	@Test
	public void testInsert2(){
			Map<String, Object> vo = new HashMap<String, Object>();
			vo.put("bno", 193865l);
			vo.put("reply" ,"맵으로 작성한댓글");
			vo.put("replyer","크크크크");
			
			replyMapper.insert2(vo);
		
	}
	@Test
	public void testGetList(){
		replyMapper.getListWithPaging(new Criteria(), 193865l).forEach(log::info);
	}
	@Test
	public void testGetList2(){
		replyMapper.getListWithPaging2(new Criteria(), 193865l).forEach(log::info);
	}
	@Test
	public void testUpdate(){
		ReplyVO vo  = new ReplyVO();
		vo.setBno(193865l);
		vo.setReply("준잇에서 수정한 댓글");
		vo.setReplyer("댓걸러");
		vo.setRno(6l);
		log.info(replyMapper.update(vo));
	}
	
	
	@Test
	public void testRead(){
		log.info(replyMapper.read(6l));
	}
	@Test
	public void testDelete(){
		log.info(replyMapper.read(6l));
	}
}

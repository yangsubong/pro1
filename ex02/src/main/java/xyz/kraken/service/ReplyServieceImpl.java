package xyz.kraken.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import xyz.kraken.domain.Criteria;
import xyz.kraken.domain.ReplyVO;
import xyz.kraken.mapper.ReplyMapper;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Log4j
public class ReplyServieceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public int register(ReplyVO vo) {
		log.info("regisert :: " + vo);
		return replyMapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("get :: " + rno);
		return replyMapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		log.info("modify ::" + vo);
		return replyMapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		log.info("remove ::" + rno);
		return replyMapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("getList   ::" + cri+":::"+ bno);
		return replyMapper.getListWithPaging(cri, bno);
	}

}

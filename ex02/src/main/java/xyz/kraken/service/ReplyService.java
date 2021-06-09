package xyz.kraken.service;

import java.util.List;

import xyz.kraken.domain.Criteria;
import xyz.kraken.domain.ReplyVO;

public interface ReplyService {
	
	int register(ReplyVO vo);
	
	ReplyVO get(Long rno);
	
	int modify(ReplyVO vo);
	
	int remove(Long rno);
	
	List<ReplyVO> getList(Criteria cri, Long bno);
	
}

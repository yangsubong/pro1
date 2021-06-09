package xyz.kraken.service;

import java.util.List;

import xyz.kraken.domain.BoardVO;
import xyz.kraken.domain.Criteria;

public interface BoardService {
	
	public void register(BoardVO boardVO);// 글등록
	
	BoardVO get(Long bno);// 상세조회
	
	boolean modify(BoardVO boardVO);//수정
	
	boolean remove(Long bno);// 삭제
	
	List<BoardVO> getList(Criteria cri);
	
	int getTotal(Criteria cri);
	
	
}

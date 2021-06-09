package xyz.kraken.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import xyz.kraken.domain.BoardVO;
import xyz.kraken.domain.Criteria;
import xyz.kraken.mapper.BoardMapper;

@Service// 빈생성
@Log4j // 로그 찍힘
@AllArgsConstructor //생성자 생기고 바인딩
public class BoardServiceImpl implements BoardService {
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO boardVO) {
		log.info("register..." + boardVO);
		mapper.insertSelectKey(boardVO);
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return mapper.update(boardVO) >0;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno) > 0;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}



	


}

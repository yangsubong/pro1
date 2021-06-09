package xyz.kraken.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import xyz.kraken.domain.BoardVO;
import xyz.kraken.domain.Criteria;

public interface BoardMapper {
	
//	@Select("SELECT * FROM TBL_BOARD WHERE BNO > 0")
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	public void insert(BoardVO boardVO);
	public void insertSelectKey(BoardVO boardVO);
	
	public BoardVO read(Long bno);
	
	public int delete(long bno);
	
	public int update(BoardVO boardVO);
	
	public int getTotalCount(Criteria cri);
	
}

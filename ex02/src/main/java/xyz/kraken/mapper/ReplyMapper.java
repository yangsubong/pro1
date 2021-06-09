package xyz.kraken.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import xyz.kraken.domain.Criteria;
import xyz.kraken.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo);
	
	public void insert2(Map<String, Object> vo);
	
	ReplyVO read(Long rno);
	
	int update(ReplyVO vo);
	
	int delete(Long rno);
	
	List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri,@Param("bno") Long bno);
	List<Map<String, Object>> getListWithPaging2(@Param("cri") Criteria cri,@Param("bno") Long bno);
	
}

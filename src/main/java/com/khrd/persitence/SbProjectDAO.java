package com.khrd.persitence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.khrd.domain.SbProjectVO;

public interface SbProjectDAO {
	public void sbPInsert(SbProjectVO vo);
	public List<SbProjectVO> sbPList();
	public void delete(int sbNo);
	public void update(SbProjectVO vo);
	
	public SbProjectVO sbPView(int sbNo);
	public List<SbProjectVO> SelectSbPBySbNo(@Param("sbStart") String sbStart, @Param("sbEnd") String sbEnd);
}

package com.khrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khrd.domain.SbProjectVO;
import com.khrd.persitence.SbProjectDAO;

@Service
public class SbProjectServiceImpl implements SbProjectService{

	@Autowired
	private SbProjectDAO dao;
	
	
	
	@Override
	public void sbPInsert(SbProjectVO vo) {
		dao.sbPInsert(vo);
	}

	@Override
	public List<SbProjectVO> sbPList() {
		return dao.sbPList();
	}

	@Override
	public void delete(int sbNo) {
		dao.delete(sbNo);
	}

	@Override
	public void update(SbProjectVO vo) {
		dao.update(vo);
	}

	@Override
	public SbProjectVO sbPView(int sbNo) {
		return dao.sbPView(sbNo);
	}

	@Override
	public List<SbProjectVO> SelectSbPBySbNo(String sbStart, String sbEnd) {
		return dao.SelectSbPBySbNo(sbStart, sbEnd);
	}

}

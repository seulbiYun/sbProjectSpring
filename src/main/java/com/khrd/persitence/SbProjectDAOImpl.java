package com.khrd.persitence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khrd.domain.SbProjectVO;
@Repository
public class SbProjectDAOImpl implements SbProjectDAO {
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace = "mappers.ProjectMapper";
	
	@Override
	public void sbPInsert(SbProjectVO vo) {
		sqlSession.insert(namespace + ".sbPInsert", vo);
	}

	@Override
	public List<SbProjectVO> sbPList() {
		return sqlSession.selectList(namespace+".sbPList");
	}

	@Override
	public void delete(int sbNo) {
		sqlSession.delete(namespace+".delete", sbNo);
	}

	@Override
	public void update(SbProjectVO vo) {
		sqlSession.update(namespace+".update", vo);
	}

	@Override
	public SbProjectVO sbPView(int sbNo) {
		return sqlSession.selectOne(namespace + ".sbPView", sbNo);
	}

	@Override
	public List<SbProjectVO> SelectSbPBySbNo(String sbStart, String sbEnd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("sbStart", sbStart);
		map.put("sbEnd", sbEnd);
		return sqlSession.selectList(namespace+".SelectSbPBySbNo", map);
	}

}

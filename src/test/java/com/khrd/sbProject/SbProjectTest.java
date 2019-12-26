package com.khrd.sbProject;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khrd.domain.SbProjectVO;
import com.khrd.persitence.SbProjectDAO;

@RunWith(SpringJUnit4ClassRunner.class) //bean을 가져올 수 있도록 등록
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}) // bean과 연결
public class SbProjectTest {
	private static final Logger logger = LoggerFactory.getLogger(SbProjectTest.class);
	
	@Autowired
	private SbProjectDAO dao;
	
	//@Test
	public void testSbPInsert() {
		dao.sbPInsert(new SbProjectVO(0, "비밀이다", "비밀이라고 하지 않았느냐", new Date(), new Date(), 1));
	}
	
	//@Test
	public void testSbPList(){
		dao.sbPList();
	}
	
	//@Test 
	public void testSbPBySbNo() {
		dao.sbPView(1);
	}
	
	//@Test
	public void testSelectSbPBySbNo() {
		dao.SelectSbPBySbNo("2019-11-01", "2020-02-02");
	}
	
	//@Test
	public void testDelete() {
		dao.delete(5);
	}
	
	@Test
	public void testUpdate() {
		dao.update(new SbProjectVO(3, "test", "test", new Date(), new Date(), 3));
	}
	
}

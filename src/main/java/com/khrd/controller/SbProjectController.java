package com.khrd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khrd.domain.SbProjectVO;
import com.khrd.service.SbProjectService;

@RequestMapping("/sbproject/*")
@Controller
public class SbProjectController {
	private static final Logger logger = LoggerFactory.getLogger(SbProjectController.class);
	
	@Autowired
	private SbProjectService service;  
	
	@RequestMapping(value = "sbPList",method=RequestMethod.GET)
	public void sbPList(Model model){
		logger.info("----------------listAll-----------------");
		
		List<SbProjectVO> list = service.sbPList();
		logger.info(list+"-------------LIST--------------");
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "sbPInsert",method = RequestMethod.GET)
	public void insertGet() {
		logger.info("------------------------------register GET--------------------------------");
	}
	
	@RequestMapping(value = "sbPInsert",method = RequestMethod.POST)
	public String isnertPOST(SbProjectVO vo) {
		logger.info("---------------------------------register POST------------------------------");
		logger.info(vo.toString());
		
		service.sbPInsert(vo);
		
		return "redirect:/sbproject/sbPList";
	}
	
	@RequestMapping(value = "sbPView", method = RequestMethod.GET)
	public void readPage(int sbNo, Model model) {
		logger.info("-------------------------readPage---------------");
		
		SbProjectVO vo = service.sbPView(sbNo);
		
		model.addAttribute("sb", vo);
		
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int sbNo) {
		logger.info("----------------remove------------------------");
		
		service.delete(sbNo);
		
		
		return "redirect:/sbproject/sbPList";
	}
	
	@RequestMapping(value = "sbPUpdate", method = RequestMethod.GET)
	public void updateGet(int sbNo,Model model) {
		logger.info("-----------------modify-----------------"+sbNo);
		
		SbProjectVO vo = service.sbPView(sbNo);
		
		model.addAttribute("sb",vo); 
	}
	
	@RequestMapping(value = "sbPUpdate", method = RequestMethod.POST)
	public String updatePost(SbProjectVO vo) {
		logger.info("-----------------modify-----------------"+vo.toString());
		
		service.update(vo);
		
		return "redirect:/sbproject/sbPView?sbNo="+vo.getSbNo();
	}
	
}

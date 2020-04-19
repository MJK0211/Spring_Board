package com.mjk.bit.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mjk.bit.domain.BoardVO;
import com.mjk.bit.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.mjk.bit.config.RootConfig.class })
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	
	/*
	 * public void testGetList() { mapper.getList().forEach(board ->
	 * log.info(board)); }
	 */
	

	public void testInsert() {
		
		BoardVO board = new BoardVO();
		board.setTitle("���� �ۼ��ϴ� ��");
		board.setContent("���� �ۼ��ϴ� ����");
		board.setWriter("newbie");
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	
	
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		board.setTitle("���� �ۼ��ϴ� �� select key");
		board.setContent("���� �ۼ��ϴ� ���� select key");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	
	public void testRead() {
		BoardVO board = mapper.read(5);
		
		log.info(board);
	}
	
	
	public void testDelete() {
		
		log.info("DELETE COUNT: " + mapper.delete(3));
	}
	
	
	public void testUpdate() {
		
		BoardVO board = new BoardVO();
		
		board.setBno(5);
		board.setTitle("������ ����");
		board.setContent("������ ����");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: "+ count);
		
	}
		
	public void testPaging() {
		Criteria cri = new Criteria();
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
		
	}
	
	@Test
	public void testSearch() {
		
		Criteria cri = new Criteria();
		cri.setKeyword("����");
		cri.setType("tc");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
	
}

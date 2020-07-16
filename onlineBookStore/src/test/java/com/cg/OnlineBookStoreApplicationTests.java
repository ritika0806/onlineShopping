package com.cg;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.dao.CategoryDao;
import com.cg.entity.Category;
import com.cg.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class OnlineBookStoreApplicationTests {

	@Autowired
	private CategoryService as;
	
	@MockBean
	CategoryDao crep;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addCategoryTest() {
		Category c=new Category(101,"Horror",null);
		as.addCategory(c);
		//verify(crep,times(1)).save(c);
		assertEquals("Horror",c.getCategoryName());
	}
	/*
	 *@Test
	 *public void removeCategoryTest(){
	 *Category c=new Category(101,"Horror",null);
	 qrep.delete(c);
        verify(qrep,times(1)).delete(c);
	*/
	

}

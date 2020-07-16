package com.cg.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.dao.CategoryDao;

import com.cg.entity.Category;
import com.cg.exceptions.CategoryException;
import com.cg.exceptions.CategoryProjectException;
import com.cg.exceptions.ErrorCode;

@Service
@Transactional
public class CategoryService implements CategoryIService {
	@Autowired
	private CategoryDao dao;
	
	
	private static final String ACTION_1 = "Exception while writing data to persistant layer";
	public Category addCategory(Category category) {
		if (validateCategory(category)) {
            try {
	dao.save(category);
            } catch (Exception e) {
                throw new CategoryProjectException(ErrorCode.SYSTEM_EXCEPTION, ACTION_1, e);
            }
            return category;
        }
        throw new CategoryException(ErrorCode.BAD_DATA, "Valid date is required");
	
	}


	private Boolean validateCategory(Category category) {
        if (category.getCategoryName() == null || category.getCategoryName().isEmpty()) {
            throw new CategoryException(ErrorCode.BAD_DATA, "Category Name should not be empty");
        }
        return true;
    }


}

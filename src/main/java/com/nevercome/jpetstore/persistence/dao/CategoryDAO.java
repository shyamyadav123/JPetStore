package com.nevercome.jpetstore.persistence.dao;

import com.nevercome.jpetstore.domain.model.Category;

import java.util.List;

public interface CategoryDAO {

    List<Category> getCategoryList();

    Category getCategory(String categoryId);
}

package org.csu.my_pet_store_spring.persistence;

import org.csu.my_pet_store_spring.domain.Category;

import java.util.List;


public interface CategoryMapper {

  List<Category> getCategoryList();

  Category getCategory(String categoryId);

}

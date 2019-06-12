package org.csu.jpetstore.persistence;

import org.csu.jpetstore.domain.Category;

import java.util.List;

/**
 * @author: sun
 * @date: 2019/6/12
 */
public interface CategoryMapper {

    List<Category> getCategoryList();

    Category getCategory(String categoryId);

}

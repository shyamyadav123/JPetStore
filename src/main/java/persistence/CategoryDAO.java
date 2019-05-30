package persistence;

import domain.Category;

import java.util.List;

/**
 * @author: sun
 * @date: 2019/5/23
 */
public interface CategoryDAO {

    List<Category> getCategoryList();

    Category getCategory(String categoryId);

}

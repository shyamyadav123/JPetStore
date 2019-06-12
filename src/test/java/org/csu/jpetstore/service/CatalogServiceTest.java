package org.csu.jpetstore.service;

import org.csu.jpetstore.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: sun
 * @date: 2019/6/12
 */
public class CatalogServiceTest extends BaseTest {

    @Autowired
    private CatalogService catalogService;

    @Test
    public void testGetCategory() {
        String categoryId = "FISH";
        assert catalogService.getCategory(categoryId).getName().equals("Fish");
    }

}

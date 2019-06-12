package org.csu.jpetstore.controller;

import org.csu.jpetstore.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author: sun
 * @date: 2019/6/12
 */
public class CatalogControllerTest extends BaseTest {

    @Autowired
    private CatalogController catalogController;

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(catalogController).build();
    }


    @Test
    public void testGetCategory() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .get("/catalog/category/FISH")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(builder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

}

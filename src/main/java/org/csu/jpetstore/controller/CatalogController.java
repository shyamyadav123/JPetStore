package org.csu.jpetstore.controller;

import org.csu.jpetstore.common.result.ResponseResult;
import org.csu.jpetstore.domain.Category;
import org.csu.jpetstore.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sun
 * @date: 2019/6/12
 */
@ResponseResult
@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable("id") String id) {
        return catalogService.getCategory(id);
    }

}

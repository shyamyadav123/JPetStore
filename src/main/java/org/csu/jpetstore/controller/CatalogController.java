package org.csu.jpetstore.controller;

import org.csu.jpetstore.common.result.PlatformResult;
import org.csu.jpetstore.common.result.ResponseResult;
import org.csu.jpetstore.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: sun
 * @date: 2019/6/12
 */
@ResponseResult
@RestController
@RequestMapping("/catalog")
@CrossOrigin
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/category/{id}")
    public PlatformResult getCategory(@PathVariable("id") String id) {
        return PlatformResult.success(catalogService.getCategory(id));
    }

    @GetMapping("/category/{id}/products")
    public PlatformResult getProducts(@PathVariable("id") String id) {
        return PlatformResult.success(catalogService.getProductListByCategory(id));
    }

}

package org.csu.my_pet_store_spring.controller;

import org.csu.my_pet_store_spring.domain.Category;
import org.csu.my_pet_store_spring.domain.Item;
import org.csu.my_pet_store_spring.domain.Product;
import org.csu.my_pet_store_spring.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class catalogController {
    @Autowired
    private CatalogService catalogService;

    @GetMapping("/catalog/category")
    public String viewCategory(@RequestParam("categoryId") String categoryId, Model model){
        if (categoryId!=null) {
            Category category = catalogService.getCategory(categoryId);
            List<Product> productList = catalogService.getProductListByCategory(categoryId);
            model.addAttribute("category", category);
            model.addAttribute("productList", productList);
        }
        return "catalog/Category";
    }

    @GetMapping("/catalog/product")
    public String viewProduct(@RequestParam("productId") String productId, Model model){
        Product product=catalogService.getProduct(productId);
        List<Item> itemList=catalogService.getItemListByProduct(productId);
        model.addAttribute("product",product);
        model.addAttribute("itemList",itemList);
        return "catalog/Product";
    }

    @GetMapping("/catalog/item")
    public String viewItem(@RequestParam("itemId") String itemId,Model model){
        Item item=catalogService.getItem(itemId);
        model.addAttribute("product",item.getProduct());
        model.addAttribute("item",item);
        return  "catalog/Item";
    }

    @PostMapping("/catalog/searchProduct")
    public String searchProduct(@RequestParam("keyword") String keyword,Model model){
        List<Product> productList= catalogService.searchProductList(keyword);
        model.addAttribute("productList",productList);
        return "catalog/SearchProduct";
    }
}

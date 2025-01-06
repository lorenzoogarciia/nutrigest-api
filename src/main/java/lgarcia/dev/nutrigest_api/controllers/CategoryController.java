package lgarcia.dev.nutrigest_api.controllers;

import lgarcia.dev.nutrigest_api.models.CategoryModel;
import lgarcia.dev.nutrigest_api.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // GET Petitions
    @GetMapping
    public ArrayList<CategoryModel> getCategories() {
        return this.categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public CategoryModel getCategoryById(@PathVariable Long id) {
        return this.categoryService.getCategoryById(id);
    }

    // POST Petitions
    @PostMapping
    public CategoryModel storeCategory(@RequestBody CategoryModel category) {
        return this.categoryService.storeCategory(category);
    }

    // PUT and DELETE Petitions
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        this.categoryService.deleteCategory(id);
    }
}

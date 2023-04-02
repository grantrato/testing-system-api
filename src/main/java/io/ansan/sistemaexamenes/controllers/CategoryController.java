package io.ansan.sistemaexamenes.controllers;

import io.ansan.sistemaexamenes.entity.Category;
import io.ansan.sistemaexamenes.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @PostMapping("/")
  public ResponseEntity<Category> saveCategory(@RequestBody Category category){
      return ResponseEntity.ok(categoryService.addCategory(category));
  }

  @GetMapping("/{id}")
  public Category listCategoryById(@PathVariable("id") Long id){
      return categoryService.getCategory(id);
  }

  @GetMapping("/")
  public ResponseEntity<?> listCategories(){
      return ResponseEntity.ok(categoryService.getCategories());
  }

  @PutMapping("/")
  public ResponseEntity<Category> updateCategory(@RequestBody Category category){
      return ResponseEntity.ok(categoryService.updateCategory(category));
  }

  @DeleteMapping("/{id}")
  public void deleteCategory(@PathVariable("id") Long id){
      categoryService.deleteCategory(id);
      
  }
}
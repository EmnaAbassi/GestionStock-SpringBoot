package com.emna.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emna.demo.Exception.RessourceNotFoundException;
import com.emna.demo.Repository.CategoryRepository;
import com.emna.demo.model.Category;

@RestController
@RequestMapping("/api/v1/")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;
	
	//get all categories
		@GetMapping("/category")
		public List<Category> gelAllCategory(){
			return categoryRepository.findAll();
		}
	
		//create category
		@PostMapping("/category")
		public Category createCategory(@RequestBody Category c) {
			return categoryRepository.save(c);
	
}
		
		//get category by id
		@GetMapping("/category/{id}")
		public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
			Category c = categoryRepository.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("category not exist with id " +id));
		
			return ResponseEntity.ok(c);
		}
		
		//UPDATE category 
		@PutMapping("/category/{id}")
		public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category categoryDetails){
			Category c = categoryRepository.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("category not exist with id " +id));
			
			c.setCode(categoryDetails.getCode());
			c.setDescription(categoryDetails.getDescription());
			c.setArticle(categoryDetails.getArticle());
			
			Category updatedCategory = categoryRepository.save(c);
			return ResponseEntity.ok(updatedCategory);
			
		}
		
		
		//Delete category
		@DeleteMapping("/category/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteCategory (@PathVariable int id){
			Category c = categoryRepository.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("category not exist with id " +id));
			
			categoryRepository.delete(c);
			//on utilse le map ici pour retourner un mesge de type boolean apres la suppression de notre en tite et qui va retourner deleted successfully
			Map<String, Boolean> response = new HashMap<>();
			
			response.put("Your entity is deleted :)", Boolean.TRUE);
			return ResponseEntity.ok(response);
		
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}

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
import com.emna.demo.Repository.ArticleRepository;
import com.emna.demo.model.Article;

@RestController
@RequestMapping("/api/v1/")
public class ArticleController {
	@Autowired
	private ArticleRepository articleRepository;

	//get all articles
	@GetMapping("/articles")
	public List<Article> gelAllArtilces(){
		return articleRepository.findAll();
	}
	
	//create article
	@PostMapping("/articles")
	public Article createArticle(@RequestBody Article article) {
		return articleRepository.save(article);
	}
	
	//get article by id
	@GetMapping("/articles/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable int id) {
		Article article = articleRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("article not exist with id " +id));
	
		return ResponseEntity.ok(article);
	}
	
	
	//UPDATE article 
	@PutMapping("/articles/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable int id, @RequestBody Article articleDetails){
		Article article = articleRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("article not exist with id " +id));
		article.setCodeArticle(articleDetails.getCodeArticle());
		article.setDesignation(articleDetails.getDesignation());
		article.setPrixUnitaireTTC(articleDetails.getPrixUnitaireTTC());
		article.setPrixUnitaireHT(articleDetails.getPrixUnitaireHT());
		article.setTauxTVA(articleDetails.getTauxTVA());
		
		Article updatedArticle = articleRepository.save(article);
		return ResponseEntity.ok(updatedArticle);
		
	}
	
	//Delete Article 
	@DeleteMapping("/articles/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteArticle (@PathVariable int id){
		Article article = articleRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("article not exist with id " +id));
		
		articleRepository.delete(article);
		//on utilse le map ici pour retourner un mesge de type boolean apres la suppression de notre en tite et qui va retourner deleted successfully
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Your entity is deleted :)", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	
}

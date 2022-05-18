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
import com.emna.demo.Repository.UtilisateurRepository;
import com.emna.demo.model.Article;
import com.emna.demo.model.Utilisateur;

@RestController
@RequestMapping("/api/v1/")
public class UtilisateurController {
	@Autowired
	private UtilisateurRepository userRepo;
	
	//get all Users
		@GetMapping("/users")
		public List<Utilisateur> gelAllUtilisateur(){
			return userRepo.findAll();
		}
	

		//create user
		@PostMapping("/users")
		public Utilisateur createUser(@RequestBody Utilisateur user) {
			return userRepo.save(user);
		}
		
		//get user by id
		@GetMapping("/users/{id}")
		public ResponseEntity<Utilisateur> getArticleById(@PathVariable int id) {
			Utilisateur user= userRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("article not exist with id " +id));
		
			return ResponseEntity.ok(user);
		}

		
		//UPDATE Utilisateur
		@PutMapping("/users/{id}")
		public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable int id, @RequestBody Utilisateur UtilisateurDetails){
			Utilisateur user = userRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("user not exist with id " +id));
			
			user.setEmail(UtilisateurDetails.getEmail());
			user.setMotDePasse(UtilisateurDetails.getMotDePasse());
			user.setNom(UtilisateurDetails.getNom());
			user.setPrenom(UtilisateurDetails.getPrenom());
            user.setAdresse1(UtilisateurDetails.getAdresse1());
            user.setAdresse2(UtilisateurDetails.getAdresse2());
            user.setCodePostale(UtilisateurDetails.getCodePostale());
            user.setNumTel(UtilisateurDetails.getNumTel());
            user.setVille(UtilisateurDetails.getVille());
			Utilisateur updatedUtilisateur = userRepo.save(user);
			return ResponseEntity.ok(updatedUtilisateur);
			
		}
		
		//Delete user
		@DeleteMapping("/users/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteUtilisateur (@PathVariable int id){
			Utilisateur user = userRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("Utilisateur not exist with id " +id));
			
			userRepo.delete(user);
			
			//on utilse le map ici pour retourner un mesge de type boolean apres la suppression de notre en tite et qui va retourner deleted successfully
			Map<String, Boolean> response = new HashMap<>();
			
			response.put("Your entity is deleted :)", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
























}

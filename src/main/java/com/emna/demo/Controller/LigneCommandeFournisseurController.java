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
import com.emna.demo.Repository.LigneCFRepository;
import com.emna.demo.model.LigneCommandeFournisseur;

@RestController
@RequestMapping("/api/v1/")
public class LigneCommandeFournisseurController {
	@Autowired
	private LigneCFRepository LCFRepo;
	
	//get all LigneCF
		@GetMapping("/LigneCF")
		public List<LigneCommandeFournisseur> gelAllLigneCF(){
			return LCFRepo.findAll();
		}
		
		//create LigneCF
		@PostMapping("/LigneCF")
		public LigneCommandeFournisseur createLigneCF(@RequestBody LigneCommandeFournisseur LCF) {
			return LCFRepo.save(LCF);
		}
		
		//get LigneCF by id
		@GetMapping("/LigneCF/{id}")
		public ResponseEntity<LigneCommandeFournisseur> getLigneCFById(@PathVariable int id) {
			LigneCommandeFournisseur LCF = LCFRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("LigneCommandeFournisseur not exist with id " +id));
		
			return ResponseEntity.ok(LCF);
		}
		
		
		//UPDATE LigneCF
		@PutMapping("/LigneCF/{id}")
		public ResponseEntity<LigneCommandeFournisseur> updateLigneCF(@PathVariable int id, @RequestBody LigneCommandeFournisseur LCFDetails){
			LigneCommandeFournisseur LCF = LCFRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("LigneCommandeFournisseur not exist with id " +id));
			
			
			LCF.setArticle(LCFDetails.getArticle());
			LCF.setCommandeFournisseurs(LCFDetails.getCommandeFournisseurs());
			LCF.setQuantite(LCFDetails.getQuantite());
			
			
			LigneCommandeFournisseur updatedLCF = LCFRepo.save(LCF);
			return ResponseEntity.ok(updatedLCF);
			
		}
		
		//Delete LigneCF 
		@DeleteMapping("/LigneCF/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteLigneCF (@PathVariable int id){
			LigneCommandeFournisseur LCF = LCFRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("LCF not exist with id " +id));
			
			LCFRepo.delete(LCF);
			//on utilse le map ici pour retourner un mesge de type boolean apres la suppression de notre en tite et qui va retourner deleted successfully
			Map<String, Boolean> response = new HashMap<>();
			
			response.put("Your entity is deleted :)", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

}

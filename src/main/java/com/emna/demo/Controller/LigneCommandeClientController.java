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
import com.emna.demo.Repository.LigneCCRepository;
import com.emna.demo.model.LigneCdeClient;

@RestController
@RequestMapping("/api/v1/")
public class LigneCommandeClientController {
	@Autowired
	private LigneCCRepository LCCRepo;
	
	//get all LigneCommandesClients
		@GetMapping("/LCC")
		public List<LigneCdeClient> gelAllLCC(){
			return LCCRepo.findAll();
		}
		
		//create LigneCdeClient
		@PostMapping("/LCC")
		public LigneCdeClient createLCC(@RequestBody LigneCdeClient LCC) {
			return LCCRepo.save(LCC);
		}
		
		//get LigneCdeClient by id
		@GetMapping("/Lcc/{id}")
		public ResponseEntity<LigneCdeClient> getLigneCdeClientById(@PathVariable int id) {
			LigneCdeClient LCC = LCCRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("LCC not exist with id " +id));
		
			return ResponseEntity.ok(LCC);
		}
		
		
		//UPDATE LigneCdeClient
		@PutMapping("/LCC/{id}")
		public ResponseEntity<LigneCdeClient> updateLigneCdeClient(@PathVariable int id, @RequestBody LigneCdeClient LCCDetails){
			LigneCdeClient LCC = LCCRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("LCC not exist with id " +id));
			
			LCC.setArticle(LCCDetails.getArticle());
			LCC.setCommandeClients(LCCDetails.getCommandeClients());
			LCC.setPrixUnitaire(LCCDetails.getPrixUnitaire());
			LCC.setQuantit(LCCDetails.getPrixUnitaire());
			
			
			LigneCdeClient updatedLCC = LCCRepo.save(LCC);
			return ResponseEntity.ok(updatedLCC);
			
		}
		
		//Delete Article 
		@DeleteMapping("/LCC/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteLigneCdeClient (@PathVariable int id){
			LigneCdeClient LCC = LCCRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("LCC not exist with id " +id));
			
			LCCRepo.delete(LCC);
			//on utilse le map ici pour retourner un mesge de type boolean apres la suppression de notre en tite et qui va retourner deleted successfully
			Map<String, Boolean> response = new HashMap<>();
			
			response.put("Your entity is deleted :)", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
	
	
	
	
	
	
	
}

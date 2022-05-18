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
import com.emna.demo.Repository.LigneVenteRepository;
import com.emna.demo.model.LigneVente;

@RestController
@RequestMapping("/api/v1/")
public class LigneVenteController {

	@Autowired
	private LigneVenteRepository LvRepo;
	
	//get all LV
		@GetMapping("/lv")
		public List<LigneVente> gelAllLv(){
			return LvRepo.findAll();
		}
		
		//create LV
		@PostMapping("/lv")
		public LigneVente createLv(@RequestBody LigneVente lv) {
			return LvRepo.save(lv);
		}
		
		//get LV by id
		@GetMapping("/lv/{id}")
		public ResponseEntity<LigneVente> getLvById(@PathVariable int id) {
			LigneVente lv = LvRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("lv not exist with id " +id));
		
			return ResponseEntity.ok(lv);
		}
		
		
		//UPDATE LV 
		@PutMapping("/lv/{id}")
		public ResponseEntity<LigneVente> updateLv(@PathVariable int id, @RequestBody LigneVente LigneVenteDetails){
			LigneVente lv = LvRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("lv not exist with id " +id));
			
			lv.setPrixUnitaire(LigneVenteDetails.getPrixUnitaire());
			lv.setQuantite(LigneVenteDetails.getQuantite());
			lv.setVente(LigneVenteDetails.getVente());
			
			LigneVente updatedLigneVente = LvRepo.save(lv);
			return ResponseEntity.ok(updatedLigneVente);
			
		}
		
		//Delete LV 
		@DeleteMapping("/lv/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteLigneVente (@PathVariable int id){
			LigneVente article = LvRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("lv not exist with id " +id));
			
			LvRepo.delete(article);
			//on utilse le map ici pour retourner un mesge de type boolean apres la suppression de notre en tite et qui va retourner deleted successfully
			Map<String, Boolean> response = new HashMap<>();
			
			response.put("Your entity is deleted :)", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

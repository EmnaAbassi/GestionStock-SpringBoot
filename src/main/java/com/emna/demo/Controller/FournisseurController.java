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
import com.emna.demo.Repository.FournisseurRepository;
import com.emna.demo.model.Fournisseur;

@RestController
@RequestMapping("/api/v1/")
public class FournisseurController {
	@Autowired
	private FournisseurRepository FourRepo;
	
	//get all Fournisseur
		@GetMapping("/FOUR")
		public List<Fournisseur> gelAllFournisseur(){
			return FourRepo.findAll();
		}
		
		//create Fournisseur
		@PostMapping("/FOUR")
		public Fournisseur createFournisseur(@RequestBody Fournisseur F) {
			return FourRepo.save(F);
		}
		
		//get Fournisseur by id
		@GetMapping("/FOUR/{id}")
		public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable int id) {
			Fournisseur F = FourRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("Fournisseur not exist with id " +id));
		
			return ResponseEntity.ok(F);
		}
		
		
		//UPDATE Fournisseur 
		@PutMapping("/FOUR/{id}")
		public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable int id, @RequestBody Fournisseur FournisseurDetails){
			Fournisseur F = FourRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("Fournisseur not exist with id " +id));
			
			F.setAdresse1(FournisseurDetails.getAdresse1());
			F.setAdresse2(FournisseurDetails.getAdresse2());
			F.setCodePostale(FournisseurDetails.getCodePostale());
			F.setVille(FournisseurDetails.getVille());
			F.setCommandeFournisseurs(FournisseurDetails.getCommandeFournisseurs());
			F.setLignecommandefournisseur(FournisseurDetails.getLignecommandefournisseur());
			F.setMail(FournisseurDetails.getMail());
			F.setNom(FournisseurDetails.getNom());
			F.setNumTel(FournisseurDetails.getNumTel());
			F.setPhoto(FournisseurDetails.getPhoto());
			F.setPrenom(FournisseurDetails.getPrenom());
		
			Fournisseur updatedFournisseur = FourRepo.save(F);
			return ResponseEntity.ok(updatedFournisseur);
			
		}
		
		//Delete Fournisseur 
		@DeleteMapping("/FOUR/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteFournisseur (@PathVariable int id){
			Fournisseur F = FourRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("Fournisseur not exist with id " +id));
			
			FourRepo.delete(F);
			//on utilse le map ici pour retourner un mesge de type boolean apres la suppression de notre en tite et qui va retourner deleted successfully
			Map<String, Boolean> response = new HashMap<>();
			
			response.put("Your entity is deleted :)", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

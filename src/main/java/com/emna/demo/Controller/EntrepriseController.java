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
import com.emna.demo.Repository.EntrepriseRepository;
import com.emna.demo.model.Entreprise;

@RestController
@RequestMapping("/api/v1/")
public class EntrepriseController {
	@Autowired
	private EntrepriseRepository entrepriseRepo;

	//get all entreprises
		@GetMapping("/entreprises")
		public List<Entreprise> gelAllEntreprises(){
			return entrepriseRepo.findAll();

		}
		
		//create entreprise
		@PostMapping("/entreprise")
		public Entreprise createEntreprise(@RequestBody Entreprise e) {
			return entrepriseRepo.save(e);
		}
		
		
		//get entreprise by id
		@GetMapping("/entreprise/{id}")
		public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable int id) {
			Entreprise e = entrepriseRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("entrepise not found with id " +id));
		
			return ResponseEntity.ok(e);
		}


		//UPDATE entreprise
		@PutMapping("/entreprises/{id}")
		public ResponseEntity<Entreprise> updateArticle(@PathVariable int id, @RequestBody Entreprise EntrepriseDetails){
			Entreprise e = entrepriseRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("entreprise not exist with id " +id));
			
			e.setA(EntrepriseDetails.getA());
			e.setCodeFiscal(EntrepriseDetails.getCodeFiscal());
			e.setDescription(EntrepriseDetails.getDescription());
			e.setMail(EntrepriseDetails.getMail());
			e.setNom(EntrepriseDetails.getNom());
			e.setNumTel(EntrepriseDetails.getNumTel());
			
			Entreprise updateEntreprise = entrepriseRepo.save(e);
			return ResponseEntity.ok(updateEntreprise);
			
		}
		
		
		//Delete Entreprise
		@DeleteMapping("/entreprise/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteEntreprise (@PathVariable int id){
			Entreprise e = entrepriseRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("Entreprise not exist with id " +id));
			
			entrepriseRepo.delete(e);
			//on utilse le map ici pour retourner un mesge de type boolean apres la suppression de notre en tite et qui va retourner deleted successfully
			Map<String, Boolean> response = new HashMap<>();
			
			response.put("Your entity is deleted :)", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}








































}

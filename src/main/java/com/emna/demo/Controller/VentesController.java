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
import com.emna.demo.Repository.VentesRepository;
import com.emna.demo.model.Ventes;

@RestController
@RequestMapping("/api/v1/")
public class VentesController {
	@Autowired
	private VentesRepository venteRepo;
	
	//get all ventes
		@GetMapping("/ventes")
		public List<Ventes> gelAllVentes(){
			return venteRepo.findAll();
		}
		
		//create Ventes
		@PostMapping("/Ventes")
		public Ventes createVentes(@RequestBody Ventes v) {
			return venteRepo.save(v);
		}
		
		//get article by id
		@GetMapping("/Ventes/{id}")
		public ResponseEntity<Ventes> getVentesById(@PathVariable int id) {
			Ventes v = venteRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("Ventes not exist with id " +id));
		
			return ResponseEntity.ok(v);
		}
		
		
		//UPDATE article 
		@PutMapping("/Ventes/{id}")
		public ResponseEntity<Ventes> updateVentes(@PathVariable int id, @RequestBody Ventes VentesDetails){
			Ventes v = venteRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("Ventes not exist with id " +id));
			
			v.setCode(VentesDetails.getCode());
			v.setCommentaire(VentesDetails.getCommentaire());
			v.setDateVente(VentesDetails.getDateVente());
	
			
			Ventes updatedVentes = venteRepo.save(v);
			return ResponseEntity.ok(updatedVentes);
			
		}
		
		//Delete Article 
		@DeleteMapping("/Ventes/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteVentes (@PathVariable int id){
			Ventes v = venteRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("Ventes not exist with id " +id));
			
			venteRepo.delete(v);
			//on utilse le map ici pour retourner un mesge de type boolean apres la suppression de notre en tite et qui va retourner deleted successfully
			Map<String, Boolean> response = new HashMap<>();
			
			response.put("Your entity is deleted :)", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

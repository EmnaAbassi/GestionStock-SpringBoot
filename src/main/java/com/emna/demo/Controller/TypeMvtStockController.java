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
import com.emna.demo.Repository.TypeMvtStockRepository;
import com.emna.demo.model.TypeMvtStock;

@RestController
@RequestMapping("/api/v1/")
public class TypeMvtStockController {
	@Autowired
	private TypeMvtStockRepository typeRepo;
	
	//get all typesMvt
		@GetMapping("/typesMvt")
		public List<TypeMvtStock> gelAlltypesMvt(){
			return typeRepo.findAll();
		}
		
		//create typesMvt
		@PostMapping("/typesMvt")
		public TypeMvtStock createtypesMvt(@RequestBody TypeMvtStock type) {
			return typeRepo.save(type);
		}
		
		//get typesMvt by id
		@GetMapping("/typesMvt/{id}")
		public ResponseEntity<TypeMvtStock> gettypesMvtById(@PathVariable int id) {
			TypeMvtStock type = typeRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("typesMvt not exist with id " +id));
		
			return ResponseEntity.ok(type);
		}
		
		
		//UPDATE typesMvt 
		@PutMapping("/typesMvt/{id}")
		public ResponseEntity<TypeMvtStock> updatetypesMvt(@PathVariable int id, @RequestBody TypeMvtStock TypeMvtStockDetails){
			TypeMvtStock type = typeRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("typesMvt not exist with id " +id));
			
			type.setMvtStock(TypeMvtStockDetails.getMvtStock());
			type.setNom(TypeMvtStockDetails.getNom());
			
			TypeMvtStock updatedTypeMvtStock = typeRepo.save(type);
			return ResponseEntity.ok(updatedTypeMvtStock);
			
		}
		
		//Delete typesMvt
		@DeleteMapping("/typesMvt/{id}")
		public ResponseEntity<Map<String, Boolean>> deletetypesMvt(@PathVariable int id){
			TypeMvtStock type = typeRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("article not exist with id " +id));
			
			typeRepo.delete(type);
			//on utilse le map ici pour retourner un mesge de type boolean apres la suppression de notre en tite et qui va retourner deleted successfully
			Map<String, Boolean> response = new HashMap<>();
			
			response.put("Your entity is deleted :)", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	
	
	
	
	
	
	
	
	
	
	
	
}

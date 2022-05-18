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
import com.emna.demo.Repository.CommandeFournisseurRepository;
import com.emna.demo.model.CommandeFournisseur;

@RestController
@RequestMapping("/api/v1/")
public class CommandeFournisseurController {
	@Autowired
	private CommandeFournisseurRepository CFRepo;
	
	//get all CF
		@GetMapping("/CF")
		public List<CommandeFournisseur> gelAllCF(){
			return CFRepo.findAll();
		}
		
		//create CommandeFournisseur
		@PostMapping("/CF")
		public CommandeFournisseur createCommandeFournisseur(@RequestBody CommandeFournisseur CF) {
			return CFRepo.save(CF);
		}
		
		//get CommandeFournisseur by id
		@GetMapping("/CF/{id}")
		public ResponseEntity<CommandeFournisseur> getCommandeFournisseurById(@PathVariable int id) {
			CommandeFournisseur CF = CFRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("CommandeFournisseur not exist with id " +id));
		
			return ResponseEntity.ok(CF);
		}
		
		
		//UPDATE CommandeFournisseur 
		@PutMapping("/CF/{id}")
		public ResponseEntity<CommandeFournisseur> updateCommandeFournisseur(@PathVariable int id, @RequestBody CommandeFournisseur CFDetails){
			CommandeFournisseur CF = CFRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("CommandeFournisseur not exist with id " +id));
			
			CF.setCode(CFDetails.getCode());
			CF.setDateDeCommande(CFDetails.getDateDeCommande());
			CF.setFournisseur(CFDetails.getFournisseur());
		
			
			
			CommandeFournisseur updatedCF = CFRepo.save(CF);
			return ResponseEntity.ok(updatedCF);
			
		}
		
		//Delete CommandeFournisseur
		@DeleteMapping("/CF/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteCommandeFournisseur (@PathVariable int id){
			CommandeFournisseur CF = CFRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("CommandeFournisseur not exist with id " +id));
			
			CFRepo.delete(CF);
			//on utilse le map ici pour retourner un mesge de type boolean apres la suppression de notre en tite et qui va retourner deleted successfully
			Map<String, Boolean> response = new HashMap<>();
			
			response.put("Your entity is deleted :)", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
	
	
	
}

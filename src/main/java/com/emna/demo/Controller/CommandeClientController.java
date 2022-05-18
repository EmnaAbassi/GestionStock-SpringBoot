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
import com.emna.demo.Repository.CommandeClientRepository;
import com.emna.demo.model.Article;
import com.emna.demo.model.CommandeClient;

@RestController
@RequestMapping("/api/v1/")
public class CommandeClientController {
	@Autowired
	private CommandeClientRepository CCRepo;
	
	//get all CommandeClient
		@GetMapping("/CC")
		public List<CommandeClient> gelAllCommandeClient(){
			return CCRepo.findAll();
		}
		
		//create CommandeClient
		@PostMapping("/CC")
		public CommandeClient createCommandeClient(@RequestBody CommandeClient CC) {
			return CCRepo.save(CC);
		}
		
		//get CommandeClient by id
		@GetMapping("/CC/{id}")
		public ResponseEntity<CommandeClient> getCommandeClientById(@PathVariable int id) {
			CommandeClient CC= CCRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("CommandeClient not exist with id " +id));
		
			return ResponseEntity.ok(CC);
		}
		
		
		//UPDATE CommandeClient 
		@PutMapping("/CC/{id}")
		public ResponseEntity<CommandeClient> updateCommandeClient(@PathVariable int id, @RequestBody CommandeClient CCDetails){
			CommandeClient CC = CCRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("cc not exist with id " +id));
			
			
			CC.setClient(CCDetails.getClient());
			CC.setCode(CCDetails.getCode());
			CC.setDateDeCommande(CCDetails.getDateDeCommande());
			
			CommandeClient updatedCC = CCRepo.save(CC);
			return ResponseEntity.ok(updatedCC);
			
		}
		
		//Delete Article 
		@DeleteMapping("/CC/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteCommandeClient (@PathVariable int id){
			CommandeClient CC = CCRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("CommandeClient not exist with id " +id));
			
			CCRepo.delete(CC);
			//on utilse le map ici pour retourner un mesge de type boolean apres la suppression de notre en tite et qui va retourner deleted successfully
			Map<String, Boolean> response = new HashMap<>();
			
			response.put("Your entity is deleted :)", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
}

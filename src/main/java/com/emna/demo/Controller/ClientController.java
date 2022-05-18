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
import com.emna.demo.Repository.ClientRepo;
import com.emna.demo.model.Client;

@RestController
@RequestMapping("/api/v1/")
public class ClientController {
	@Autowired
	private ClientRepo clientRepo;
	
	//get all Client
		@GetMapping("/client")
		public List<Client> gelAllClient(){
			return clientRepo.findAll();
		}
		
		//create Client
		@PostMapping("/client")
		public Client createClient(@RequestBody Client c) {
			return clientRepo.save(c);
		}
		
		//get Client by id
		@GetMapping("/client/{id}")
		public ResponseEntity<Client> getClientById(@PathVariable int id) {
			Client c = clientRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("Client not exist with id " +id));
		
			return ResponseEntity.ok(c);
		}
		
		
		//UPDATE Client 
		@PutMapping("/client/{id}")
		public ResponseEntity<Client> updateClient(@PathVariable int id, @RequestBody Client ClientDetails){
			Client c = clientRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("Client not exist with id " +id));
			
			c.setAdresse1(ClientDetails.getAdresse1());
			c.setAdresse2(ClientDetails.getAdresse2());
			c.setCodePostale(ClientDetails.getCodePostale());
			c.setVille(ClientDetails.getVille());
			c.setCommandeClients(ClientDetails.getCommandeClients());
			c.setLignecommandeclient(ClientDetails.getLignecommandeclient());
			c.setMail(ClientDetails.getMail());
			c.setNom(ClientDetails.getNom());
			c.setNumTel(ClientDetails.getNumTel());
			c.setPhoto(ClientDetails.getPhoto());
			c.setPrenom(ClientDetails.getPrenom());
			
			Client updatedClient = clientRepo.save(c);
			return ResponseEntity.ok(updatedClient);
			
		}
		
		//Delete Client 
		@DeleteMapping("/client/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteClient (@PathVariable int id){
			Client c = clientRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("Client not exist with id " +id));
			
			clientRepo.delete(c);
			//on utilse le map ici pour retourner un mesge de type boolean apres la suppression de notre en tite et qui va retourner deleted successfully
			Map<String, Boolean> response = new HashMap<>();
			
			response.put("Your entity is deleted :)", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	
}

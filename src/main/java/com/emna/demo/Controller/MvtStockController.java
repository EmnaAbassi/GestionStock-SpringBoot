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
import com.emna.demo.Repository.MvtStockRepository;
import com.emna.demo.model.MvtStock;

@RestController
@RequestMapping("/api/v1/")
public class MvtStockController {
	@Autowired
	private MvtStockRepository mvRepo;
	//get all articles
		@GetMapping("/MV")
		public List<MvtStock> gelAllMvtStock(){
			return mvRepo.findAll();
		}
		
		//create MvtStock
		@PostMapping("/MV")
		public MvtStock createMvtStock(@RequestBody MvtStock mv) {
			return mvRepo.save(mv);
		}
		
		//get MvtStock by id
		@GetMapping("/MV/{id}")
		public ResponseEntity<MvtStock> getMvtStockById(@PathVariable int id) {
			MvtStock mv = mvRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("mv not exist with id " +id));
		
			return ResponseEntity.ok(mv);
		}
		
		
		//UPDATE MvtStock 
		@PutMapping("/MV/{id}")
		public ResponseEntity<MvtStock> updateMvtStock(@PathVariable int id, @RequestBody MvtStock MvtStockDetails){
			MvtStock mv = mvRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("mv not exist with id " +id));
			
			mv.setArticle(MvtStockDetails.getArticle());
			mv.setDateMvt(MvtStockDetails.getDateMvt());
			mv.setQuantite(MvtStockDetails.getQuantite());
			mv.setTypeMvt(MvtStockDetails.getTypeMvt());
			
			MvtStock updatedMvtStock = mvRepo.save(mv);
			return ResponseEntity.ok(updatedMvtStock);
			
		}
		
		//Delete MvtStock 
		@DeleteMapping("/MV/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteMvtStock (@PathVariable int id){
			MvtStock mv = mvRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("article not exist with id " +id));
			
			mvRepo.delete(mv);
			//on utilse le map ici pour retourner un mesge de type boolean apres la suppression de notre en tite et qui va retourner deleted successfully
			Map<String, Boolean> response = new HashMap<>();
			
			response.put("Your entity is deleted :)", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
		
}

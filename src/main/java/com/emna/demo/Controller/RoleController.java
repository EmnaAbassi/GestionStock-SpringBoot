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
import com.emna.demo.Repository.RoleRepository;
import com.emna.demo.model.Role;

@RestController
@RequestMapping("/api/v1/")
public class RoleController {
	@Autowired
	private RoleRepository roleRepo;
	
	//get all roles
		@GetMapping("/roles")
		public List<Role> gelAllRoles(){
			return roleRepo.findAll();
		}
	
		//create role
		@PostMapping("/roles")
		public Role createRole(@RequestBody Role r) {
			return roleRepo.save(r);
		}
	
		//get role by id
		@GetMapping("/roles/{id}")
		public ResponseEntity<Role> getRoleById(@PathVariable int id) {
			Role r = roleRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("role not exist with id " +id));
		
			return ResponseEntity.ok(r);
		}
	
		//UPDATE role 
		@PutMapping("/roles/{id}")
		public ResponseEntity<Role> updateRole(@PathVariable int id, @RequestBody Role RoleDetails){
			Role r = roleRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("Role not exist with id " +id));
			
			r.setRoleName(RoleDetails.getRoleName());
			/*r.setUser(RoleDetails.getUser());*/
			
			Role roleUpdated = roleRepo.save(r);
			return ResponseEntity.ok(roleUpdated);
			
		}
		
		//Delete Role
		@DeleteMapping("/Roles/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteRole (@PathVariable int id){
			Role r = roleRepo.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("role not exist with id " +id));
			
			roleRepo.delete(r);
			//on utilse le map ici pour retourner un mesge de type boolean apres la suppression de notre en tite et qui va retourner deleted successfully
			Map<String, Boolean> response = new HashMap<>();
			
			response.put("Your entity is deleted :)", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

	
	
	
	
	
}

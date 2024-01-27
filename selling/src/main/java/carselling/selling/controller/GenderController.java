package carselling.selling.controller;


import carselling.selling.repository.GenderRepository;
import carselling.selling.response.ApiResponse;
import carselling.selling.entity.Gender;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "gender")
public class GenderController
 {

	@Autowired
	private GenderRepository repository;


	@PostMapping()
	public ResponseEntity<?> save(@RequestBody Gender gender){
		ApiResponse response = new ApiResponse();
		try{
			repository.delete(gender);
			response.addData("data", "Inserted successfully");
			return ResponseEntity.ok(response);
		}catch(Exception e){
			response.addError("error", e.getCause().getMessage());
			return ResponseEntity.ok(response);
		}	
	}
	@PutMapping()
	public ResponseEntity<?> update(@RequestBody Gender gender){
		ApiResponse response = new ApiResponse();
		try{
			repository.delete(gender);
			response.addData("data", "Updated successfully");
			return ResponseEntity.ok(response);
		}catch(Exception e){
			response.addError("error", e.getCause().getMessage());
			return ResponseEntity.ok(response);
		}		}
	@DeleteMapping()
	public ResponseEntity<?> delete(@RequestBody Gender gender){
		ApiResponse response = new ApiResponse();
		try{
			repository.delete(gender);
			response.addData("data", "Deleted successfully");
			return ResponseEntity.ok(response);
		}catch(Exception e){
			response.addError("error", e.getCause().getMessage());
			return ResponseEntity.ok(response);
		}		}
	@GetMapping()
	public ResponseEntity<?> findAll(){
		ApiResponse response = new ApiResponse();
		try{
			response.addData("data", repository.findAll());
			return ResponseEntity.ok(response);
		}catch(Exception e){
			response.addError("error", e.getCause().getMessage());
			return ResponseEntity.ok(response);
		}
	}	




}

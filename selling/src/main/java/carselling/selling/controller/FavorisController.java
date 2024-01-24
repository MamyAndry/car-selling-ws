package carselling.selling.controller;


import carselling.selling.repository.FavorisRepository;
import carselling.selling.response.ApiResponse;
import carselling.selling.entity.Favoris;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "favoris")
public class FavorisController
 {

	@Autowired
	private FavorisRepository repository;


	@PostMapping()
	public ResponseEntity<?> save(@RequestBody Favoris favoris){
		ApiResponse response = new ApiResponse();
		try{
			repository.save(favoris);
			response.addData("data", "Inserted successfully");
			return ResponseEntity.ok(response);
		}catch(Exception e){
			response.addError("error", e.getCause().getMessage());
			return ResponseEntity.ok(response);
		}
	}
	@PutMapping()
	public ResponseEntity<?> update(@RequestBody Favoris favoris){
		ApiResponse response = new ApiResponse();
		try{
			repository.save(favoris);
			response.addData("data", "Updated successfully");
			return ResponseEntity.ok(response);
		}catch(Exception e){
			response.addError("error", e.getCause().getMessage());
			return ResponseEntity.ok(response);
		}
	}
	@DeleteMapping()
	public ResponseEntity<?> delete(@RequestBody Favoris favoris){
		ApiResponse response = new ApiResponse();
		try{
			repository.delete(favoris);
			response.addData("data", "Deleted successfully");
			return ResponseEntity.ok(response);
		}catch(Exception e){
			response.addError("error", e.getCause().getMessage());
			return ResponseEntity.ok(response);
		}
	}
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

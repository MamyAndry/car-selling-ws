package carselling.selling.controller;


import carselling.selling.repository.FuelTypeRepository;
import carselling.selling.response.ApiResponse;
import carselling.selling.entity.FuelType;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "fuelType")
public class FuelTypeController
 {

	@Autowired
	private FuelTypeRepository repository;


	@PostMapping()
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> save(@RequestBody FuelType fuelType){
		ApiResponse response = new ApiResponse();
		try{
			response.addData("data", repository.save(fuelType));
			return ResponseEntity.ok(response);
		}catch(Exception e){
			response.addError("error", e.getCause().getMessage());
			return ResponseEntity.ok(response);
		}
	}

	@PutMapping()
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> update(@RequestBody FuelType fuelType){
		ApiResponse response = new ApiResponse();
		try{
			response.addData("data", repository.save(fuelType));
			return ResponseEntity.ok(response);
		}catch(Exception e){
			response.addError("error", e.getCause().getMessage());
			return ResponseEntity.ok(response);
		}
	}
	@DeleteMapping()
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(@RequestBody FuelType fuelType){
		ApiResponse response = new ApiResponse();
		try{
			repository.delete(fuelType);
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
		}	}


	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable String id){
		ApiResponse response = new ApiResponse();
		try{
			response.addData("data", repository.findById(id));
			return ResponseEntity.ok(response);
		}catch(Exception e){
			response.addError("error", e.getCause().getMessage());
			return ResponseEntity.ok(response);
		}
	}

	@GetMapping("{debut}/{fin}")
	public ResponseEntity<?>  pagination(@PathVariable int debut, @PathVariable int fin) {
		ApiResponse response = new ApiResponse();
		try{
			response.addData("data", repository.paginer(debut, fin));
			return ResponseEntity.ok(response);
		}catch(Exception e){
			response.addError("error", e.getCause().getMessage());
			return ResponseEntity.ok(response);
		}
	}

}

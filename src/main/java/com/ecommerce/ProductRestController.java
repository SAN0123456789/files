package com.ecommerce;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductRestController {
	
	@Autowired
	EProductRepositry eProductRepo;
	
	// List all the products
	@GetMapping(path="/list", produces = "application/json")
	public List<EProduct> listProducts(){
		List<EProduct> products = eProductRepo.findAll();
		
		return products;		
	}
	
	// Adding a new product
	@PostMapping(path="/add", consumes="application/json" , produces = "application/json")
	public EProduct addProduct(@RequestBody EProduct eProduct){
		eProduct = eProductRepo.save(eProduct);
		return eProduct;
	}
	
	// Finding a single product and fetching its details
	@GetMapping(path="/list/{id}", produces = "application/json")
	public Object showProduct(@PathVariable("id") int id){
		
		Optional<EProduct> productFromRepo = eProductRepo.findById(id);
		
		if (productFromRepo.isPresent()) {
			EProduct product = productFromRepo.get();
			return product;
		}else {
			return "Aadhar with id = "+ id + " not found";
		}
	}
	
	@GetMapping(path="/update/{id}", produces = "application/json")
	public Object updateproduct(@PathVariable("id") int id,@RequestBody EProduct eProduct){
		
		Optional<EProduct> productFromRepo = eProductRepo.findById(id);
		if (productFromRepo.isPresent()) {
				eProductRepo.update(eProduct);
				List<EProduct> products = eProductRepo.findAll();
				return products;		

		}else {
			return "Aadhar with id = "+ id + " not found, cannot update";
		}
	}
	//Delete a Product
	@GetMapping(path="/delete/{id}", produces = "application/json")
	public Object deleteProduct(@PathVariable("id") int id){
		
		Optional<EProduct> productFromRepo = eProductRepo.findById(id);
		
		if (productFromRepo.isPresent()) {
			eProductRepo.deleteById(id);
			return "Product with id = "+ id + " found and deleted";
		}else {
			return "Product with id = "+ id + " not found";
		}
	}
	
	

}

package com.bae.tracker.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.tracker.data.Plant;
import com.bae.tracker.service.PlantService;

@RestController
public class PlantController {
	private PlantService service;

	public PlantController(PlantService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getPlants")
	public List<Plant> getPlants() {
		return this.service.getPlants();
	}

	@PostMapping("/createPlant")
	public ResponseEntity<Plant> createPlant(@RequestBody Plant plant) {
		Plant created = this.service.createPlant(plant);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

}

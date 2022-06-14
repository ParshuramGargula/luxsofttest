package com.test.nomenclatureofeconomicactivities.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.nomenclatureofeconomicactivities.model.NACEData;
import com.test.nomenclatureofeconomicactivities.service.NACEService;

import io.swagger.annotations.ApiOperation;

@RestController
public class Controller {
	@Autowired
	NACEService naceService;

	@PostMapping(path = "/putNaceDetails")
	@ApiOperation(value = "This operation writes NACE data to database", produces = "application/json")
	public ResponseEntity<List<NACEData>> putNaceDetails() throws FileNotFoundException, IOException {
		return new ResponseEntity<>(naceService.persistNaceData(), HttpStatus.CREATED);
	}

	@GetMapping(path = "/getNaceDetails/{order}")
	@ApiOperation(value = "This operation retrieves NACE data with order as path parameter", produces = "application/json")
	public NACEData getNaceDetails(@PathVariable(name = "order") Long order) throws Exception {
		return naceService.retrieveNaceData(order);
	}
}

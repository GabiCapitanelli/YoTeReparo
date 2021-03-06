package com.yotereparo.controller;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yotereparo.model.City;
import com.yotereparo.service.CityService;
import com.yotereparo.util.MiscUtils;
/**
 * Controlador REST SpringMVC que expone servicios básicos para la gestión de Ciudades.
 * 
 * @author Rodrigo Yanis
 * 
 */
@RestController
public class CityController {
	
	private static final Logger logger = LogManager.getLogger(CityController.class);
	
	@Autowired
    CityService cityService;
	@Autowired
    MessageSource messageSource;

	/*
	 * Devuelve todas las ciudades registradas en formato JSON.
	 */
	@RequestMapping(
			value = { "/cities/" }, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	public ResponseEntity<List<City>> listCities() {
		logger.info("ListCities - GET - Processing request for a list with all existing cities.");
        
		List<City> cities = cityService.getAllCities();
        
		if (!cities.isEmpty()) {
        	logger.info("ListCities - GET - Exiting method, providing response resource to client.");
            return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
        }
        else {
        	logger.info("ListCities - GET - Request failed - No cities were found.");
        	return new ResponseEntity<List<City>>(HttpStatus.NO_CONTENT);
        }
    }
	
	/*
	 * Devuelve la ciudad solicitada en formato JSON.
	 */
	@RequestMapping(
			value = { "/cities/{id}" }, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	public ResponseEntity<?> getCity(@PathVariable("id") String id) {
		id = id.toLowerCase();
		logger.info(String.format("GetCity - GET - Processing request for city <%s>.", id));
        
		City city = cityService.getCityById(id);
        
		if (city != null) {
        	logger.info("GetCity - GET - Exiting method, providing response resource to client.");
            return new ResponseEntity<City>(city, HttpStatus.OK);
        }
        else {
        	logger.info(String.format("GetCity - GET - Request failed - City with id <%s> not found.", id));
            FieldError error = new FieldError("City","error",messageSource.getMessage("city.doesnt.exist", new String[]{id}, Locale.getDefault()));
            return new ResponseEntity<>(MiscUtils.getFormatedResponseError(error).toString(), HttpStatus.NOT_FOUND);
        } 
    }
}

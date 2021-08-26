package com.example.pizza_order_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pizza_order_service.model.Addon;
import com.example.pizza_order_service.service.AddonService;

@RestController
@RequestMapping("/REST/Addon/")
public class AddonRestController {

	@Autowired
	private AddonService addonService;
	
	@GetMapping(value = "{id}", produces = "application/json")
	public Addon getAddon(@PathVariable long id) {
		return addonService.find(id);
	}
	
	@PostMapping(value = "")
	public void saveAddon(Addon addon) {
		addonService.save(addon);
	}
	
	@GetMapping(value = "", produces = "application/json")
	public List<Addon> getAddons(){
		return addonService.findAll();
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteAddon(@PathVariable long id) {
		addonService.delete(id);
	}
}

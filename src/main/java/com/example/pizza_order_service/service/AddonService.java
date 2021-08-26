package com.example.pizza_order_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizza_order_service.model.Addon;
import com.example.pizza_order_service.repository.AddonRepository;

@Service
public class AddonService {

	@Autowired
	AddonRepository addonRepo;

	public Addon find(long id) {
		Optional<Addon> addon = addonRepo.findById(id);
		Addon toReturn = addon.isPresent() ? addon.get() : null;
		return toReturn;
	}

	public void save(Addon addon) {
		addonRepo.save(addon);
		
	}

	public List<Addon> findAll() {
		return (List<Addon>) addonRepo.findAll();
	}

	public void delete(long id) {
		addonRepo.deleteById(id);
		
	}
}

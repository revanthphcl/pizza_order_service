package com.example.pizza_order_service.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.pizza_order_service.model.Addon;
import com.example.pizza_order_service.repository.AddonRepository;

public class AddonService {
	
	@Autowired
	AddonRepository AddonRepo;
	
	public void createAddon(Addon addon) {
		AddonRepo.save(addon);
	}
	
	public void updateAddon(Addon addon) {
		Addon updateAddon = this.find(addon.getAddonId());
		if (!Objects.isNull(updateAddon)){
			AddonRepo.save(addon);
		}
	}
	
	public void deleteAddon(Addon addon) {
		AddonRepo.delete(addon);
	}
	
	public void deleteAddon(Long id) {
		Addon Addon = this.find(id);
		AddonRepo.delete(Addon);
	}

	public Addon save(Addon addon) {
		return AddonRepo.save(addon);
	}
	
	public List<Addon> findAll() {
		return (List<Addon>) AddonRepo.findAll();
	}
	
	public Addon find(Long id) {
		Optional<Addon> Addon = AddonRepo.findById(id);
		Addon toReturn = Addon.isPresent() ? Addon.get() : null;
		return toReturn;
	}
	
	
}

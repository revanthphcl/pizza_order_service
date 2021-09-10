package com.example.pizza_order_service.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.pizza_order_service.controllers.rest.AddonRestController;
import com.example.pizza_order_service.model.Addon;
import com.example.pizza_order_service.service.AddonService;

@RunWith(SpringJUnit4ClassRunner.class)
public class AddonRestControllerTest {

	private AutoCloseable closeable;

	@Mock
	private AddonService addonService;
	
	@Mock
	private Addon addOn;
	
	@InjectMocks
	private AddonRestController addonRestController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		addOn = new Addon();
		addOn.setAddonId(1L);
		addOn.setName("Pepperoni");
		addOn.setDescription("slices of pepperoni");
		addOn.setPrice(1.0);
		
		closeable = MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(addonRestController).build();
	}
	
	@After
	public void tearDown() throws Exception {
		closeable.close();
	}
	
	@Test
	public void testGetAddonExpectsJSON() throws Exception {
		ResultActions result = mockMvc.perform(get("/REST/Addon/{id}", 1L)
					.contentType(MediaType.APPLICATION_JSON));
		result
			.andExpect(status().isOk())
			.andExpect(content()
					.contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void testGetAddonsExpectsJSON() throws Exception {
		ResultActions result = mockMvc.perform(get("/REST/Addon/"));
		result
			.andExpect(status().isOk())
			.andExpect(content()
				.contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void testSaveAddonExpectsOk() throws Exception {
		ResultActions result = mockMvc.perform(post("/REST/Addon/")
								.content("{ \"name\": \"Pizza\" }")
								.contentType(MediaType.APPLICATION_JSON));
		result
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void testSaveAddonExpectsAddonServiceSaveCalled() throws Exception {
		addonRestController.saveAddon(addOn);
		
		verify(addonService, times(1)).save(addOn);
	}
	
	@Test
	public void testDeleteAddonExpectsOk() throws Exception {
		ResultActions result = mockMvc.perform(delete("/REST/Addon/{id}", 1L));
	}
	
	@Test
	public void testDeleteAddonExpectsAddonServiceDeleteCalled() throws Exception {
		addonRestController.deleteAddon(1L);
		
		verify(addonService, times(1)).deleteAddon(1L);
	}
}
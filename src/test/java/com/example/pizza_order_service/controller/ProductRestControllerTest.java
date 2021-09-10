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

import com.example.pizza_order_service.controllers.rest.ProductRestController;
import com.example.pizza_order_service.model.Product;
import com.example.pizza_order_service.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductRestControllerTest{
	
	private AutoCloseable closeable;
	
	@Mock
	private ProductService prodService;
	
	@Mock
	private Product product;
	
	@InjectMocks
	private ProductRestController productRestController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		product = new Product();
		product.setName("Pizza");
		product.setDescription("hot and cheesy");
		product.setPrice(1.0);
		product.setProductId(1L);
		
		closeable = MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(productRestController).build();
	}
	
	@After
	public void tearDown() throws Exception {
		closeable.close();
	}
	
	@Test
	public void testGetProductsExpectsJSON() throws Exception {
		ResultActions result = mockMvc.perform(get("/REST/Product/"));
			result
				.andExpect(status().isOk())
				.andExpect(content()
						.contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void testGetProductExpectsJSON() throws Exception {
		ResultActions result = mockMvc.perform(get("/REST/Product/1")
				.queryParam("id", "1")
				.contentType(MediaType.APPLICATION_JSON));
		result 
				.andExpect(status().isOk())
				.andExpect(content()
							.contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void testsaveProductExpectsOk() throws Exception {
		ResultActions result = mockMvc.perform(post("/REST/Product/")
								.content("{ \"name\": \"Pizza\" }")
								.contentType(MediaType.APPLICATION_JSON));
		result
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void testSaveProductExpectsProductServiceSaveCalled() throws Exception {
		productRestController.saveProduct(product);
		
		verify(prodService, times(1)).save(product);
	}
	
	@Test
	public void testDeleteProductExpectsOk() throws Exception {
		ResultActions result = mockMvc.perform(delete("/REST/Product/1"));
		
		result
			.andExpect(status().isOk());
	}
	
	@Test
	public void testDeleteProductExpectsProductServiceDeleteProductCalled() throws Exception {
		productRestController.deleteProduct(1L);
		
		verify(prodService, times(1)).deleteProduct(1L);
	}
}
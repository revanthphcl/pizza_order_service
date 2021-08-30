package com.example.pizza_order_service.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.pizza_order_service.controllers.ProductController;
import com.example.pizza_order_service.model.Product;
import com.example.pizza_order_service.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductControllerTest {

private AutoCloseable closeable;
	
	@Mock
	private ProductService prodService;
	
	@Mock
	private Product product;
	
	@InjectMocks
	private ProductController productController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		closeable = MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
		
		product = new Product();
		product.setName("Pizza");
		product.setDescription("This is a pizza");
		product.setPrice(3.99);
	}
	
	@After
	public void tearDown() throws Exception {
		closeable.close();
	}
	
	@Test
	public void testGetProductExpectsCreateProductPage() throws Exception {
		mockMvc.perform(get("/Product/"))
		.andExpect(status().isOk())
		.andExpect(view().name("createProduct"));
	}
	
	@Test
	public void testPostProductExpectsCreatePage() throws Exception {
		mockMvc.perform(post("/Product/"))
		.andExpect(status().isOk())
		.andExpect(view().name("create"));
	}
	
	@Test
	public void testGetListProductsExpectsReadPage() throws Exception {
		mockMvc.perform(get("/Product"))
		.andExpect(status().isOk())
		.andExpect(view().name("read"));
	}
	
	@Test
	public void testGetUpdateProductExpectsUpdateProductsPage() throws Exception {
		mockMvc.perform(get("/Product/update"))
		.andExpect(status().isOk())
		.andExpect(view().name("UpdateProducts"));
	}
	
	@Test
	public void testPutSaveUpdatedProductExpectsupdateProducts2Page() throws Exception {
		mockMvc.perform(put("/Product/{id}", 1L))
		.andExpect(status().isOk())
		.andExpect(view().name("updateProducts2"));
	}
	
	@Test
	public void testSaveExpectsProductServiceSaveCalled() throws Exception {
		productController.postProduct(product);
		
		verify(prodService, times(1)).save(product);
	}
	
	@Test
	public void testDeleteProductExpectsReadPage() throws Exception {
		mockMvc.perform(delete("/Product/{id}", 1L))
		.andExpect(status().isOk())
		.andExpect(view().name("read"));
	}
	
	@Test
	public void testDeleteProductExpectsProductServiceDeleteProductCalled() throws Exception {
		productController.deleteProduct(1L);
		
		verify(prodService, times(1)).deleteProduct(1L);
	}
}

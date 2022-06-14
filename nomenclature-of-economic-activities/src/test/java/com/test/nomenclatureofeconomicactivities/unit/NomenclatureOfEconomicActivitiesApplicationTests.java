package com.test.nomenclatureofeconomicactivities.unit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.test.nomenclatureofeconomicactivities.NomenclatureOfEconomicActivitiesApplication;
import com.test.nomenclatureofeconomicactivities.model.NACEData;

@AutoConfigureMockMvc
@SpringBootTest(classes = NomenclatureOfEconomicActivitiesApplication.class)
@TestPropertySource(locations = { "classpath:application-test.properties" })
class NomenclatureOfEconomicActivitiesApplicationTests {
	static NACEData data;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void putNaceDetailsTest() throws Exception {
		mockMvc.perform(post("/putNaceDetails")).andExpect(status().isCreated());
	}

	@Test
	public void getNaceDetailsTest() throws Exception {
		mockMvc.perform(get("/getNaceDetails/{order}", 398482L)).andExpect(status().isOk());
	}

}

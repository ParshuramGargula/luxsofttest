package com.test.nomenclatureofeconomicactivities.unit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.nomenclatureofeconomicactivities.model.NACEData;
import com.test.nomenclatureofeconomicactivities.repository.NACEDataRepository;
import com.test.nomenclatureofeconomicactivities.service.NACEService;

@ExtendWith(MockitoExtension.class)
public class ServiceUnitTest {
	static NACEData data;
	@Mock
	NACEDataRepository mockdataRepository;
	@InjectMocks
	static NACEService naceService;

	@BeforeAll
	public static void setUp() {
		naceService = new NACEService();
		data = new NACEData();
		data.setOrder(398481L);
		data.setLevel("1");
		data.setCode("A");
		data.setParent(null);
		data.setDescription("AGRICULTURE, FORESTRY AND FISHING");
		data.setThisItemIncludes(
				"This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats. ");
		data.setThisItemAlsoIncludes(null);
		data.setRulings(null);
		data.setThisItemExcludes(null);
		data.setReferenceToISICRev4(null);
	}

	@Test
	public void retrieveNACEDataTest() throws Exception {
		Mockito.when(mockdataRepository.findById(398481L)).thenReturn(Optional.ofNullable(data));
		NACEData naceData = naceService.retrieveNaceData(398481L);
		assertNotNull(naceData);
	}
}

package com.test.nomenclatureofeconomicactivities.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nomenclatureofeconomicactivities.helper.Helper;
import com.test.nomenclatureofeconomicactivities.model.NACEData;
import com.test.nomenclatureofeconomicactivities.repository.NACEDataRepository;

@Service
public class NACEService {
	@Autowired
	NACEDataRepository dataRepository;

	public List<NACEData> persistNaceData() throws FileNotFoundException, IOException {
		List<NACEData> naceDataList = new Helper().csvToNACEData();
		return dataRepository.saveAll(naceDataList);
	}

	public NACEData retrieveNaceData(Long order) throws Exception {
		Optional<NACEData> naceData = dataRepository.findById(order);
		return naceData.orElseThrow(() -> new Exception("Could not find requested details"));
	}

}
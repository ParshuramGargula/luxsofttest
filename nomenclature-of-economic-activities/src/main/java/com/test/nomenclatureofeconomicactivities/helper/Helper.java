package com.test.nomenclatureofeconomicactivities.helper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.test.nomenclatureofeconomicactivities.model.NACEData;

public class Helper {

	public List<NACEData> csvToNACEData() throws FileNotFoundException, IOException {
		Resource resource = new ClassPathResource("/nace.csv");
		List<NACEData> naceDataList = new ArrayList<>();
		try (CSVParser csvParser = new CSVParser(new FileReader(resource.getFile()),
				CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			csvParser.getRecords().forEach(record -> {
				NACEData naceData = new NACEData();
				naceData.setOrder(Long.valueOf(record.get("Order")));
				naceData.setLevel(record.get("Level"));
				naceData.setCode(record.get("Code"));
				naceData.setParent(record.get("Parent"));
				naceData.setDescription(record.get("Description"));
				naceData.setThisItemIncludes(record.get("This item includes"));
				naceData.setThisItemAlsoIncludes(record.get("This item also includes"));
				naceData.setRulings(record.get("Rulings"));
				naceData.setThisItemExcludes(record.get("This item excludes"));
				naceData.setReferenceToISICRev4(record.get("Reference to ISIC Rev. 4"));
				naceDataList.add(naceData);
			});
		}
		return naceDataList;

	}
}

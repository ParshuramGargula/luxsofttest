package com.test.nomenclatureofeconomicactivities.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class NACEData {
	// set column name as Order_ as order is keyword in Mysql
	@Id
	@Column(name = "Order_")
	private Long order;
	// set column name as Level_ as order is keyword in Mysql
	@Column(name = "Level_")
	private String level;
	@Column(name = "Code")
	private String code;
	@Column(name = "Parent")
	private String parent;
	// set column name as Description_ as order is keyword in Mysql
	@Column(name = "Description_")
	private String description;
	@Column(name = "This_item_includes", columnDefinition = "CLOB")
	private String thisItemIncludes;
	@Column(name = "This_item_also_includes", columnDefinition = "CLOB")
	private String thisItemAlsoIncludes;
	@Column(name = "Rulings")
	private String rulings;
	@Column(name = "This_item_excludes", columnDefinition = "CLOB")
	private String thisItemExcludes;
	@Column(name = "Reference_to_ISIC_Rev_4")
	private String referenceToISICRev4;

}

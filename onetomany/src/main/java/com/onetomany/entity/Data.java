package com.onetomany.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="data")
public class Data {
@Id
@Column(name = "data_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
Integer dataId;

@Column(name="dvalue")
private String dvalue;
public Data() {
	// TODO Auto-generated constructor stub
}
public Integer getDataId() {
	return dataId;
}
public void setDataId(Integer dataId) {
	this.dataId = dataId;
}
public String getDvalue() {
	return dvalue;
}
public void setDvalue(String dvalue) {
	this.dvalue = dvalue;
}
}

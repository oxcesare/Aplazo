package com.mx.aplazo.challenge.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import net.bytebuddy.implementation.auxiliary.AuxiliaryType.SignatureRelevant;

@Entity
@Table(name = "saveLogs")
public class SimpleInterestEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSave;
	private Date fechaOperacion;
	
	@Column(length=1000000)
	@Lob
	private String request;
	@Column(length=1000000)
	@Lob
	private String response;
	

	public Integer getIdSave() {
		return idSave;
	}

	public void setIdSave(Integer idSave) {
		this.idSave = idSave;
	}

	public Date getFechaOperacion() {
		return fechaOperacion;
	}

	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "SimpleInterestEntity [idSave=" + idSave + ", fechaOperacion=" + fechaOperacion + ", request=" + request
				+ ", response=" + response + "]";
	}

}

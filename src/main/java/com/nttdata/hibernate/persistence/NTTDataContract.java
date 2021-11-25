package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Hibernate - Taller 2
 * 
 * Entidad de tabla NTTDATA_TH1_CONTRACT
 * 
 * @author fprietoa
 *
 */
@Entity
@Table(name = "NTTDATA_TH1_CONTRACT")
public class NTTDataContract extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long contractId;

	/** Fecha de vigencia */
	private String vigencyDate;

	/** Fecha de caducidad */
	private String caducateDate;

	/** Precio mensual */
	private float monthPrice;

	/** Lista de clientes relacionados */
	private NTTDataCustomer customer;

	/**
	 * @return the contractId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getContractId() {
		return contractId;
	}

	/**
	 * @param contractId
	 *            the contractId to set
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	/**
	 * @return the vigencyDate
	 */
	@Column(name = "VIGENCY_DATE", nullable = false)
	public String getVigencyDate() {
		return vigencyDate;
	}

	/**
	 * @param vigencyDate
	 *            the vigencyDate to set
	 */
	public void setVigencyDate(String vigencyDate) {
		this.vigencyDate = vigencyDate;
	}

	/**
	 * @return the caducateDate
	 */
	@Column(name = "CADUCATE_DATE", nullable = false)
	public String getCaducateDate() {
		return caducateDate;
	}

	/**
	 * @param caducateDate
	 *            the caducateDate to set
	 */
	public void setCaducateDate(String caducateDate) {
		this.caducateDate = caducateDate;
	}

	/**
	 * @return the monthPrice
	 */
	@Column(name = "MONTH_PRICE")
	public float getMonthPrice() {
		return monthPrice;
	}

	/**
	 * @param monthPrice
	 *            the monthPrice to set
	 */
	public void setMonthPrice(float monthPrice) {
		this.monthPrice = monthPrice;
	}

	/**
	 * @return the customer
	 */
	@ManyToOne
	@JoinColumn(name = "FK_CUSTOMER")
	public NTTDataCustomer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(NTTDataCustomer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "NTTDataContract [contractId=" + contractId + ", vigencyDate=" + vigencyDate + ", caducateDate=" + caducateDate + ", monthPrice=" + monthPrice
		        + ", customer=" + customer + "]";
	}

	@Transient
	public Class<?> getClase() {
		return NTTDataContract.class;
	}

}

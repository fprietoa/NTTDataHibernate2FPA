package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Hibernate - Taller 2
 * 
 * Entidad de tabla NTTDATA_TH1_CUSTOMER
 * 
 * @author fprietoa
 *
 */
@Entity
@Table(name = "NTTDATA_TH1_CUSTOMER")
public class NTTDataCustomer extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long customerId;

	/** Nombre del cliente */
	private String name;

	/** Primer Apellido */
	private String lastName1;

	/** Segundo Apellido */
	private String lastName2;

	/** DNI */
	private String dni;

	/** Contrato asociado */
	private List<NTTDataContract> contractsList;

	/**
	 * @return the customerId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastName1
	 */
	@Column(name = "LASTNAME1", nullable = false)
	public String getLastName1() {
		return lastName1;
	}

	/**
	 * @param lastName1
	 *            the lastName1 to set
	 */
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}

	/**
	 * @return the lastName2
	 */
	@Column(name = "LASTNAME2", nullable = false)
	public String getLastName2() {
		return lastName2;
	}

	/**
	 * @param lastName2
	 *            the lastName2 to set
	 */
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	/**
	 * @return the dni
	 */
	@Column(name = "DNI", nullable = false, unique = true, length = 9)
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni
	 *            the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the contractsList
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	public List<NTTDataContract> getContractsList() {
		return contractsList;
	}

	/**
	 * @param contractsList
	 *            the contractsList to set
	 */
	public void setContractsList(List<NTTDataContract> contractsList) {
		this.contractsList = contractsList;
	}

	@Override
	public String toString() {
		return "NTTDataCustomer [customerId=" + customerId + ", name=" + name + ", lastName1=" + lastName1 + ", lastName2=" + lastName2 + ", dni=" + dni
		        + ", contractsList=" + contractsList + "]";
	}

	@Transient
	public Class<?> getClase() {
		return NTTDataCustomer.class;
	}

}

package com.nttdata.services;

import java.util.List;

import com.nttdata.hibernate.persistence.NTTDataContract;

/**
 * Hibernate - Taller 2
 * 
 * Interface del servicio de gestión de contratos.
 * 
 * @author fprietoa
 *
 */
public interface NTTDataContractManagementServiceI {

	/**
	 * Inserta un nuevo contrato.
	 * 
	 * @param newcontrato
	 */
	public void insertNewContract(final NTTDataContract newContract);

	/**
	 * Actualiza un contrato existente.
	 * 
	 * @param updatedContract
	 */
	public void updateContract(final NTTDataContract updatedContract);

	/**
	 * Elimina un contrato existente.
	 * 
	 * @param deletedContract
	 */
	public void deleteContract(final NTTDataContract deletedContract);

	/**
	 * Obtiene un contrato mediante su ID.
	 * 
	 * @param contractId
	 */
	public NTTDataContract searchById(final Long customerId);

	/**
	 * Obtiene todos los contratos existentes.
	 * 
	 * @return List<NTTDataContract>
	 */
	public List<NTTDataContract> searchAll();

	/**
	 * @param price
	 * @return
	 */
	public List<NTTDataContract> searchByPrice(final float price);

}

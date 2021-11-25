package com.nttdata.services;

import java.util.List;

import com.nttdata.hibernate.persistence.NTTDataCustomer;

/**
 * Hibernate - Taller 2
 * 
 * Interface del servicio de gestión de clientes.
 * 
 * @author fprietoa
 *
 */
public interface NTTDataCustomerManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newCustomer
	 */
	public void insertNewCustomer(final NTTDataCustomer newCustomer);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updatedCustomer
	 */
	public void updateCustomer(final NTTDataCustomer updatedCustomer);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedCustomer
	 */
	public void deleteCustomer(final NTTDataCustomer deletedCustomer);

	/**
	 * Obtiene un cliente mediante su ID.
	 * 
	 * @param customerId
	 */
	public NTTDataCustomer searchById(final Long customerId);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<NTTDataCustomer>
	 */
	public List<NTTDataCustomer> searchAll();

	/**
	 * Obtiene jugadores por nombre y salario.
	 * 
	 * @param namePattern
	 * @param budget
	 * @return List<EverisPlayer>
	 */
	public List<NTTDataCustomer> searchByNameAndMonthPrice(final String name, final Double budget);

}

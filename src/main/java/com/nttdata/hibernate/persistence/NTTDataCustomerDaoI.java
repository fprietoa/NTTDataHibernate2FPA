package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Hibernate - Taller 2
 * 
 * DAO de tabla NTTDATA_TH1_CUSTOMER
 * 
 * @author fprietoa
 *
 */
public interface NTTDataCustomerDaoI extends CommonDaoI<NTTDataCustomer> {

	/**
	 * Buscar un cliente por nombre.
	 * 
	 * @param nombre
	 */
	public List<NTTDataCustomer> searchByName(final String nombre);

	/**
	 * Obtiene clientes por nombre y salario.
	 * 
	 * @param namePattern
	 * @param budget
	 * @return List<NTTDataCustomer>
	 */
	public List<NTTDataCustomer> searchByNameAndMonthPrice(final String name, final Double budget);

}

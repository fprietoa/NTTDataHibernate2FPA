package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Hibernate - Taller 2
 * 
 * DAO de tabla NTTDATA_TH1_CONTRACT
 * 
 * @author fprieto
 *
 */
public interface NTTDataContractDaoI extends CommonDaoI<NTTDataContract> {

	/**
	 * Obtiene contratos por salario.
	 * 
	 * @param monthPrice
	 * @return List<NTTDataContract>
	 */
	public List<NTTDataContract> searchByMonthPrice(final float monthPrice);

}

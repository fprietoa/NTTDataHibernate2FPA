package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * Hibernate - Taller 2
 * 
 * DAO de tabla NTTDATA_TH1_CONTRACT
 * 
 * @author fprieto
 *
 */
public class NTTDataContractDaoImpl extends CommonDaoImpl<NTTDataContract> implements NTTDataContractDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public NTTDataContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<NTTDataContract> searchByMonthPrice(final float monthPrice) {

		// Consulta.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NTTDataContract> cquery = cb.createQuery(NTTDataContract.class);
		final Root<NTTDataContract> rootP = cquery.from(NTTDataContract.class);

		// WHERE.
		final Predicate pr1 = cb.gt(rootP.<Double> get("monthPrice"), monthPrice);

		// Consulta.
		cquery.select(rootP).where(pr1);

		// Ejecución de conslta.
		final List<NTTDataContract> results = session.createQuery(cquery).getResultList();

		return results;

	}

}

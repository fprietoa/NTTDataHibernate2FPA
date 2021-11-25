package com.nttdata.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NTTDataContract;
import com.nttdata.hibernate.persistence.NTTDataContractDaoI;
import com.nttdata.hibernate.persistence.NTTDataContractDaoImpl;

/**
 * Hibernate - Taller 2
 * 
 * Implementación del servicio de gestión de contratos.
 * 
 * @author fprietoa
 *
 */
public class NTTDataContractManagementServiceImpl implements NTTDataContractManagementServiceI {

	/** DAO: NTTDATA_TH1_CONTRACT */
	private NTTDataContractDaoI contractDao;

	/**
	 * Método constructor.
	 */
	public NTTDataContractManagementServiceImpl(final Session session) {
		this.contractDao = new NTTDataContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(final NTTDataContract newContract) {

		// Verificación de nulidad e inexistencia.
		if (newContract != null && newContract.getContractId() == null) {

			// Insercción del nuevo contrato.
			contractDao.insert(newContract);
		}

	}

	@Override
	public void updateContract(final NTTDataContract updatedContract) {

		// Verificación de nulidad y existencia.
		if (updatedContract != null && updatedContract.getContractId() != null) {

			// Actualización del contrato.
			contractDao.update(updatedContract);
		}

	}

	@Override
	public void deleteContract(final NTTDataContract deletedContract) {

		// Verificación de nulidad y existencia.
		if (deletedContract != null && deletedContract.getContractId() != null) {

			// Eliminación del contrato.
			contractDao.delete(deletedContract);
		}

	}

	@Override
	public NTTDataContract searchById(final Long contractId) {

		// Resultado.
		NTTDataContract contract = null;

		// Verificación de nulidad.
		if (contractId != null) {

			// Obtención del contrato por ID.
			contract = contractDao.searchById(contractId);
		}

		return contract;
	}

	@Override
	public List<NTTDataContract> searchAll() {

		// Resultado.
		List<NTTDataContract> contractsList = new ArrayList<NTTDataContract>();

		// Obtención de contratos.
		contractsList = contractDao.searchAll();

		return contractsList;
	}

	@Override
	public List<NTTDataContract> searchByPrice(final float price) {

		return contractDao.searchByMonthPrice(price);
	}

}

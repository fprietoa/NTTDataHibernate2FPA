package com.nttdata.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NTTDataContract;
import com.nttdata.hibernate.persistence.NTTDataCustomer;
import com.nttdata.services.NTTDataContractManagementServiceI;
import com.nttdata.services.NTTDataContractManagementServiceImpl;
import com.nttdata.services.NTTDataCustomerManagementServiceI;
import com.nttdata.services.NTTDataCustomerManagementServiceImpl;

/**
 * Hibernate - Taller 2
 * 
 * Clase principal
 * 
 * @author fprietoa
 *
 */
public class NTTDataHibernateMainT1 {

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final NTTDataCustomerManagementServiceI customerService = new NTTDataCustomerManagementServiceImpl(session);
		final NTTDataContractManagementServiceI contractService = new NTTDataContractManagementServiceImpl(session);

		// Auditoría.
		final String updatesUser = "FPRIETOA";

		// Generación de clientes.
		final NTTDataCustomer customer1 = new NTTDataCustomer();
		customer1.setName("Maria");
		customer1.setLastName1("Perez");
		customer1.setLastName2("Gomez");
		customer1.setDni("29546235F");
		customer1.setUpdatedDate(new Date());
		customer1.setUpdatedUser(updatesUser);
		customerService.insertNewCustomer(customer1);

		final NTTDataCustomer customer2 = new NTTDataCustomer();
		customer2.setName("Agustin");
		customer2.setLastName1("Guerrero");
		customer2.setLastName2("Reyes");
		customer2.setDni("23594354D");
		customer2.setUpdatedDate(new Date());
		customer2.setUpdatedUser(updatesUser);
		customerService.insertNewCustomer(customer2);

		final NTTDataCustomer customer3 = new NTTDataCustomer();
		customer3.setName("Pablo");
		customer3.setLastName1("Alvarez");
		customer3.setLastName2("Diaz");
		customer3.setDni("24951163T");
		customer3.setUpdatedDate(new Date());
		customer3.setUpdatedUser(updatesUser);
		customerService.insertNewCustomer(customer3);

		final NTTDataCustomer customer4 = new NTTDataCustomer();
		customer4.setName("Alexei");
		customer4.setLastName1("Viadero");
		customer4.setLastName2("Sanchez");
		customer4.setDni("24935642L");
		customer4.setUpdatedDate(new Date());
		customer4.setUpdatedUser(updatesUser);
		customerService.insertNewCustomer(customer4);

		final NTTDataCustomer customer5 = new NTTDataCustomer();
		customer5.setName("Daniel");
		customer5.setLastName1("Vazquez");
		customer5.setLastName2("Muñoz");
		customer5.setDni("24412562P");
		customer5.setUpdatedDate(new Date());
		customer5.setUpdatedUser(updatesUser);
		customerService.insertNewCustomer(customer5);

		// Generación de contratos.
		final NTTDataContract contract1 = new NTTDataContract();
		contract1.setVigencyDate("24/03/2021");
		contract1.setCaducateDate("30/03/2022");
		contract1.setMonthPrice(1450);
		contract1.setUpdatedDate(new Date());
		contract1.setUpdatedUser(updatesUser);
		contract1.setCustomer(customer1);
		contractService.insertNewContract(contract1);

		final NTTDataContract contract2 = new NTTDataContract();
		contract2.setVigencyDate("25/03/2021");
		contract2.setCaducateDate("29/03/2022");
		contract2.setMonthPrice(1550);
		contract2.setUpdatedDate(new Date());
		contract2.setUpdatedUser(updatesUser);
		contract2.setCustomer(customer2);
		contractService.insertNewContract(contract2);

		final NTTDataContract contract3 = new NTTDataContract();
		contract3.setVigencyDate("20/03/2021");
		contract3.setCaducateDate("21/03/2022");
		contract3.setMonthPrice(1500);
		contract3.setUpdatedDate(new Date());
		contract3.setUpdatedUser(updatesUser);
		contract3.setCustomer(customer3);
		contractService.insertNewContract(contract3);

		final NTTDataContract contract4 = new NTTDataContract();
		contract4.setVigencyDate("24/03/2021");
		contract4.setCaducateDate("25/03/2022");
		contract4.setMonthPrice(1220);
		contract4.setUpdatedDate(new Date());
		contract4.setUpdatedUser(updatesUser);
		contract4.setCustomer(customer4);
		contractService.insertNewContract(contract4);

		final NTTDataContract contract5 = new NTTDataContract();
		contract5.setVigencyDate("28/03/2021");
		contract5.setCaducateDate("29/03/2021");
		contract5.setMonthPrice(1430);
		contract5.setUpdatedDate(new Date());
		contract5.setUpdatedUser(updatesUser);
		contract5.setCustomer(customer5);
		contractService.insertNewContract(contract5);

		// Cambio de nombre y actualización.
		customer1.setName("Pepe");
		customerService.updateCustomer(customer1);

		session.clear();

		// Consultas (JPA Criteria)

		// Buscar contrato por precio al mes.
		System.out.println("Id Contratos con precio mayor a 1500€: ");

		List<NTTDataContract> contrato = contractService.searchByPrice(1500.0f);

		for (final NTTDataContract contract : contrato) {
			System.out.println(contract.getContractId() + " | " + contract.getMonthPrice());
		}

		// Buscar nombre cliente por precio al mes.
		System.out.println("Clientes con nombre empezado por P y precio mayor a 1450€: ");

		List<NTTDataCustomer> clientes2 = customerService.searchByNameAndMonthPrice("P%", 1450D);

		for (final NTTDataCustomer customer : clientes2) {
			for (final NTTDataContract contract : customer.getContractsList()) {
				System.out.println(customer.getName() + " | " + contract.getMonthPrice());
			}
		}

		// Cerrar la sesión.
		session.close();

	}
}

package com.reacsa.client.ws;

import com.ivend.client.objects.Transactions;
import com.ivend.converter.interfaces.impl.TransactionServiceImplementation;

public class ReacasaClientWS {
	
	Config cfg = new Config();
	

	final static String TRANSACTION_FILENAME = "transactions.file";


	TransactionServiceImplementation service = new TransactionServiceImplementation();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReacasaClientWS rcws = new ReacasaClientWS();
		rcws.execute();

	}

	public void execute() {

		/* Ejemplo Transacciones */
		final String filename = cfg.getStringProperty(TRANSACTION_FILENAME);
		System.out.println("Leyendo Propiedad {" + TRANSACTION_FILENAME + "} = " + filename);
		System.out.println("Realizando Parsing de archivo " + filename);

		Transactions transacciones = null;
		try {
			transacciones = service.getAllTransactions();
		} catch (Exception e) {
			System.err.println("Error haciendo parsing de las transacciones, favor de revisar el archivo." + filename+ " " + e);
			return;
	    }
		CreateTransaction ct = new CreateTransaction();
		ct.createTransactionStructure(transacciones);
		
		System.out.println("Obj Transactions cuenta con " + transacciones.getItems().size() + " Transaction Items");

	}

}

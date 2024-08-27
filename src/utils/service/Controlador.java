package utils.service;

import java.security.KeyPair;
import java.util.HashMap;



public class Controlador {
    private GenerarClaves generadorDeClaves;
    private HashMap<String, KeyPair> claves;
    private DigitalSignature ventanafirma;


    public Controlador() 
	{
		try
		{
			generadorDeClaves = new GenerarClaves();
            ventanafirma = new DigitalSignature();

			
		}
		catch(Exception e)
		{
			
		}
	}

    public void generarClave(String password)
	{
		generadorDeClaves.generarClave(password);
        claves=generadorDeClaves.getClaves();
        
		
	}

    public HashMap<String, KeyPair> getClaves() {
        this.claves=generadorDeClaves.getClaves();
		return claves;
	}

    public void exportarClavePublica(String rutaClavePublica, String passwordKeyPair) throws Exception
	{
       generadorDeClaves.exportarClavePublica(rutaClavePublica, passwordKeyPair);
        
	}




    public void firmarArchivo(String rutaArchivo,String rutaFirma, String passwordKeyPair) throws Exception
	{
        KeyPair parDeClaves = claves.get(passwordKeyPair);
        
		if(parDeClaves==null)
		{
			throw new Exception("No existe una clave privada guardada con el password especificado");
		}
		else
		{
			ventanafirma.firmarArchivo(rutaArchivo, parDeClaves.getPrivate(),rutaFirma);
		}
	}


    
   
}

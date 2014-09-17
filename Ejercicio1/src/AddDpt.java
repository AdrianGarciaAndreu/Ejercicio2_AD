import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class AddDpt {

	
//Array list de Objectos de tipo "Object"
private	ArrayList<Object>  objectsReaded = new ArrayList<Object>();
private File f; //archivo de almacenamiento


/**
 * Crea la clase y se conecta con el archivo
 * correspondiente
 */
	public AddDpt() { 
		//Conexion con el archivo
		String home = System.getProperty("user.home");
		this.f = new File(home+"/departamentos.dat");
		
		
		
		}
	

	

	
	/**
	 * le el archivo indicado 
	 */
	public void read(){
	
		
		if (f.exists() && f.isFile()) {

			try {
				FileInputStream	fis = new FileInputStream(f);
				ObjectInputStream ObIS = new ObjectInputStream(fis);


				boolean reading = true;
				while(reading == true){

					try {
						Departamento dept =(Departamento)ObIS.readObject();
						
						if (dept != null) {
							objectsReaded.add(dept);
							}
						
					
					} catch (ClassNotFoundException e) {

						
					} catch (EOFException salida){
						System.out.println("lectura completada");
						reading = false;
					}

				} // fin de bucle

				
				
			}catch (EOFException e2){
				System.out.println("lectura completada");
			} 
			
			catch (IOException e) {
				e.printStackTrace();
			} 


		}else {
			try {
				f.createNewFile();
				this.read();
			}
			catch (IOException e) {

			}



		}

	}
	
	
	
	
/**
 * Lista por pantalla todos los departamentos existentes en el archivo
 * de almacenamiento masivo 
 */
	public  void listDepts () { 


		try {
			FileInputStream	fis = new FileInputStream(f);
			ObjectInputStream ObIS = new ObjectInputStream(fis);

			boolean reading = true;
			while(reading == true){

				try {
					Departamento dept =(Departamento)ObIS.readObject();
					if (dept != null) {
						System.out.println("Nombre: "+dept.getDeptNom()+" \n"+
								"Localidad: "+dept.getDeptLocalidad()+"\n");
					}

				} catch (ClassNotFoundException e) {

				} catch (EOFException salida){
					System.out.println("lectura completada");
					reading = false;
				}

			} // fin de bucle

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	
	
	
	/**
	 * Crea departamentos
	 * lee previamente lo existente y lo guarda en memoria (ArrayList)
	 * y a continuacion lo vuelca todo en un archivo Nuevo del mismo nombre
	 * y agrega el departamento nuevo al final del archivo
	 */
	public void createDpt(int n, String Nom, String Lo) {
		this.read();
		try {
			FileOutputStream fOS = new FileOutputStream(f);
			ObjectOutputStream ObOS = new ObjectOutputStream(fOS);
			
			if (f.exists() && f.isFile()) {
					
				
				
					for(int i=0; i<this.objectsReaded.size(); i++) {
						ObOS.writeObject( this.objectsReaded.get(i) );
					}
				
					ObOS.writeObject(new Departamento(n, Nom, Lo));
				
					System.out.println("Todo se ha escrito correctamente ***** \n");
					
					fOS.close();
					this.objectsReaded.clear();
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Archivo No encontrado");
		} 
		
		 catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}

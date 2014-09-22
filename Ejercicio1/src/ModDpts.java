import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.stream.FileImageInputStream;


public class ModDpts {

	private File f;
	private	ArrayList<Object>  objectsReaded = new ArrayList<Object>();


	public ModDpts() {

		String home = System.getProperty("user.home");
		this.f = new File(home+"/departamentos.dat");
	}


/**
 * Modifica el archivo de almacenamiento buscando
 * por Numero de departamento, si este existe, con un nuevo
 * nombre y localidad.
 * @param DptNum
 * @param newName
 * @param newLoca
 */
	public void UpdateDept(int DptNum, String newName, String newLoca){

		if (f.exists() && f.isFile()) {

			FileInputStream fis;
			ObjectInputStream ObIS;
			try {

				fis = new FileInputStream(this.f);
				ObIS = new ObjectInputStream(fis);

				boolean reading = true;

				while (reading == true) {
					try {
						Departamento dept =(Departamento)ObIS.readObject();

						if (dept !=null) {

							//Si encuentra el numero introducido
							if(dept.getDeptNum() == DptNum){
								dept.setDeptNom(newName); //cambia nombre
								dept.setDeptLocalidad(newLoca); //cambia localidad
							}else {System.out.println("Departamento "+DptNum+" no encontrado en esta iteracion");}

							//Guarda el dpt en el array
							this.objectsReaded.add(dept);

						}
						else {reading=false;}

					
					}
					//Fin de bucle
					catch (EOFException e2){
						
						//Flujos de salida
						FileOutputStream fOS = new FileOutputStream(this.f);
						ObjectOutputStream ObOS = new ObjectOutputStream(fOS);
						
						for (int i=0;i<this.objectsReaded.size();i++) {
							Departamento dp2 = (Departamento)this.objectsReaded.get(i);
							ObOS.writeObject(dp2);
							System.out.println(dp2.getDeptNom()+" "+dp2.getDeptLocalidad());
							
							System.out.println("Registro "+i+" re-escrito correctamente");
							
							
						
						}
						
						
						
						System.out.println("Fin del archivo modificado");
						this.objectsReaded.clear();
						reading = false;
					} 
					
					catch (ClassNotFoundException e) {
						System.out.println("Fin de lecutra del archivo"+this.f.getName()+
								"Datos almacenados en memoria\n");
						reading=false;
					}

				}//fin de bucle


				System.out.println("Archivo modificado correctamente. \n");

			}
			
			catch (FileNotFoundException e) {

				System.out.println("Fallo al conectar con el Archivo "+this.f.getName()); 

			} catch (IOException e) {

				System.out.println("Fallo general de Entrada/Salida");
			}



		}else {
			System.out.println("Archivo no encontrado en el sistema");
		}

	}



}

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Ejecucion {



	public static void main(String[] args){
		Ejecucion ej = new Ejecucion();
		ej.Menu();
	}

	

	
	public void Menu(){
		boolean option = false;	
 
			System.out.println("Menu Departamentos: \n ");
			System.out.println("1. Insertar Departamento(Numero,Nombre,Localidad).");
			System.out.println("2. Salir.");
			
			
			System.out.print("Eliga opción: ");
			Scanner scn = new Scanner(System.in);
			int num = scn.nextInt();
			
			do {
			
				option=true;
				scn = new Scanner(System.in);
				
			try {
				
				
				switch(num){
				case 1:
					System.out.println("Agregando nuevo departamento a la base de datos");
						System.out.println("Introduza el numero del Departamento");
					int dnum = scn.nextInt();
						System.out.println("Introduza el nombre del Departamento");
					String dnom = scn.next();
						System.out.println("Introduza la localidad del Departamento");
					String loca = scn.next();
					
					Departamentos dep = new Departamentos(dnum, dnom, loca);
					this.addDept(dep);
					
					
					option=true;
					break;

				case 2:
					System.out.println("Cerrando...");
					scn.close();
					System.exit(0);
					option=true;
					break;
					
			/*	case 3: 
					
					System.out.println("Leyendo Departamento");
					int dpt=scn.nextInt();
					this.getDept(dpt);
					
					break;*/

				default :
					option=false;
					break;

				}

			}catch (NullPointerException | NoSuchElementException e2) {
				System.out.println("Introduzca un numero válido");
				option=false;
			}
		} while(option==false);


	}

	
	/**
	 * Agrega un departamento al archivo binario departamentos.dat
	 * @param ob1
	 */
	public void addDept(Object ob1) {
		
		String usuario = System.getProperty("user.home");
		
		File f = new File(usuario+"/departamentos.dat");
		System.out.println(f.getPath());		
		
		try {
			FileOutputStream fOS = new FileOutputStream(f,true);
			ObjectOutputStream DataOS = new ObjectOutputStream(fOS);
			
			DataOS.writeObject(ob1);
			
			System.out.println("Insertado Departamento correctamente  \n");
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}finally {
			this.Menu();
		}
		
	}
	
	/*
	
	/**
	 * Lee un departamento en funcion de su numero
	 * @param numDpt
	 
	public void getDept(int numDpt) {
		
		String path = System.getProperty("user.home");
		File f = new File(path+"/departamentos.dat");
		
		FileInputStream fis;
		ObjectInputStream DataIS = null;
		
		try {
			 fis = new FileInputStream(f);
			DataIS = new ObjectInputStream(fis);
			
			String DptNom;
			String DptLo;
			while(true){
			
			Departamentos dpt =(Departamentos)DataIS.readObject();
			 
			 if (dpt.getDeptNum() == numDpt ) {
				
				 DptNom= dpt.getDeptNom();
				DptLo = dpt.getLocalidad();
				
				System.out.println(DptNom);
				System.out.println(DptLo);
			 }
			
			}	
				
			
		}catch (EOFException e) {
			try {
				DataIS.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
*/
}

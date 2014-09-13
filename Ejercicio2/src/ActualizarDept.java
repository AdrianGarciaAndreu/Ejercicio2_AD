import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;



public class ActualizarDept {

	
	public static void main(String[] args) {
		ActualizarDept adeptos = new ActualizarDept();
		adeptos.Menu();

	}
	
	
	
	public void Menu() {
		
		System.out.println("Actualizar Departamentos");
		System.out.println("1. Actualizar (Buscar por numero)");
		System.out.println("2 Listar departamentos");
		System.out.println("3 Salir");
		
		Scanner scn = new Scanner(System.in);
		System.out.print("Introduzca Opcion: \n");
		int num = scn.nextInt();
		
		
		switch (num) {
		
		//Modifica un departamento
		case 1: 
			String user = System.getProperty("user.home");
			try {
				this.ModDpts(user, 1, "PACO", "El otro mundo");
			} catch (IOException e1) {
			
				e1.printStackTrace();
			}
			
			break;
		
		// Lista los departamentos actuales
		case 2:
			try {
				
				String user2 = System.getProperty("user.home");
				this.ListDpts(user2);
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
			
		case 3:
			scn.close();
			System.exit(0);
			break;
		
		default:
			System.out.println("TODO MAL");
			this.Menu();
			break;
		
		}
		
		
	}
	
	
	
	/**
	 * Modifica un departamento a razon del numero de departamento que
	 * introduzca el usuario (modifica, nombre y localidad
	 * @param path ruta del archivo "departamentos.dat"
	 * @param cod codigo del dapartamento a modifacar
	 * @param Nom nombre nuevo para el departamento
	 * @param Loc localidad nueva para el departamento
	 * @throws IOException
	 */
	public void ModDpts(String path, int cod, String Nom, String Loc) throws IOException{
		
		File f = new File(path+"/departamentos.dat");
		FileInputStream fs = new FileInputStream(f);
		ObjectInputStream DataIS = new ObjectInputStream(fs);
		
		File f_tmp = null; //archivo 2 temporal
		
		// Lectura de todos los Departamentos
		while (true){
			String old_nom=null;
			String old_Loc=null;
			
			try {
				//Guardado del objeto departamento actual en la iteracion del bucle
				Departamentos dept = (Departamentos)DataIS.readObject();
				//Guardo el codigo del dept introducido y se compara con el introducido por parametro
				int num = dept.getDeptNum();
				
				if (num == cod) {
					 old_nom = dept.getDeptNom();
					 old_Loc = dept.getLocalidad();
					
					dept.setDeptNom(Nom);
					dept.setLocalidad(Loc);
				}

				f_tmp = new File(path+"departamentos2.dat");
				FileOutputStream fs_tmp = new FileOutputStream(f_tmp);
				ObjectOutputStream ObOS_tmp = new ObjectOutputStream(fs_tmp);

				ObOS_tmp.writeObject(dept);


			} catch (ClassNotFoundException e) {
				System.out.println("Fin de archivo");
				System.out.println("Registro anterior a ser modificado");
				System.out.println("nombre: "+old_nom+" localidad: "+old_Loc);
				
				System.out.println("/n Nuevos datos del registro:");
				System.out.println("nombre: "+Nom+" localidad: "+Loc);
				
				f_tmp.renameTo(f);
				f.delete();
				
				
				
			}


		} // fin de bucle  


		
	}
	
	
	
	
/**
 * Lista los departamentos del archivo "departamentos.dat"
 * @param path: ruta del archivo "departamentos.dat"
 * @throws IOException
 */
	public void ListDpts(String path) throws IOException{
		// Creacion del archivo en memoria
		
		File f = new File(path+"/departamentos.dat");
		FileInputStream fs = new FileInputStream(f);
		
		ObjectInputStream DataIS = new ObjectInputStream(fs);
		
		while (true) {
			try {
				Departamentos dept =(Departamentos)DataIS.readObject();				
				System.out.println("codigo: "+dept.getDeptNum()+" nombre: "+dept.getDeptNom());
			
			}catch (EOFException e2) {
				
				System.out.println(" \nFin de la transmision desde Marte \n");
				//2DataIS.close(); fs.close(); this.Menu();
				
			} 
			
			
			catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}

import java.io.Serializable;

/**
 * Clase que sirve para crear Objetos de tipo Departamento
 * y almacenar los valores: Numero,Nombre y Localidad.
 * 
 * @author theidel
 *
 */
public class Departamento implements Serializable {


	
	/**
	 * Numero de serie
	 */
	private static final long serialVersionUID = 1L;
	
	private int DeptNum;
	private String DeptNom;
	private String DeptLocalidad;
	
	
	/**
	 * Creacion de un objeto de tipo Departamento
	 * @param n numero de departamento
	 * @param Nom nombre del departamento
	 * @param Lo localidad del departamento
	 */
	public Departamento(int n, String Nom, String Lo) {
		this.DeptNum=n;
		this.DeptNom=Nom;
		this.DeptLocalidad=Lo;
	}


	
	public int getDeptNum() {
		return DeptNum;
	}


	public void setDeptNum(int deptNum) {
		DeptNum = deptNum;
	}


	public String getDeptNom() {
		return DeptNom;
	}


	public void setDeptNom(String deptNom) {
		DeptNom = deptNom;
	}


	public String getDeptLocalidad() {
		return DeptLocalidad;
	}


	public void setDeptLocalidad(String deptLocalidad) {
		DeptLocalidad = deptLocalidad;
	}
	
	
	
	
	

}

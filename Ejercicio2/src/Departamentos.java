import java.io.Serializable;


public class Departamentos implements Serializable {

	
	private int DeptNum;
	private String DeptNom;
	private String Localidad;
	
	
	
	/**
	 * Constructor que recibe como parametros, el numero de un departamento,
	 * el nombre y la localidad de este.
	 * @param DeptNum
	 * @param DeptNom
	 * @param Localidad
	 */
	public Departamentos(int DeptNum, String DeptNom, String Localidad){
		this.DeptNum=DeptNum;
		this.DeptNom=DeptNom;
		this.Localidad=Localidad;
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



	public String getLocalidad() {
		return Localidad;
	}



	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	
	
	
}

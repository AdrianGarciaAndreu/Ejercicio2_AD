
public class Ejecucion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AddDpt ad = new AddDpt();
		
		//ad.createDpt(1, "Adrian", "Valencia");
		//ad.createDpt(2, "Shiru", "Madrid");
		//ad.createDpt(3, "Lala", "Brasil");
		
		ad.listDepts();
		
		ModDpts mo = new ModDpts();
		mo.UpdateDept(1, "Silvia", "Madrid");
		
		ad.listDepts();
		
		
		System.out.println("fin");
		System.exit(0);
	}

}

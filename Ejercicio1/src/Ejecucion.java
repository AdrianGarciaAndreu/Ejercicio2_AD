
public class Ejecucion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AddDpt ad = new AddDpt();
		
		ad.createDpt(1, "Adrian", "Valencia");
		ad.createDpt(2, "Pepe", "Madrid");
		ad.createDpt(3, "Juan", "Brasil");
		
		ad.listDepts();
		
		ModDpts mo = new ModDpts();
		mo.UpdateDept(1, "Pepe", "Puzol");
		mo.UpdateDept(2, "AKSJDS", "Japon");
		ad.listDepts();
		
		
		System.out.println("fin");
		System.exit(0);
	}

}

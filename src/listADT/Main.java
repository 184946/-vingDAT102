package listADT;

public class Main {
	
	public static void main(String[] args) {
		ListInterface nyListe = new AList();
		
		nyListe.add(50);
		nyListe.add(213);
	    nyListe.add(1);
	    nyListe.add(300);
	    
	    
	    System.out.println(nyListe.toString());
	    
	    System.out.println();
	    
	    System.out.println("Remove: " + nyListe.remove(3));
	    
	    System.out.println();
	    
	    System.out.println(nyListe.toString());
	    
	    System.out.println();
	    
	    nyListe.clear();
	    
	    System.out.println(nyListe.toString());
	    
	    nyListe.add(1);
	    nyListe.add(2);
	    nyListe.add(3);
	    
	    System.out.println();
	    
	    System.out.println(nyListe.getEntry(2));
	    
	    System.out.println();
	    
	    System.out.println("Inneholder listen elementet 1? " + nyListe.contains(1));
	}

}

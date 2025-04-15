package pakke;

public class oppgave_7{
	  
	  public int antallMaater(int trinn){
	    if (trinn == 0){
	      return 1;
	    }
	    
	    if (trinn == 1){
	      return 1;
	    }
	    
	    return antallMaater(trinn-1) + antallMaater(trinn-2);
	  }
	  
	}


	
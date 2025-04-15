package pakke;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import pakke.oppgave_7;


public class testOPpgave {
	
	@Test
	  public void testAntallMaater(){
		oppgave_7 oppgave = new oppgave_7();
	    assertEquals(oppgave.antallMaater(1), 1);
	    assertEquals(oppgave.antallMaater(2), 2);
	    assertEquals(oppgave.antallMaater(3), 3);
	    assertEquals(oppgave.antallMaater(4), 5);
	    assertEquals(oppgave.antallMaater(5), 8);
	  }

}

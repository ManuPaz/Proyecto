package mocks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import mocks.ClaseA;
import mocks.ClaseB;

class ClaseBTest {

	@Test
	void test() {
		ClaseB cb = new ClaseB(); // SUT
		ClaseA ca = Mockito.mock(ClaseA.class);
		cb.setCa(ca);

		Mockito.when(ca.func3(Mockito.anyInt(), Mockito.anyInt())).thenReturn(Integer.valueOf(5))
				.thenReturn(Integer.valueOf(5)).thenReturn(Integer.valueOf(5));

		int resultA = ca.func3(5, 6); 	// Invocaci�n directa del Mock
		int resultB = cb.met1();		// Invocaci�n del SUT

		assertEquals(5, resultA, "Falla la invocaci�n directa del Mock");
		assertEquals(5, resultB, "Falla la invocaci�n del SUT");

		Mockito.verify(ca, Mockito.times(2)).func3(Mockito.anyInt(), Mockito.anyInt());
	}

}

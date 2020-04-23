package mocksInyectados;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ClaseBTest {
	// ClaseA que simulamos con Mock
	ClaseA ca;

	// ClaseB en la que se Injectará la ClaseA
	@InjectMocks
	ClaseB cb;

	@BeforeEach 
	void setUp() throws Exception {
		// Creamos el mock de la ClaseA
		ca=Mockito.mock(ClaseA.class);
		
		// Inyectamos en las clases anotadas sus clases simuladas
		MockitoAnnotations.initMocks(this);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		ca=null;
		cb=null;
	}

	@Test
	void test() {
		// Arrange en Fixtures

		Mockito.when(ca.func3(Mockito.anyInt(), Mockito.anyInt())).thenReturn(Integer.valueOf(5))
				.thenReturn(Integer.valueOf(5)).thenReturn(Integer.valueOf(5));

		int resultA = ca.func3(5, 6); 	// Invocación directa del Mock
		int resultB = cb.met1();		// Invocación del SUT

		assertEquals(5, resultA, "Falla la invocación directa del Mock");
		assertEquals(5, resultB, "Falla la invocación del SUT");

		Mockito.verify(ca, Mockito.times(2)).func3(Mockito.anyInt(), Mockito.anyInt());	}

}

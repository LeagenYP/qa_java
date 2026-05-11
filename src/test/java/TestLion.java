import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestLion {

    private Lion lion;
    private Feline felineMock;

    @Before
    public void setUp() throws Exception {
        felineMock = mock(Feline.class);
        lion = new Lion("Самец", felineMock);
    }

    @Test
    public void testGetKittens() {
        int expectedKittensCount = 3;
        when(felineMock.getKittens()).thenReturn(expectedKittensCount);
        int actualKittenCounts = lion.getKittens();
        assertEquals(expectedKittensCount, actualKittenCounts);
    }

    @Test
    public void testDoesHaveManeWithUnknownSexGetException() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Оно", felineMock);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}

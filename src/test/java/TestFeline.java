import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestFeline {

    private Feline feline;
    private Animal mockAnimal;

    @Before
    public void setUp() {
        mockAnimal = mock(Animal.class);
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(mockAnimal.getFood("Хищник")).thenReturn(expectedFood);
        List<String> result = feline.eatMeat();
        assertEquals(expectedFood, result);
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensWithoutSetAmount() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensSetAmount() {
        assertEquals(3, feline.getKittens(3));
    }
}

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class TestLionGetFood {

    private Lion lion;
    private Feline felineMock;
    private final String animalKind;
    private final List<String> expectedFoodList;

    public TestLionGetFood(String animalKind, List<String> expectedFoodList) {
        this.animalKind = animalKind;
        this.expectedFoodList = expectedFoodList;
    }

    @Before
    public void setUp() throws Exception {
        felineMock = mock(Feline.class);
        lion = new Lion("Самец", felineMock, animalKind);
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] expectedFood() {
        return new Object[][] {
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Всеядное", List.of("Неизвестный вид животного, используйте значение Травоядное или Хищник")},
        };
    }

    @Test
    public void testLionGetFood() throws Exception {
        when(felineMock.getFood(animalKind)).thenReturn(expectedFoodList);
        List<String> actualFoodList = lion.getFood();
        assertEquals(expectedFoodList, actualFoodList);
    }
}

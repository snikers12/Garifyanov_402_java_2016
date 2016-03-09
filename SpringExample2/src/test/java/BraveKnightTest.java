import org.junit.Test;
import ru.itis.inform.BraveKnight;
import ru.itis.inform.Quest;
import ru.itis.inform.QuestException;

import static org.mockito.Mockito.*;

public class BraveKnightTest {
    @Test
    public void knightShouldEmbarkOnQuest() throws QuestException {
        Quest mockQuest = mock(Quest.class); // Создание фиктивного
        // объекта Quest
        BraveKnight knight = new BraveKnight(mockQuest); // Внедрение
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }
}
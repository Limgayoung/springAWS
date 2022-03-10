package item;

import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;


public class MemoryItemRepositoryTest {
    Item item = new Item();
    MemoryItemRepository repository = new MemoryItemRepository();

    void saveTest(){
        item.setTitle("밥먹기");
        item.setDone(false);

        repository.saveItem(item);

        assertEquals(1, item.getId());
    }
}

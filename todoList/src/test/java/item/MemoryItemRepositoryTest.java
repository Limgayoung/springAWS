package item;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;


public class MemoryItemRepositoryTest {

    MemoryItemRepository repository = new MemoryItemRepository();

    @Test
    void saveTest(){
        Item item = new Item();
        item.setTitle("밥먹기");
        item.setDone(false);

        repository.saveItem(item);

        assertEquals(1, item.getId());
        Logger.getGlobal().info("saveTest success, save: " + item.getId());
    }
    @Test
    void findByIdTest(){
        Optional<Item> finditem = repository.findById(1L);
        assertEquals(1, finditem.get().getId());
        Logger.getGlobal().info("findByIdTest success " + finditem.get().getId() + finditem.get().getTitle());
    }

    @Test
    void deleteItemTest(){
        Item i = new Item();
        i.setTitle("학교가기");
        i.setDone(false);

        repository.saveItem(i);
        repository.deleteItem(i);

        assertEquals(Optional.empty(), repository.findById(i.getId()));

        Logger.getGlobal().info("deleteItemTest succes");

    }

    @Test
    void updateItemTest(){
        //먼저 생성
        Item i = new Item();
        i.setTitle("밥먹기");
        i.setDone(false);
        repository.saveItem(i);
        
        //바꿀 아이템 찾기
        Optional<Item> item = repository.findById(1L);

        //id 같게 설정
        Item newItem = new Item();
        newItem.setId(item.get().getId());
        newItem.setTitle("수정");
        newItem.setDone(true);

        repository.updateItem(newItem);

        assertEquals("수정", repository.findById(item.get().getId()).get().getTitle());
        Logger.getGlobal().info("updateItemTest succes");

    }

    @Test
    void cleanStoreTest(){
        //먼저 생성
        Item i = new Item();
        i.setTitle("밥먹기");
        i.setDone(false);
        repository.saveItem(i);
        i = new Item();
        i.setTitle("학교가기");
        i.setDone(false);
        repository.saveItem(i);

        repository.cleanStore();

        assertEquals(0, repository.mapSize());

        Logger.getGlobal().info("cleanStoreTest success");
    }
}

package item;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public class MemoryItemRepository implements ItemRepository{

    private static Map<Long, Item> store = new HashMap<>(); //item이 저장된 map, id로 찾을 수 있음
    private static long sequence=0L;

    @Override
    public Item saveItem(Item item) {
        item.setId(++sequence);
        store.put(sequence, item);
        return item;
    }

    @Override
    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void deleteItem(Item item) {
        store.remove(item.getId());
    }

    @Override
    public void updateItem(Item item) {
        store.replace(item.getId(), item);
        //return item;
    }

    public long mapSize(){
        return store.size();
    }

    public void cleanStore(){
        store.clear();
    }
}

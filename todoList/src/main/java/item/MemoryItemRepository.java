package item;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryItemRepository implements ItemRepository{

    private static Map<Long, Item> store = new HashMap<>(); //find를 위한 map
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

    }

    @Override
    public Item updateItem(Item item) {
        return null;
    }

    public void cleanStore(){

    }
}

package item;

import java.util.Optional;

public interface ItemRepository {
    Item saveItem(Item item); //생성
    Optional<Item> findById(Long id); //조회
    //예상치 못한 NullPointerException 예외를 제공되는 메소드로 간단히 회피할 수 있음
    //복잡한 조건문 없이도 널(null) 값으로 인해 발생하는 예외를 처리할 수 있음
    void deleteItem(Item item); //삭제
    Item updateItem(Item item); //수정
}

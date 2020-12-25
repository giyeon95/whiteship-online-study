package linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListNodeTest {

    HeaderNode list;

    @BeforeEach
    void initListNode() {
        this.list = new HeaderNode();

        list.add(new Node(3))
            .add(new Node(4))
            .add(new Node(5))
            .add(new Node(6));

    }

    @Test
    @DisplayName("노드 초기화")
    void nodePrintTest() {
        list.print();

        assertEquals(list.size(), 4);
    }

    @Test
    @DisplayName("노드 추가")
    void nodeAddToPositionTest() {
        list.add(new Node(2), 0);
        assertTrue(list.contains(new Node(2)));

        list.print();
    }

    @Test
    @DisplayName("노드 삭제")
    void nodeRemoveToPositionTest() {
        list.remove(2);
        assertFalse(list.contains(new Node(2)));

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(100));

        list.print();
    }

    @Test
    @DisplayName("노드 포함 여부 테스트")
    void nodeContainsTest() {
        assertTrue(list.contains(new Node(6)));
        assertFalse(list.contains(new Node(100)));
    }


    @Test
    @DisplayName("노드 GET 테스트")
    void nodeGetTest() {
        Assertions.assertEquals(list.get(2).getData(), 5);
        Assertions.assertEquals(list.get(1).getData(), 4);
    }
}
package test;

import static org.junit.jupiter.api.Assertions.*;

import implemented.MyList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 1차 구현 과정 - 24/01/23
 * - 0. 기본 생성자 호출 LinkedList() : 완료
 * - 1. 추가 : boolean add(Object o) : 완료
 * - 2. 조회 : Object get(int index) : 완료
 * - 3. 조회 : int indexOf(Object obj) : 완료
 * - 4. 삭제 : Object remove(int index) : 완료
 * - 5. 크기 : int size() : 완료
 * - 6. 존재 여부 : boolean isEmpty() : 완료
 *
 * 2차 구현 과정 - 24/01/24
 * - 0. 생성자 LinkedList(Collection c) : 완료
 * - 1. 추가 : void add(int index, Object obj) : 완료
 * - 2.     : void addAll(int index, Collection c) : 완료
 * - 3. 조회 : int lastIndexOf(Object obj) : 완료
 * - 4.     : Object getFirst() : 완료
 * - 5.     : Object getLast() : 완료
 * - 6. 삭제 : boolean remove(Object obj) :
 * - 7.     : boolean removeAll(Collection c) :
 *
 */
class MyListTest {

    MyList ml;
    LinkedList ll;

    @BeforeEach
    void setUp() {
        ml = new MyList();
        ll = new LinkedList();
    }

    @Test
    @DisplayName("기본 생성자 호출")
    void test1() {
        // 정상적으로 생성됬는지 확인
        assertTrue(ll != null);
        assertTrue(ml != null);
        // 사이즈(노드 개수) 비교
        assertTrue(ml.size == ll.size());
    }

    @Test
    @DisplayName("컬렉션 받는 생성자 호출")
    void test30() {
        Collection c = new ArrayList();

        for (int i=0; i<100; i++) {
            c.add(i);
        }

        LinkedList ll = new LinkedList(c);
        MyList ml = new MyList(c);
        assertTrue(ll.size() == ml.size());
    }

    @Test
    @DisplayName("boolean add(Object) - 0. null을 넣었을 때")
    void test2() {
        ll.add(null);
        ml.add(null);
        assertTrue(ll.size() == ml.size);
    }

    @Test
    @DisplayName("boolean add(Object) - 1. 1개 추가")
    void test3() {
        ll.add("obj");
        ml.add("obj");
        assertTrue(ll.size() == ml.size);
    }

    @Test
    @DisplayName("boolean add(Object) - 2. 10개 추가")
    void test4() {
        for (int i=0; i<10; i++) {
            ll.add(i);
            ml.add(i);
        }
        assertTrue(ll.size() == ml.size);
    }

    @Test
    @DisplayName("boolean add(Object) - 3. 100개 추가")
    void test5() {
        for (int i=0; i<100; i++) {
            ll.add(i);
            ml.add(i);
        }
        assertTrue(ll.size() == ml.size);
    }

    @Test
    @DisplayName("boolean add(Object) - 4. 10만개 추가")
    void test6() {
        for (int i=0; i<100_000; i++) {
            ll.add(i);
            ml.add(i);
        }
        assertTrue(ll.size() == ml.size);
    }

    @Test
    @DisplayName("void add(int index, Object obj) - 0. 잘못된 인덱스를 입력한 경우")
    void test31() {
        try {
            ml.add(100, "hi");
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
    }

    @Test
    @DisplayName("void add(int index, Object obj) - 1. 리스트가 비어있고 맨 앞에 객체 추가하는 경우")
    void test32() {
        ml.add(0, "11");
        ll.add(0, "11");
        assertTrue(ll.size() == ml.size());
    }

    @Test
    @DisplayName("void add(int index, Object obj) - 2. 리스트가 비어있고 맨 앞에 null 추가하는 경우")
    void test33() {
        ll.add(0, null);
        ml.add(0, null);
        assertTrue(ll.size() == ml.size());
    }

    @Test
    @DisplayName("void add(int index, Object obj) - 3. 리스트의 사이즈가 10이고 맨 앞에 객체 추가하는 경우")
    void test34() {
        for (int i=0; i<10; i++) {
            ll.add(i);
            ml.add(i);
        }

        ll.add(0, "11");
        ml.add(0, "11");

        assertTrue(ll.size() == ml.size());
        assertTrue(ll.get(0).equals(ml.get(0)));
    }

    @Test
    @DisplayName("void add(int index, Object obj) - 4. 리스트의 사이즈가 10이고 5번째에 객체 추가하는 경우")
    void test35() {
        for (int i=0; i<10; i++) {
            ll.add(i);
            ml.add(i);
        }

        ll.add(4, "11");
        ml.add(4, "11");

        assertTrue(ll.size() == ml.size());
        assertTrue(ll.get(4).equals(ml.get(4)));
    }

    @Test
    @DisplayName("void add(int index, Object obj) - 5. 리스트의 사이즈가 10이고 마지막에 객체 추가하는 경우")
    void test36() {
        for (int i=0; i<10; i++) {
            ll.add(i);
            ml.add(i);
        }

        ll.add(10, "11");
        ml.add(10, "11");

        assertTrue(ll.size() == ml.size());
        assertTrue(ll.get(10).equals(ml.get(10)));
    }

    @Test
    @DisplayName("void addAll(int index, Collection c) - 0. 잘못된 인덱스를 입력한 경우")
    void test37() {
        try {
            Collection c = new ArrayList();
            for (int i=0; i<5; i++) {
                c.add(i);
            }
            ml.addAll(-1, c);
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
    }

    @Test
    @DisplayName("void addAll(int index, Collection c) - 1. 리스트가 비어있고 맨 앞에 null을 추가하는 경우")
    void test38() {
        try {
            Collection c = null;
            ml.addAll(0, c);
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    @DisplayName("void addAll(int index, Collection c) - 2. 리스트가 비어있고 맨 앞에 컬렉션을 추가하는 경우")
    void test39() {
        Collection c = new ArrayList();
        for (int i=0; i<5; i++) {
            c.add(i);
        }
        ll.addAll(0, c);
        ml.addAll(0, c);

        assertTrue(ll.size() == ml.size());
        for (int i=0; i<ll.size(); i++) {
            assertTrue(ll.get(i).equals(ml.get(i)));
        }
    }

    @Test
    @DisplayName("void addAll(int index, Collection c) - 3. 리스트의 사이즈가 10이고 맨 앞에 컬렉션 추가하는 경우")
    void test40() {
        Collection c = new ArrayList();
        for (int i=0; i<5; i++) {
            c.add(i);
        }
        for (int i=0; i<10; i++) {
            ll.add(i);
            ml.add(i);
        }
        ll.addAll(0, c);
        ml.addAll(0, c);

        assertTrue(ll.size() == ml.size());
        for (int i=0; i<ll.size(); i++) {
            assertTrue(ll.get(i).equals(ml.get(i)));
        }
    }

    @Test
    @DisplayName("void addAll(int index, Collection c) - 4. 리스트의 사이즈가 10이고 5번째에 컬렉션 추가하는 경우")
    void test41() {
        Collection c = new ArrayList();
        for (int i=0; i<5; i++) {
            c.add(i);
        }
        for (int i=0; i<10; i++) {
            ll.add(i);
            ml.add(i);
        }
        ll.addAll(4, c);
        ml.addAll(4, c);

        assertTrue(ll.size() == ml.size());
        for (int i=0; i<ll.size(); i++) {
            assertTrue(ll.get(i).equals(ml.get(i)));
        }
    }

    @Test
    @DisplayName("void addAll(int index, Collection c) - 5. 리스트의 사이즈가 10이고 맨 뒤에 컬렉션 추가하는 경우")
    void test42() {
        Collection c = new ArrayList();
        for (int i=0; i<5; i++) {
            c.add(i);
        }
        for (int i=0; i<10; i++) {
            ll.add(i);
            ml.add(i);
        }
        ll.addAll(10, c);
        ml.addAll(10, c);

        assertTrue(ll.size() == ml.size());
        for (int i=0; i<ll.size(); i++) {
            assertTrue(ll.get(i).equals(ml.get(i)));
        }
    }

    @Test
    @DisplayName("int lastIndexOf(Object obj) - 0. null을 찾는 경우")
    void test43() {
        int index1 = ll.lastIndexOf(null);
        int index2 = ml.lastIndexOf(null);
        assertTrue(index1 == index2);
    }

    @Test
    @DisplayName("int lastIndexOf(Object obj) - 1. 없는 객체를 찾는 경우")
    void test44() {
        Object obj = "hi";
        int index1 = ll.lastIndexOf(obj);
        int index2 = ml.lastIndexOf(obj);
        assertTrue(index1 == index2);
    }

    @Test
    @DisplayName("int lastIndexOf(Object obj) - 2. 사이즈가 10이고 5번째에 저장된 객체를 찾는 경우")
    void test45() {
        Object obj = "target";
        for (int i=0; i<10; i++) {
            if (i==4) {
                ll.add(obj);
                ml.add(obj);
            } else {
                ll.add(i);
                ml.add(i);
            }
        }

        int index1 = ll.lastIndexOf(obj);
        int index2 = ml.lastIndexOf(obj);
        assertTrue(index1 == index2);
    }

    @Test
    @DisplayName("int lastIndexOf(Object obj) - 3. 사이즈가 10이고 찾으려는 객체가 2개가 존재하고 마지막 인덱스가 7인 경우")
    void test46() {
        Object obj = "target";
        for (int i=0; i<10; i++) {
            if (i==4 || i==6) {
                ll.add(obj);
                ml.add(obj);
            } else {
                ll.add(i);
                ml.add(i);
            }
        }

        int index1 = ll.lastIndexOf(obj);
        int index2 = ml.lastIndexOf(obj);
        assertTrue(index1 == index2);
    }

    @Test
    @DisplayName("int lastIndexOf(Object obj) - 4. 사이즈가 1000이고 찾으려는 객체가 5개가 존재하고 마지막 인덱스가 999인 경우")
    void test47() {
        Object obj = "target";
        for (int i=0; i<1000; i++) {
            if (i==4 || i==7 || i==15 || i==999) {
                ll.add(obj);
                ml.add(obj);
            } else {
                ll.add(i);
                ml.add(i);
            }
        }

        int index1 = ll.lastIndexOf(obj);
        int index2 = ml.lastIndexOf(obj);
        assertTrue(index1 == index2);
    }

    @Test
    @DisplayName("public Object getFirst() - 0. 리스트에 내용이 없을 때/있을 때")
    void test48() {
        // 예외 발생 시키기
        try {
//            Object obj1 = ll.getFirst();
            Object obj2 = ml.getFirst();
        } catch (Exception e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }

        // 리스트 채움
        ll.add("1");
        ml.add("1");
        Object o1 = ll.getFirst();
        Object o2 = ml.getFirst();

        assertEquals(o1, o2);
    }

    @Test
    @DisplayName("public Object getLast() - 0. 리스트에 내용이 없을 때/있을 때")
    void test49() {
        // 예외 발생 시키기
        try {
//            Object obj1 = ll.getLast();
            Object obj2 = ml.getLast();
        } catch (Exception e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }

        // 리스트 채움
        for (int i=0; i<100; i++) {
            ll.add(i);
            ml.add(i);
        }

        Object o1 = ll.getLast();
        Object o2 = ml.getLast();

        assertEquals(o1, o2);
    }


    @Test
    @DisplayName("Object get(int index) - 0. 리스트가 비어있는 경우")
    void test7() {
        try {
//            ll.get(0);
            ml.get(0);
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
    }


    @Test
    @DisplayName("Object get(int index) - 1. 범위를 벗어난 인덱스를 입력한 경우")
    void test8() {
        try {
//            ll.get(-1);
            ml.get(-1);
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
    }

    @Test
    @DisplayName("Object get(int index) - 2. 사이즈가 10이고 범위 내의 인덱스를 입력한 경우")
    void test9() {
        for (int i=0; i<10; i++) {
            ll.add(i);
            ml.add(i);
        }

        Object result1 = ll.get(8);
        Object result2 = ml.get(8);
        assertEquals(result1, result2);
    }

    @Test
    @DisplayName("Object get(int index) - 3. 사이즈가 100이고 범위 내의 인덱스를 입력한 경우")
    void test10() {
        for (int i=0; i<100; i++) {
            ll.add(i);
            ml.add(i);
        }

        Object result1 = ll.get(59);
        Object result2 = ml.get(59);
        assertEquals(result1, result2);
    }

    @Test
    @DisplayName("Object get(int index) - 4. 사이즈가 10만이고 범위 내의 인덱스를 입력한 경우")
    void test11() {
        for (int i=0; i<100_000; i++) {
            ll.add(i);
            ml.add(i);
        }

        Object result1 = ll.get(5_000);
        Object result2 = ml.get(5_000);
        assertEquals(result1, result2);
    }

    @Test
    @DisplayName("int indexOf(Object obj) - 0. null 값을 찾는 경우")
    void test12() {
        int index1 = ll.indexOf(null);
        int index2 = ml.indexOf(null);
        assertTrue(index1 == index2);
    }

    @Test
    @DisplayName("int indexOf(Object obj) - 1. 1번째에 존재하는 값을 찾는 경우")
    void test13() {
        for (int i=0; i<10; i++) {
            ll.add(i);
            ml.add(i);
        }

        int target = 0;
        assertTrue(ll.indexOf(target) == ml.indexOf(target));
    }

    @Test
    @DisplayName("int indexOf(Object obj) - 2. 10번째에 존재하는 값을 찾는 경우")
    void test14() {
        for (int i=0; i<100; i++) {
            ll.add(i);
            ml.add(i);
        }

        int target = 9;
        assertTrue(ll.indexOf(target) == ml.indexOf(target));
    }

    @Test
    @DisplayName("int indexOf(Object obj) - 3. 100번째에 존재하는 값을 찾는 경우")
    void test15() {
        for (int i=0; i<1000; i++) {
            ll.add(i);
            ml.add(i);
        }

        int target = 99;
        assertTrue(ll.indexOf(target) == ml.indexOf(target));

    }

    @Test
    @DisplayName("int indexOf(Object obj) - 4. 10만번째에 존재하는 값을 찾는 경우")
    void test16() {
        for (int i=0; i<100_000; i++) {
            ll.add(i);
            ml.add(i);
        }

        int target = 99_999;
        assertTrue(ll.indexOf(target) == ml.indexOf(target));

    }

    @Test
    @DisplayName("int indexOf(Object obj) - 5. 존재하지 않는 값을 찾는 경우")
    void test17() {
        for (int i=0; i<1000; i++) {
            ll.add(i);
            ml.add(i);
        }

        int target = 99_999;
        assertTrue(ll.indexOf(target) == ml.indexOf(target));
    }

    @Test
    @DisplayName("Object remove(int index) - 0. 리스트가 비어있는 경우")
    void test18() {
        try {
            ll.remove(0);
            ml.remove(0);
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
    }

    @Test
    @DisplayName("Object remove(int index) - 1. 범위를 벗어난 값을 입력한 경우")
    void test19() {
        try {
            ll.remove(-1);
            ml.remove(-1);
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
    }

    @Test
    @DisplayName("Object remove(int index) - 2. 1번째 값을 삭제하는 경우")
    void test20() {
        for (int i=0; i<10; i++) {
            ll.add(i);
            ml.add(i);
        }

        Object result1 = ll.remove(0);
        Object result2 = ml.remove(0);
        assertTrue(result1.equals(result2));
    }
    @Test
    @DisplayName("Object remove(int index) - 3. 10번째 값을 삭제하는 경우")
    void test21() {
        for (int i=0; i<100; i++) {
            ll.add(i);
            ml.add(i);
        }

        Object result1 = ll.remove(10);
        Object result2 = ml.remove(10);
        assertTrue(result1.equals(result2));
    }

    @Test
    @DisplayName("Object remove(int index) - 4. 100번째 값을 삭제하는 경우")
    void test22() {
        for (int i=0; i<1000; i++) {
            ll.add(i);
            ml.add(i);
        }

        Object result1 = ll.remove(100);
        Object result2 = ml.remove(100);
        assertTrue(result1.equals(result2));
    }

    @Test
    @DisplayName("Object remove(int index) - 5. 10만번째 값을 삭제하는 경우")
    void test23() {
        for (int i=0; i<100_005; i++) {
            ll.add(i);
            ml.add(i);
        }

        Object result1 = ll.remove(100_000);
        Object result2 = ml.remove(100_000);
        assertTrue(result1.equals(result2));
    }

    @Test
    @DisplayName("Object remove(int index) - 6. 마지막 값을 삭제하는 경우")
    void test24() {
        for (int i=0; i<100; i++) {
            ll.add(i);
            ml.add(i);
        }

        Object result1 = ll.remove(99);
        Object result2 = ml.remove(99);
        assertTrue(result1.equals(result2));
    }

    @Test
    @DisplayName("int size() - 0. 요소가 없는 경우")
    void test25() {
        assertTrue(ll.size() == ml.size());
    }

    @Test
    @DisplayName("int size() - 1. 요소가 1개인 경우")
    void test26() {
        for (int i=0; i<1; i++) {
            ll.add(i);
            ml.add(i);
        }
        assertTrue(ll.size() == ml.size());
    }

    @Test
    @DisplayName("int size() - 2. 요소가 10개인 경우")
    void test27() {
        for (int i=0; i<10; i++) {
            ll.add(i);
            ml.add(i);
        }
        assertTrue(ll.size() == ml.size());
    }

    @Test
    @DisplayName("int size() - 3. 요소가 100개인 경우")
    void test28() {
        for (int i=0; i<100; i++) {
            ll.add(i);
            ml.add(i);
        }
        assertTrue(ll.size() == ml.size());
    }

    @Test
    @DisplayName("int size() - 4. 요소가 10만개인 경우")
    void test29() {
        for (int i=0; i<100_000; i++) {
            ll.add(i);
            ml.add(i);
        }
        assertTrue(ll.size() == ml.size());
    }
}
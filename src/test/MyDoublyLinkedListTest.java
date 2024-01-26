package test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import implemented.MyDoublyLinkedList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import jdk.jfr.Experimental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 1차 구현 과정 - 24/01/25
 * - 0. 기본 생성자 호출 LinkedList() : O
 * - 1. 추가 : boolean add(Object o) : O
 * - 2. 조회 : Object get(int index) : O
 * - 3. 조회 : int indexOf(Object obj) : O
 * - 4. 삭제 : Object remove(int index) : O
 * - 5. 크기 : int size() : O
 * - 6. 존재 여부 : boolean isEmpty() : O
 *
 * 2차 구현 과정 - 24/01/26
 * - 0. 생성자 LinkedList(Collection c) : O
 * - 1. 추가 : void add(int index, Object obj) : O
 * - 2.     : void addAll(int index, Collection c) : O
 * - 3. 조회 : int lastIndexOf(Object obj) : O
 * - 4.     : Object getFirst() : O
 * - 5.     : Object getLast() : O
 * - 6. 삭제 : boolean remove(Object obj) : O
 *
 */
public class MyDoublyLinkedListTest {

    LinkedList dl;
    MyDoublyLinkedList mdl;

    @BeforeEach
    void setUp() {
        dl = new LinkedList();
        mdl = new MyDoublyLinkedList();
    }

    @Test
    @DisplayName("생성자 - 0. 기본 생성자 호출")
    void constructorTest0() {
        // 정상적으로 생성됬는지 확인
        assertTrue(dl != null);
        assertTrue(mdl != null);
    }

    @DisplayName("Collection 을 매개변수로 받는 생성자 호출")
    @ParameterizedTest(name="{index}. {displayName} (Collection의 size는 {0})")
    @ValueSource(ints = {0, 10, 100, 1_000, 10_000})
    void constructorTest1(int size) {
        // 0. 세팅값
        ArrayList list = new ArrayList();
        for (int i=0; i<size; i++) {
            list.add(i);
        }
        Collection c = list;

        // 1. 작업 실행 및 결과 기록
        LinkedList dl = new LinkedList(c);
        MyDoublyLinkedList mdl = new MyDoublyLinkedList(c);

        // 2. 결과 비교
        assertTrue(dl != null);
        assertTrue(mdl != null);

        assertTrue(size == dl.size());
        assertTrue(size == mdl.size());
    }

    @Test
    @DisplayName("Collection 을 매개변수로 받는 생성자 호출, 이때 Collection이 null임")
    void constructorTest2() {
        // 0. 세팅값
        Collection c = null;

        try {
            // 1. 작업 실행 및 결과 기록
            LinkedList dl = new LinkedList(c);
            MyDoublyLinkedList mdl = new MyDoublyLinkedList(c);
        } catch (Exception e) {
            // 2. 결과 비교
            assertEquals(NullPointerException.class, e.getClass());
        }
        
    }


    @Test
    @DisplayName("boolean add(Object obj) - 0. null 을 추가하려는 경우")
    void addTest0() {
        // 0. 세팅값
        Object obj = null;

        // 1. 기대값
        boolean expectedResult = true;
        int expectedSize = 1;

        // 2. 실제 객체에 작업 실행 및 결과 기록
        boolean result1 = dl.add(obj);
        int size1 = dl.size();

        // 3. 내가 구현한 객체에 작업 실행 및 결과 기록
        boolean result2 = mdl.add(obj);
        int size2 = mdl.size;

        // 4. 예측 결과와 비교
        assertTrue(expectedResult == result1);
        assertTrue(expectedSize == size1);
        assertTrue(expectedResult == result2);
        assertTrue(expectedSize == size2);
    }

    @Test
    @DisplayName("boolean add(Object obj) - 1. 리스트가 비어있을 때 추가하려는 경우")
    void addTest1() {
        // 0. 세팅값
        Object obj = "obj";

        // 1. 기대값
        boolean expectedResult = true;
        int expectedSize = 1;

        // 2. 실제 객체에 작업 실행 및 결과 기록
        boolean result1 = dl.add(obj);
        int size1 = dl.size();

        // 3. 내가 구현한 객체에 작업 실행 및 결과 기록
        boolean result2 = mdl.add(obj);
        int size2 = mdl.size;

        // 4. 예측 결과와 비교
        assertTrue(expectedResult == result1);
        assertTrue(expectedSize == size1);
        assertTrue(expectedResult == result2);
        assertTrue(expectedSize == size2);
    }

    @Test
    @DisplayName("boolean add(Object obj) - 2. 리스트의 사이즈가 10일 때 추가하려는 경우")
    void addTest2() {
        // 0. 세팅값
        Object obj = "obj";

        // 1. 기대값
        boolean expectedResult = true;
        int expectedSize = 11;

        // 2. 실제 객체에 작업 실행 및 결과 기록
            // 2-1. 리스트 사이즈 10으로 만듦
            // 2-2. 객체 추가
        for (int i=0; i<10; i++) {
            dl.add(i);
            mdl.add(i);
        }

        boolean result1 = dl.add(obj);
        int size1 = dl.size();

        // 3. 내가 구현한 객체에 작업 실행 및 결과 기록
        boolean result2 = mdl.add(obj);
        int size2 = mdl.size;

        // 4. 예측 결과와 비교
        assertTrue(expectedResult == result1);
        assertTrue(expectedSize == size1);
        assertTrue(expectedResult == result2);
        assertTrue(expectedSize == size2);
    }

    @Test
    @DisplayName("boolean add(Object obj) - 3. 리스트의 사이즈가 100일 때 추가하려는 경우")
    void addTest3() {
        // 0. 세팅값
        Object obj = "obj";

        // 1. 기대값
        boolean expectedResult = true;
        int expectedSize = 101;

        // 2. 실제 객체에 작업 실행 및 결과 기록
        // 2-1. 리스트 사이즈 10으로 만듦
        // 2-2. 객체 추가
        for (int i=0; i<100; i++) {
            dl.add(i);
            mdl.add(i);
        }

        boolean result1 = dl.add(obj);
        int size1 = dl.size();

        // 3. 내가 구현한 객체에 작업 실행 및 결과 기록
        boolean result2 = mdl.add(obj);
        int size2 = mdl.size;

        // 4. 예측 결과와 비교
        assertTrue(expectedResult == result1);
        assertTrue(expectedSize == size1);
        assertTrue(expectedResult == result2);
        assertTrue(expectedSize == size2);
    }

    @Test
    @DisplayName("boolean add(Object obj) - 4. 리스트의 사이즈가 10만일 때 추가하려는 경우")
    void addTest4() {
        // 0. 세팅값
        Object obj = "obj";

        // 1. 기대값
        boolean expectedResult = true;
        int expectedSize = 100_001;

        // 2. 실제 객체에 작업 실행 및 결과 기록
        // 2-1. 리스트 사이즈 10으로 만듦
        // 2-2. 객체 추가
        for (int i=0; i<100_000; i++) {
            dl.add(i);
            mdl.add(i);
        }

        boolean result1 = dl.add(obj);
        int size1 = dl.size();

        // 3. 내가 구현한 객체에 작업 실행 및 결과 기록
        boolean result2 = mdl.add(obj);
        int size2 = mdl.size;

        // 4. 예측 결과와 비교
        assertTrue(expectedResult == result1);
        assertTrue(expectedSize == size1);
        assertTrue(expectedResult == result2);
        assertTrue(expectedSize == size2);
    }

    @Test
    @DisplayName("Object get(int index) - 0. 인덱스 허용 범위를 벗어난 경우")
    void getTest0() {
        int index = -1;
        try {
            mdl.get(index);
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
    }

    @Test
    @DisplayName("Object get(int index) - 1. 리스트 사이즈가 10이고 첫번째 객체를 찾는 경우")
    void getTest1() {
        // 0. 세팅값
        Object expectedObj = "obj";
        for (int i=0; i<10; i++) {
            if (i == 0) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.get(0);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.get(0);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertEquals(expectedObj, result2);
    }

    @Test
    @DisplayName("Object get(int index) - 2. 리스트 사이즈가 10이고 다섯번째 객체를 찾는 경우")
    void getTest2() {
        // 0. 세팅값
        Object expectedObj = "obj";
        for (int i=0; i<10; i++) {
            if (i == 4) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.get(4);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.get(4);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertEquals(expectedObj, result2);
    }

    @Test
    @DisplayName("Object get(int index) - 3. 리스트 사이즈가 10이고 열번째 객체를 찾는 경우")
    void getTest3() {
        // 0. 세팅값
        Object expectedObj = "obj";
        for (int i=0; i<10; i++) {
            if (i == 9) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.get(9);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.get(9);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertEquals(expectedObj, result2);
    }

    @Test
    @DisplayName("Object get(int index) - 4. 리스트 사이즈가 100이고 첫번째 객체를 찾는 경우")
    void getTest4() {
        // 0. 세팅값
        Object expectedObj = "obj";
        for (int i=0; i<100; i++) {
            if (i == 0) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.get(0);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.get(0);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertEquals(expectedObj, result2);
    }

    @Test
    @DisplayName("Object get(int index) - 5. 리스트 사이즈가 100이고 50번째 객체를 찾는 경우")
    void getTest5() {
        // 0. 세팅값
        Object expectedObj = "obj";
        for (int i=0; i<100; i++) {
            if (i == 49) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.get(49);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.get(49);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertEquals(expectedObj, result2);
    }

    @Test
    @DisplayName("Object get(int index) - 6. 리스트 사이즈가 100이고 100번째 객체를 찾는 경우")
    void getTest6() {
        // 0. 세팅값
        Object expectedObj = "obj";
        for (int i=0; i<100; i++) {
            if (i == 99) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.get(99);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.get(99);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertEquals(expectedObj, result2);
    }

    @Test
    @DisplayName("Object get(int index) - 7. 리스트 사이즈가 10만이고 첫번째 객체를 찾는 경우")
    void getTest7() {
        // 0. 세팅값
        Object expectedObj = "obj";
        for (int i=0; i<100_000; i++) {
            if (i == 0) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.get(0);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.get(0);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertEquals(expectedObj, result2);
    }

    @Test
    @DisplayName("Object get(int index) - 8. 리스트 사이즈가 10만이고 5만번째 객체를 찾는 경우")
    void getTest8() {
        // 0. 세팅값
        Object expectedObj = "obj";
        for (int i=0; i<100_000; i++) {
            if (i == 50_000-1) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.get(50_000-1);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.get(50_000-1);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertEquals(expectedObj, result2);
    }

    @Test
    @DisplayName("Object get(int index) - 9. 리스트 사이즈가 10만이고 10만번째 객체를 찾는 경우")
    void getTest9() {
        // 0. 세팅값
        Object expectedObj = "obj";
        for (int i=0; i<100_000; i++) {
            if (i == 100_000-1) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.get(100_000-1);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.get(100_000-1);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertEquals(expectedObj, result2);
    }

    @Test
    @DisplayName("Object get(int index) - 9. 리스트 사이즈가 10만이고 8만번째 객체를 찾는 경우")
    void getTest10() {
        // 0. 세팅값
        Object expectedObj = "obj";
        for (int i=0; i<100_000; i++) {
            if (i == 80_000-1) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.get(80_000-1);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.get(80_000-1);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertEquals(expectedObj, result2);
    }

    @Test
    @DisplayName("int indexOf(Object obj) - 0. null 객체의 인덱스를 찾는 경우")
    void indexOfTest0() {
        // 0. 세팅값
        int expectedIndex = -1;
        Object obj = null;
        // 1. 실제 객체 작업 실행 및 결과 기록
        int result1 = dl.indexOf(obj);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        int result2 = mdl.indexOf(obj);
        // 3. 예측 결과와 비교
        assertTrue(expectedIndex == result1);
        assertTrue(expectedIndex == result2);
    }

    @Test
    @DisplayName("int indexOf(Object obj) - 1. 존재하지 않는 객체를 찾는 경우")
    void indexOfTest1() {
        // 0. 세팅값
        int expectedIndex = -1;
        Object obj = "obj";

        for (int i=0; i<5; i++) {
            dl.add(i);
            mdl.add(i);
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        int result1 = dl.indexOf(obj);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        int result2 = mdl.indexOf(obj);
        // 3. 예측 결과와 비교
        assertTrue(expectedIndex == result1);
        assertTrue(expectedIndex == result2);
    }

    @Test
    @DisplayName("int indexOf(Object obj) - 2. 사이즈가 10이고 하나만 존재하는 객체를 찾는 경우")
    void indexOfTest2() {
        // 0. 세팅값
        int expectedIndex = 3;
        Object obj = "obj";

        for (int i=0; i<5; i++) {
            if (i == 3) {
                dl.add(obj);
                mdl.add(obj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        int result1 = dl.indexOf(obj);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        int result2 = mdl.indexOf(obj);
        // 3. 예측 결과와 비교
        assertTrue(expectedIndex == result1);
        assertTrue(expectedIndex == result2);
    }

    @Test
    @DisplayName("int indexOf(Object obj) - 3. 사이즈가 10이고 중복으로 존재하는 객체를 찾는 경우")
    void indexOfTest3() {
        // 0. 세팅값
        int expectedIndex = 3;
        Object obj = "obj";

        for (int i=0; i<5; i++) {
            if (i == 3 || i == 9) {
                dl.add(obj);
                mdl.add(obj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        int result1 = dl.indexOf(obj);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        int result2 = mdl.indexOf(obj);
        // 3. 예측 결과와 비교
        assertTrue(expectedIndex == result1);
        assertTrue(expectedIndex == result2);
    }

    @Test
    @DisplayName("int indexOf(Object obj) - 4. 사이즈가 100이고 하나만 존재하는 객체를 찾는 경우")
    void indexOfTest4() {
        // 0. 세팅값
        int expectedIndex = 30;
        Object obj = "obj";

        for (int i=0; i<100; i++) {
            if (i == 30) {
                dl.add(obj);
                mdl.add(obj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        int result1 = dl.indexOf(obj);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        int result2 = mdl.indexOf(obj);
        // 3. 예측 결과와 비교
        assertTrue(expectedIndex == result1);
        assertTrue(expectedIndex == result2);
    }

    @Test
    @DisplayName("int indexOf(Object obj) - 5. 사이즈가 100이고 중복으로 존재하는 객체를 찾는 경우")
    void indexOfTest5() {
        // 0. 세팅값
        int expectedIndex = 30;
        Object obj = "obj";

        for (int i=0; i<100; i++) {
            if (i == 30 || i == 50 || i == 70) {
                dl.add(obj);
                mdl.add(obj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        int result1 = dl.indexOf(obj);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        int result2 = mdl.indexOf(obj);
        // 3. 예측 결과와 비교
        assertTrue(expectedIndex == result1);
        assertTrue(expectedIndex == result2);
    }

    @Test
    @DisplayName("int indexOf(Object obj) - 0. 사이즈가 10만이고 하나만 존재하는 객체를 찾는 경우")
    void indexOfTest6() {
        // 0. 세팅값
        int expectedIndex = 3_000;
        Object obj = "obj";

        for (int i=0; i<100_000; i++) {
            if (i == 3_000) {
                dl.add(obj);
                mdl.add(obj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        int result1 = dl.indexOf(obj);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        int result2 = mdl.indexOf(obj);
        // 3. 예측 결과와 비교
        assertTrue(expectedIndex == result1);
        assertTrue(expectedIndex == result2);
    }

    @Test
    @DisplayName("int indexOf(Object obj) - 0. 사이즈가 10만이고 중복으로 존재하는 객체를 찾는 경우")
    void indexOfTest7() {
        // 0. 세팅값
        int expectedIndex = 3_000;
        Object obj = "obj";

        for (int i=0; i<100_000; i++) {
            if (i == 3_000 || i == 5_005 || i == 6_500) {
                dl.add(obj);
                mdl.add(obj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        int result1 = dl.indexOf(obj);
        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        int result2 = mdl.indexOf(obj);
        // 3. 예측 결과와 비교
        assertTrue(expectedIndex == result1);
        assertTrue(expectedIndex == result2);
    }

    @Test
    @DisplayName("Object remove(int index) - 0. 잘못된 인덱스를 입력한 경우")
    void removeTest0() {
        int index = -1;
        try {
            dl.remove(index);
            // mdl.remove(index);
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
    }

    @Test
    @DisplayName("Object remove(int index) - 1. 사이즈가 10이고 첫번째 객체를 삭제하는 경우")
    void removeTest1() {
        // 0. 세팅값
        Object expectedObj = "obj";
        int expectedSize = 9;
        int index = 0;

        for (int i=0; i<10; i++) {
            if (i == index) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }

        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.remove(index);

        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.remove(index);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertTrue(expectedSize == dl.size());
        assertEquals(expectedObj, result2);
        assertTrue(expectedSize == mdl.size());
    }

    @Test
    @DisplayName("Object remove(int index) - 2. 사이즈가 10이고 다섯번째 객체를 삭제하는 경우")
    void removeTest2() {
        // 0. 세팅값
        Object expectedObj = "obj";
        int expectedSize = 9;
        int index = 4;

        for (int i=0; i<10; i++) {
            if (i == index) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.remove(index);

        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.remove(index);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertTrue(expectedSize == dl.size());
        assertEquals(expectedObj, result2);
        assertTrue(expectedSize == mdl.size());
    }

    @Test
    @DisplayName("Object remove(int index) - 3. 사이즈가 10이고 열번째 객체를 삭제하는 경우")
    void removeTest3() {
        // 0. 세팅값
        Object expectedObj = "obj";
        int expectedSize = 9;
        int index = 9;

        for (int i=0; i<10; i++) {
            if (i == index) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.remove(index);

        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.remove(index);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertTrue(expectedSize == dl.size());
        assertEquals(expectedObj, result2);
        assertTrue(expectedSize == mdl.size());
    }

    @Test
    @DisplayName("Object remove(int index) - 4. 사이즈가 100이고 첫번째 객체를 삭제하는 경우")
    void removeTest4() {
        // 0. 세팅값
        Object expectedObj = "obj";
        int expectedSize = 99;
        int index = 0;

        for (int i=0; i<100; i++) {
            if (i == index) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.remove(index);

        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.remove(index);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertTrue(expectedSize == dl.size());
        assertEquals(expectedObj, result2);
        assertTrue(expectedSize == mdl.size());
    }

    @Test
    @DisplayName("Object remove(int index) - 5. 사이즈가 100이고 20번째 객체를 삭제하는 경우")
    void removeTest5() {
        // 0. 세팅값
        Object expectedObj = "obj";
        int expectedSize = 99;
        int index = 19;

        for (int i=0; i<100; i++) {
            if (i == index) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.remove(index);

        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.remove(index);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertTrue(expectedSize == dl.size());
        assertEquals(expectedObj, result2);
        assertTrue(expectedSize == mdl.size());
    }

    @Test
    @DisplayName("Object remove(int index) - 6. 사이즈가 100이고 25번째 객체를 삭제하는 경우")
    void removeTest6() {
        // 0. 세팅값
        Object expectedObj = "obj";
        int expectedSize = 99;
        int index = 25;

        for (int i=0; i<100; i++) {
            if (i == index) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.remove(index);

        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.remove(index);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertTrue(expectedSize == dl.size());
        assertEquals(expectedObj, result2);
        assertTrue(expectedSize == mdl.size());
    }


    @Test
    @DisplayName("Object remove(int index) - 7. 사이즈가 100이고 30번째 객체를 삭제하는 경우")
    void removeTest7() {
        // 0. 세팅값
        Object expectedObj = "obj";
        int expectedSize = 99;
        int index = 29;

        for (int i=0; i<100; i++) {
            if (i == index) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.remove(index);

        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.remove(index);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertTrue(expectedSize == dl.size());
        assertEquals(expectedObj, result2);
        assertTrue(expectedSize == mdl.size());
    }

    @Test
    @DisplayName("Object remove(int index) - 8. 사이즈가 100이고 60번째 객체를 삭제하는 경우")
    void removeTest8() {
        // 0. 세팅값
        Object expectedObj = "obj";
        int expectedSize = 99;
        int index = 59;

        for (int i=0; i<100; i++) {
            if (i == index) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.remove(index);

        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.remove(index);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertTrue(expectedSize == dl.size());
        assertEquals(expectedObj, result2);
        assertTrue(expectedSize == mdl.size());
    }

    @Test
    @DisplayName("Object remove(int index) - 9. 사이즈가 100이고 100번째 객체를 삭제하는 경우")
    void removeTest9() {
        // 0. 세팅값
        Object expectedObj = "obj";
        int expectedSize = 99;
        int index = 99;

        for (int i=0; i<100; i++) {
            if (i == index) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.remove(index);

        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.remove(index);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertTrue(expectedSize == dl.size());
        assertEquals(expectedObj, result2);
        assertTrue(expectedSize == mdl.size());
    }


    @Test
    @DisplayName("Object remove(int index) - 10. 사이즈가 10만이고 첫번째 객체를 삭제하는 경우")
    void removeTest10() {
        // 0. 세팅값
        Object expectedObj = "obj";
        int expectedSize = 100_000-1;
        int index = 0;

        for (int i=0; i<100_000; i++) {
            if (i == index) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.remove(index);

        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.remove(index);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertTrue(expectedSize == dl.size());
        assertEquals(expectedObj, result2);
        assertTrue(expectedSize == mdl.size());
    }


    @Test
    @DisplayName("Object remove(int index) - 11. 사이즈가 10만이고 5000번째 객체를 삭제하는 경우")
    void removeTes11() {
        // 0. 세팅값
        Object expectedObj = "obj";
        int expectedSize = 100_000-1;
        int index = 5_000-1;

        for (int i=0; i<100_000; i++) {
            if (i == index) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.remove(index);

        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.remove(index);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertTrue(expectedSize == dl.size());
        assertEquals(expectedObj, result2);
        assertTrue(expectedSize == mdl.size());
    }

    @Test
    @DisplayName("Object remove(int index) - 12. 사이즈가 10만이고 5만번째 객체를 삭제하는 경우")
    void removeTest12() {
        // 0. 세팅값
        Object expectedObj = "obj";
        int expectedSize = 100_000-1;
        int index = 50_000-1;

        for (int i=0; i<100_000; i++) {
            if (i == index) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.remove(index);

        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.remove(index);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertTrue(expectedSize == dl.size());
        assertEquals(expectedObj, result2);
        assertTrue(expectedSize == mdl.size());
    }

    @Test
    @DisplayName("Object remove(int index) - 13. 사이즈가 10만이고 7만번째 객체를 삭제하는 경우")
    void removeTest13() {
        // 0. 세팅값
        Object expectedObj = "obj";
        int expectedSize = 100_000-1;
        int index = 70_000-1;

        for (int i=0; i<100_000; i++) {
            if (i == index) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.remove(index);

        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.remove(index);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertTrue(expectedSize == dl.size());
        assertEquals(expectedObj, result2);
        assertTrue(expectedSize == mdl.size());
    }


    @Test
    @DisplayName("Object remove(int index) - 14. 사이즈가 10만이고 9만번째 객체를 삭제하는 경우")
    void removeTest14() {
        // 0. 세팅값
        Object expectedObj = "obj";
        int expectedSize = 100_000-1;
        int index = 90_000-1;

        for (int i=0; i<100_000; i++) {
            if (i == index) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.remove(index);

        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.remove(index);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertTrue(expectedSize == dl.size());
        assertEquals(expectedObj, result2);
        assertTrue(expectedSize == mdl.size());
    }

    @Test
    @DisplayName("Object remove(int index) - 15. 사이즈가 10만이고 10만번째 객체를 삭제하는 경우")
    void removeTest15() {
        // 0. 세팅값
        Object expectedObj = "obj";
        int expectedSize = 100_000-1;
        int index = 100_000-1;

        for (int i=0; i<100_000; i++) {
            if (i == index) {
                dl.add(expectedObj);
                mdl.add(expectedObj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }
        // 1. 실제 객체 작업 실행 및 결과 기록
        Object result1 = dl.remove(index);

        // 2. 내가 구현한 객체에 작업 실행 및 결과 기록
        Object result2 = mdl.remove(index);
        // 3. 예측 결과와 비교
        assertEquals(expectedObj, result1);
        assertTrue(expectedSize == dl.size());
        assertEquals(expectedObj, result2);
        assertTrue(expectedSize == mdl.size());
    }
    
    @DisplayName("void add(int index, Object obj) - 0. 범위를 벗어난 인덱스를 입력하는 경우")
    @ParameterizedTest(name = "{index}. {displayName} (현재 리스트 사이즈는 10, 이상한 인덱스 : {0})")
    @ValueSource(ints = {-1, 50000, -20, -5, 1000000})
    void addWithNotIncludeIndexTest(int index) {
        // 0. 세팅
            // 사이즈 10으로 만들기
        for (int i=0; i<10; i++) {
            dl.add(i);
            mdl.add(i);
        }
        Object obj = "obj";

        // 1. 실행
        // 2. 예측 결과
        try {
            dl.add(index, obj);
            mdl.add(index, obj);
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
    }

    @DisplayName("void add(int index, Object obj) - 1. 정상적인 실행")
    @ParameterizedTest(name = "{index}. {displayName} (현재 리스트 사이즈는 {0})")
    @ValueSource(ints = {1, 10, 100, 1_000, 10_000})
    void setUpSize(int size) {
        // 0. 세팅
        for (int i=0; i<size; i++) {
            dl.add(i);
            mdl.add(i);
        }
        // 1. 랜덤 인덱스에 객체 추가
        Object obj = "obj";
        int randomIndex = (int)(Math.random() * size);
        dl.add(randomIndex, obj);
        mdl.add(randomIndex, obj);
        // 2. 결과 비교
        addTest(dl, mdl, randomIndex);

    }

    void addTest(LinkedList dl, MyDoublyLinkedList mdl, int index) {
        Object o1 = dl.get(index);
        Object o2 = mdl.get(index);
        assertEquals(o1, o2);
    }

    @DisplayName("void addAll(int index, Collection c) - 0. 범위를 벗어난 인덱스를 입력하는 경우")
    @ParameterizedTest(name = "{index}. {displayName} (현재 리스트 사이즈는 10, 이상한 인덱스 : {0})")
    @ValueSource(ints = {-1, 50000, -20, -5, 1000000})
    void addWithNotIncludeIndexTest2(int index) {
        // 0. 세팅
        // 사이즈 10으로 만들기
        Collection c = new ArrayList();
        for (int i=0; i<10; i++) {
            dl.add(i);
            mdl.add(i);
            c.add(i);
        }

        // 1. 실행
        // 2. 예측 결과
        try {
            dl.addAll(index, c);
            mdl.addAll(index, c);
        } catch (Exception e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
        }
    }

    @DisplayName("void addAll(int index, Collection c) - 1. 정상적인 실행")
    @ParameterizedTest(name = "{index}. {displayName} (현재 리스트와 컬렉션의 사이즈는 {0})")
    @ValueSource(ints = {1, 10, 100, 1_000, 10_000})
    void setUpSize2(int size) {
        // 0. 세팅
        Collection c = new ArrayList();
        for (int i=0; i<size; i++) {
            dl.add(i);
            mdl.add(i);
            c.add(i);
        }
        // 1. 랜덤 인덱스에 컬렉션 추가
        int randomIndex = (int)(Math.random() * size);
        dl.addAll(randomIndex, c);
        mdl.addAll(randomIndex, c);
        // 2. 결과 비교
        addTest2(dl, mdl);

    }


    void addTest2(LinkedList dl, MyDoublyLinkedList mdl) {
        // 0. 사이즈 맞는지 확인
        assertTrue(dl.size() == mdl.size());

        // 1. 모든 요소 같은 객체인지 확인
        for (int i=0; i<dl.size(); i++) {
            Object o1 = dl.get(i);
            Object o2 = mdl.get(i);
            assertEquals(o1, o2);
        }
    }

    @DisplayName("Object getFirst(), Object getLast() - 0. 리스트가 비어있는 경우")
    @RepeatedTest(value = 10, name="{displayName} : {currentRepetition} / {totalRepetition}")
    void getFirstAndGetLastTest0() {
        try {
            Object f1 = dl.getFirst();
            Object f2 = mdl.getFirst();

            Object l1 = dl.getFirst();
            Object l2 = mdl.getLast();

        } catch (Exception e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }
    }

    @DisplayName("Object getFirst(), Object getLast() - 1. 리스트가 차있는 경우")
    @ParameterizedTest(name = "{index}. {displayName} (현재 리스트와 컬렉션의 사이즈는 {0})")
    @ValueSource(ints = {1, 10, 100, 1_000, 10_000})
    void getFirstAndGetLastTest1(int size) {
        // 0. 세팅
        for (int i=0; i<size; i++) {
            dl.add(i);
            mdl.add(i);
        }

        // 1. 비교
        Object f1 = dl.getFirst();
        Object f2 = mdl.getFirst();

        Object l1 = dl.getLast();
        Object l2 = mdl.getLast();

        assertEquals(f1, f2);
        assertEquals(l1, l2);
    }

    @DisplayName("int lastIndexOf(Object obj) - 0. 존재하지않는 객체를 찾는 경우")
    @ParameterizedTest(name = "{index}. {displayName} (현재 리스트 사이즈는 {0})")
    @ValueSource(ints = {1, 10, 100, 1_000, 10_000})
    void lastIndexOfTest0(int size) {
        for (int i=0; i<size; i++) {
            dl.add(i);
            mdl.add(i);
        }

        Object obj = "obj";
        int result1 = dl.lastIndexOf(obj);
        int result2 = mdl.lastIndexOf(obj);
        assertTrue(result1 == result2);
    }

    @DisplayName("Object getFirst(), Object getLast() - 1. 리스트가 차있는 경우")
    @ParameterizedTest(name = "{index}. {displayName} (현재 리스트와 컬렉션의 사이즈는 {0})")
    @ValueSource(ints = {1, 10, 100, 1_000, 10_000})
    void lastIndexOfTest1(int size) {
        // 0. 세팅
        int randomIndex = (int)Math.random()*size;
        Object obj = "obj";
        for (int i=0; i<size; i++) {
            if (i == randomIndex) {
                dl.add(obj);
                mdl.add(obj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }

        // 1. 비교
        int result1 = dl.lastIndexOf(obj);
        int result2 = mdl.lastIndexOf(obj);
        assertTrue(result1 == result2);
    }

    @DisplayName("boolean remove(Object obj) - 0. 존재하는 객체를 삭제하는 경우")
    @ParameterizedTest(name = "{index}. {displayName} (현재 리스트 사이즈는 {0})")
    @ValueSource(ints = {1, 10, 100, 1_000, 10_000})
    void removeTest0(int size) {
        int randomIndex = (int)Math.random()*size;
        Object obj = "obj";

        for (int i=0; i<size; i++) {
            if (i == randomIndex) {
                dl.add(obj);
                mdl.add(obj);
            } else {
                dl.add(i);
                mdl.add(i);
            }
        }

        boolean result1 = dl.remove(obj);
        boolean result2 = mdl.remove(obj);
        assertTrue(result1 == result2);
    }

    @DisplayName("boolean remove(Object obj) - 1. 존재하는 객체를 삭제하는 경우")
    @ParameterizedTest(name = "{index}. {displayName} (현재 리스트 사이즈는 {0})")
    @ValueSource(ints = {1, 10, 100, 1_000, 10_000})
    void removeTest1(int size) {
        Object obj = "obj";

        for (int i=0; i<size; i++) {
            dl.add(i);
            mdl.add(i);

        }

        boolean result1 = dl.remove(obj);
        boolean result2 = mdl.remove(obj);
        assertTrue(result1 == result2);
    }
}

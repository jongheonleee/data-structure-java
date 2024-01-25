package test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import implemented.MyDoublyLinkedList;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
 * - 0. 생성자 LinkedList(Collection c) :
 * - 1. 추가 : void add(int index, Object obj) :
 * - 2.     : void addAll(int index, Collection c) :
 * - 3. 조회 : int lastIndexOf(Object obj) :
 * - 4.     : Object getFirst() :
 * - 5.     : Object getLast() :
 * - 6. 삭제 : boolean remove(Object obj) :
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

    @Test
    @DisplayName("생성자 - 1. Collection 을 매개변수로 받는 생성자 호출")
    void constructorTest1() {

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




}

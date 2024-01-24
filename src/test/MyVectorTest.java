package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import implemented.MyVector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MyVectorTest {

    @DisplayName("생성자 - 1. 기본 생성자")
    @Test
    void test1() {
        MyVector v = new MyVector();
        assertTrue(v != null);
    }

    @DisplayName("생성자 - 2. 용량 매개변수 생성자")
    @Test
    void test2() {
        MyVector v = new MyVector(15);
//        assertTrue(v != null);
        assertTrue(v.capacity == 15);
    }

    @DisplayName("생성자 - 3. 용량, 확장단위 매개변수 생성자")
    @Test
    void test3() {
        MyVector v = new MyVector(12, 20);
//        assertTrue(v != null);
        assertTrue(v.capacity == 12);
        assertTrue(v.capacityIncrement == 20);
    }

    @DisplayName("add() - 1. 1개 넣었을 때")
    @Test
    void test4() {
        // 예측값
        int expectedSize = 1;
        int expectedCapacity = 10;

        // 작업 실행
        MyVector v = new MyVector();
        v.add(1);

        // 예측값과 실제값 비교
        assertTrue(v.size() == expectedSize);
        assertTrue(v.capacity() == expectedCapacity);
    }

    @DisplayName("add() - 2. capacity 보다 많이 넣었을 때")
    @Test
    void test5() {
        // 예측값
        int expectedSize = 11;
        int expectedCapacity = 20;

        // 작업 실행
        MyVector v = new MyVector();
        int oldCapacity = v.capacity();
        for (int i=0; i<oldCapacity+1; i++) {
            v.add(i);
        }

        // 예측값과 실제값 비교
        assertTrue(v.size() == expectedSize);
        assertTrue(v.capacity() == expectedCapacity);
    }

    @DisplayName("add() - 3. 특정 위치에 넣었을 때")
    @Test
    void test6() {
        // 예측값
        int expectedSize = 6;
        int expectedCapacity = 10;

        // 작업 실행
        MyVector v = new MyVector();
        for (int i=0; i<5; i++) {
            v.add(i);
        }
        int item = 11;
        v.add(3, item);
        Object found = v.get(3);

        // 예측값과 실제값 비교
        assertTrue(found.equals(item)); // 찾은 객체 비교
        assertTrue(v.size() == expectedSize); // 사이즈 비교
        assertTrue(v.capacity() == expectedCapacity); // 용량 비교
    }

    @DisplayName("size() & capacity() - 1. 아무값도 넣지 않았을 때")
    @Test
    void test7() {
        // 예측값
        int expectedSize = 0;
        int expectedCapacity = 10;

        // 작업 실행
        MyVector v = new MyVector();

        // 예측값과 실제값 비교
        assertTrue(v.size() == expectedSize);
        assertTrue(v.capacity() == expectedCapacity);
    }

    @DisplayName("size() & capacity() - 2. 5개를 넣었을 때")
    @Test
    void test8() {
        // 예측값
        int expectedSize = 5;
        int expectedCapacity = 10;

        // 작업 실행
        MyVector v = new MyVector();
        for (int i=0; i<expectedSize; i++) {
            v.add(i);
        }

        // 예측값과 실제값 비교
        assertTrue(v.size() == expectedSize);
        assertTrue( v.capacity() == expectedCapacity);
    }

    @DisplayName("size() & capacity() - 3. 15개를 넣었을 때")
    @Test
    void test9() {
        // 예측값
        int expectedSize = 15;
        int expectedCapacity = 20;

        // 작업 실행
        MyVector v = new MyVector();
        for (int i=0; i<expectedSize; i++) {
            v.add(i);
        }

        // 예측값과 실제값 비교
        assertTrue(v.size() == expectedSize);
        assertTrue(v.capacity() == expectedCapacity);
    }

    @DisplayName("size() & capacity() - 4. add() 메서드 호출했을 때")
    @Test
    void test11() {
        // 예측값
        int expectedSize = 5;
        int expectedCapacity = 10;

        // 작업 실행
        MyVector v = new MyVector();
        for (int i=0; i<expectedSize; i++) {
            v.add(i);
        }

        // 예측값과 실제값 비교
        assertTrue(v.size() == expectedSize);
        assertTrue(v.capacity() == expectedCapacity);
    }

    @DisplayName("indexOf() - 1. 존재하지 않는 값을 찾을 때")
    @Test
    void test12() {
        // 예측값
        int expectedIdx = -1;

        // 작업 실행
        MyVector v = new MyVector();
        int result = v.indexOf(7);

        // 예측값과 실제값 비교
        assertTrue(expectedIdx == result);
    }

    @DisplayName("indexOf() - 2. 존재하는 값을 찾을 때")
    @Test
    void test13() {
        // 예측값
        int expectedIdx = 0;

        // 작업 실행
        MyVector v = new MyVector();
        int target = 5;
        v.add(target);
        int result = v.indexOf(target);

        // 예측값과 실제값 비교
        assertTrue(expectedIdx == result);
    }

    @DisplayName("clear() - 1. 객체 배열 비우기")
    @Test
    void test14() {
        // 예측값
        int expectedSize = 0;
        int expectedCapacity = 10;

        // 작업 실행
        MyVector v = new MyVector();
        for (int i=0; i<5; i++) {
            v.add(i);
        }
        v.clear();

        // 예측값과 실제값 비교
        assertTrue(v.size() == expectedSize);
        assertTrue(v.capacity() == expectedCapacity);
    }

    @DisplayName("contains() - 1. 객체가 포함된 경우")
    @Test
    void test15() {
        // 예측값
        int expectedTarget = 7;
        boolean expected = true;

        // 작업 실행
        MyVector v = new MyVector();
        v.add(expectedTarget);
        boolean result = v.contains(expectedTarget);

        // 예측값과 실제값 비교
        assertTrue(expected == result);
    }

    @DisplayName("contains() - 2. 객체가 포함되어 있지 않은 경우")
    @Test
    void test16() {
        // 예측값
        int expectedTarget = 7;
        boolean expected = false;

        // 작업 실행
        MyVector v = new MyVector();
        boolean result = v.contains(expectedTarget);

        // 예측값과 실제값 비교
        assertTrue(expected == result);
    }

    @DisplayName("isEmpty() - 1. 객체 배열이 비어있는 경우")
    @Test
    void test17() {
        // 예측값
        boolean expected = true;

        // 작업 실행
        MyVector v = new MyVector();
        boolean result = v.isEmpty();

        // 예측값과 실제값 비교
        assertTrue(expected == result);
    }

    @DisplayName("isEmpty() - 2. 객체 배열이 비어있지 않은 경우")
    @Test
    void test18() {
        // 예측값
        boolean expected = false;

        // 작업 실행
        MyVector v = new MyVector();
        assertTrue(v.isEmpty()==true);

        v.add(1);
        boolean result = v.isEmpty();

        // 예측값과 실제값 비교
        assertTrue(expected == result);
    }

    @DisplayName("get() - 1. 해당 위치 값 반환")
    @Test
    void test19() {
        // 예측값
        int target = 7;
        int expected = target;

        // 작업 실행
        MyVector v = new MyVector();
        v.add(target);
        Object result = v.get(0);

        // 예측값과 실제값 비교
        assertTrue(result.equals(expected));
    }

    @DisplayName("remove() - 1. 첫번째 요소 삭제할때")
    @Test
    void test20() {
        // 예측값
        int expected = 0;

        // 작업 실행
        MyVector v = new MyVector();
        for (int i=0; i<5; i++) {
            v.add(i);
        }

        // 예측값과 실제값 비교
        Object result = v.remove(0);


        assertTrue(result.equals(expected));
    }

    @DisplayName("remove() - 2. 중간 요소 삭제할때")
    @Test
    void test21() {
        // 예측값
        int expected = 3;

        // 작업 실행
        MyVector v = new MyVector();
        for (int i=0; i<5; i++) {
            v.add(i);
        }

        Object result = v.remove(3);

        // 예측값과 실제값 비교
        assertTrue(result.equals(expected));
    }

    @DisplayName("remove() - 3. 마지막 요소 삭제할때")
    @Test
    void test22() {
        // 예측값
        int expected = 4;

        // 작업 실행
        MyVector v = new MyVector();
        for (int i=0; i<5; i++) {
            v.add(i);
        }
        Object result = v.remove(4);

        // 예측값과 실제값 비교
        assertTrue(result.equals(expected));

    }

    @DisplayName("remove(Object obj) - 1. 객체가 존재하지 않을 때")
    @Test
    void test23() {
        // 예측값
        boolean expected = false;

        // 작업 실행
        MyVector v = new MyVector();
        for (int i=0; i<5; i++) {
            v.add(i+"");
        }
        boolean result = v.remove("50");

        // 예측값과 실제값 비교
        assertTrue(expected == result);
    }

    @DisplayName("remove(Object obj) - 2. 객체가 존재할때")
    @Test
    void test24() {
        // 예측값
        boolean expected = true;
        String target = "5";

        // 작업 실행
        MyVector v = new MyVector();
        for (int i=0; i<4; i++) {
            v.add(i+"");
        }
        v.add(target);
        boolean result = v.remove(target);

        // 예측값과 실제값 비교
        assertTrue(expected == result);
    }

    @DisplayName("removeAllElements() - 1. 모든 요소 삭제")
    @Test
    void test25() {
        // 예측값
        int expectedSize = 0;

        // 작업 실행
        MyVector v = new MyVector();
        for (int i=0; i<5; i++) {
            v.add(i);
        }
        v.removeAllElements();

        // 예측값과 실제값 비교
        assertTrue(expectedSize == v.size());
    }

    @DisplayName("toString() - 1. 객체가 없는 경우")
    @Test
    void test26() {
        // 예측값
        String expectedStr = "[null, null, null, null, null, null, null, null, null, null]";

        // 작업 실행
        MyVector v = new MyVector();
        String result = v.toString();

        // 예측값과 실제값 비교
        assertTrue(result.equals(expectedStr));
    }

    @DisplayName("toString() - 2. 요소가 5개일 경우")
    @Test
    void test27() {
        // 예측값
        String expectedStr = "[1, 2, 3, 4, 5, null, null, null, null, null]";

        // 작업 실행
        MyVector v = new MyVector();
        for (int i=1; i<=5; i++) {
            v.add(i);
        }
        String result = v.toString();

        // 예측값과 실제값 비교
        assertTrue(result.equals(expectedStr));
    }

    @DisplayName("toString() - 3. 모두 다 차있는 경우")
    @Test
    void test28() {
        // 예측값
        String expectedStr = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]";

        // 작업 실행
        MyVector v = new MyVector();
        for (int i=1; i<=10; i++) {
            v.add(i);
        }
        String result = v.toString();

        // 예측값과 실제값 비교
        assertTrue(result.equals(expectedStr));
    }
}
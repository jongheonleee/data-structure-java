package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import implemented.MyVector2;
import java.util.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyVector2Test {

    MyVector2 mv;
    MyVector2 mv2;
    @BeforeEach
    void setUp() {
        mv = new MyVector2();
        mv2 = new MyVector2();
    }

    @Test
    @DisplayName("사이즈가 10인 벡터 이터레이터 활용")
    void test0() {
        // 0. 세팅값
        for (int i=0; i<10; i++) {
            mv.add(i);
            mv2.add(i);
        }

        // 1. 작업 진행 및 결과 비교
        Iterator it = mv.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = it.next();
            Object obj2 = mv2.get(i);
            assertEquals(obj, obj2);
            i++;
        }
    }
    @Test
    @DisplayName("사이즈가 100인 벡터 이터레이터 활용")
    void test1() {
        // 0. 세팅값
        for (int i=0; i<100; i++) {
            mv.add(i);
            mv2.add(i);
        }

        // 1. 작업 진행 및 결과 비교
        Iterator it = mv.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = it.next();
            Object obj2 = mv2.get(i);
            assertEquals(obj, obj2);
            i++;
        }
    }
    @Test
    @DisplayName("사이즈가 1000인 벡터 이터레이터 활용")
    void test2() {
        // 0. 세팅값
        for (int i=0; i<1000; i++) {
            mv.add(i);
            mv2.add(i);
        }

        // 1. 작업 진행 및 결과 비교
        Iterator it = mv.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = it.next();
            Object obj2 = mv2.get(i);
            assertEquals(obj, obj2);
            i++;
        }
    }
    @Test
    @DisplayName("사이즈가 1만인 벡터 이터레이터 활용")
    void test3() {
        // 0. 세팅값
        for (int i=0; i<10_000; i++) {
            mv.add(i);
            mv2.add(i);
        }

        // 1. 작업 진행 및 결과 비교
        Iterator it = mv.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = it.next();
            Object obj2 = mv2.get(i);
            assertEquals(obj, obj2);
            i++;
        }
    }    @Test
    @DisplayName("사이즈가 10만인 벡터 이터레이터 활용")
    void test4() {
        // 0. 세팅값
        for (int i=0; i<100_000; i++) {
            mv.add(i);
            mv2.add(i);
        }

        // 1. 작업 진행 및 결과 비교
        Iterator it = mv.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = it.next();
            Object obj2 = mv2.get(i);
            assertEquals(obj, obj2);
            i++;
        }
    }

}

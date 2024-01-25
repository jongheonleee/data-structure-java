package implemented;

import java.util.Iterator;

// Vector -> Iterator 로 변환하는 연습
//  Iterator 구현해야하는 메서드
// - 1. hasNext() : 확인
// - 2. next() : 꺼내기
// - 3. remove() : 삭제
public class MyVector2 extends MyVector implements Iterator {
    int cursor = 0; // 앞으로 읽어온 요소 위치 기록
    int lastRet = -1; // 마지막으로 읽어온 요소 위치 기록
    public MyVector2() {
        this(10);
    }

    public Iterator iterator() {
        // 초기화
        cursor = 0;
        lastRet = -1;
        // 해당 인스턴스 반환
        return this;
    }

    public MyVector2(int capacity) {
        super(capacity);
    }
    @Override
    public boolean hasNext() {
        // cursor 가 size 보다 작음
        return cursor < size();
    }

    @Override
    public Object next() {
        Object obj = get(cursor);
        lastRet = cursor++;
        return obj;
    }

    @Override
    public void remove() {
        // 한번도 꺼내거나 조회하지 않았기 때문에 삭제할 수 없음
        if (lastRet == -1) {
            throw new IllegalStateException();
        } else {
            remove(lastRet);
            cursor--;
            lastRet = -1;
        }
    }

    @Override
    public String toString() {
        String tmp = "";

        Iterator it = iterator();
        for (int i=0; it.hasNext(); i++) {
            if (i != 0) {
                tmp += ", ";
            }
            tmp += it.next();
        }

        return "[" + tmp + "]";
    }
}

package implemented;

import java.util.Collection;
import java.util.Iterator;
import test.MyDoublyLinkedListTest;

public class MyDoublyLinkedList {

    private class Node {
        Node prev, next;
        Object obj;

        Node(Object obj) {
            this.obj = obj;
        }
    }

    Node first, last; // 맨 앞 노드, 맨 뒤 노드
    public int size; // 리스트 사이즈(저장된 노드 개수)

    public MyDoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public MyDoublyLinkedList(Collection c) {
        if (c == null)
            throw new NullPointerException();

        Iterator it = c.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            add(obj);
        }
    }

    // 리스트 뒤에 객체를 노드형태로 추가
    public boolean add(Object obj) {
        // 0. 객체 -> 노드
        Node newNode = new Node(obj);

        // 1-1. 리스트가 비어있는 경우
            // 1-1-1. 첫번째 노드에 생성된 노드 기록
        if (size == 0) {
            first = newNode;
        }
        // 1-2. 리스트가 비어있지 않은 경우
            // 1-2-1. 마지막 노드의 다음 링크에 연결
            // 1-2-2. 생성된 노드의 이전 링크에 기존의 미지막 노드 연결
        else {
            last.next = newNode;
            newNode.prev = last;
        }

        // 2. 마지막 노드 생성된 노드로 기록 및 사이즈업
        last = newNode;
        size++;
        return true;
    }

    // 리스트의 특정 위치에 있는 노드의 객체 조회
    public Object get(int index) {
        // 0. 검증
            // 0-1. 리스트가 비어있는 경우
            // 0-2. 잘못된 인덱스를 입력한 경우
        if (isEmpty() || !isElementsOnIndex(index))
            throw new IndexOutOfBoundsException("잘못된 범위입니다.");

        // 1. 효율적인 탐색 결정
            // 1-1. 인덱스가 size/2 이하인 경우 -> first 에서 탐색
            // 1-2. 인덱스가 size/2 보다 큰 경우 -> last 에서 탐색
        if (index < size/2) {
            Node curr = first;
            for (int i=0; i<index; i++) {
                curr = curr.next;
            }
            return curr.obj;
        } else {
            Node curr = last;
            for (int i=0; i<size-index-1; i++) {
                curr = curr.prev;
            }
            return curr.obj;
        }
    }

    // 리스트에 저장된 객체 찾아서 그 위치 반환
    public int indexOf(Object obj) {
        // 0. 맨 앞 노드에서 시작
        Node curr = first;
        int index = 0;

        // 1. 탐색
        while (curr != null) {
            // 1-1. 해당 객체 찾으면 인덱스 반환
            if (curr.obj.equals(obj)) {
                return index;
            }
            curr = curr.next;
            index++;
        }

        // 2. 객체 찾지 못하면 -1 반환
        return -1;
    }

    // 리스트에서 index 번째 노드를 삭제
    public Object remove(int index) {
        // 0. 검증
            // 0-1. 리스트가 비어있는지
            // 0-2. 인덱스가 허용 범위내에 있는지
        if (isEmpty() || !isElementsOnIndex(index))
            throw new IndexOutOfBoundsException("잘못된 인덱스 범위입니다.");


        Node curr = find(index);
        Object removed = curr.obj;

        // 1. 삭제
            // 1-1. 사이즈가 1일 때 삭제하는 경우
                // 1-1-1. first, last 지우기
        if (size == 1) {
            first = null;
            last = null;
        }
            // 1-2. 맨 앞의 노드를 삭제하는 경우
                // 1-2-1. 맨 앞 노드로 이동
                // 1-2-2. 다음 노드 참조
                // 1-2-3. 링크 변경
                // 1-2-4. first 수정
        else if (index == 0) {

            Node next = curr.next;

            curr.next = null;
            next.prev = null;

            first = next;
        }
        // 1-3. 중간 노드를 삭제하는 경우
                // 1-3-1. 해당 위치로 이동
                // 1-3-2. prev, next 참조
                // 1-3-3. 링크 변경
        else if (0 < index && index < size-1) {
            Node prev = curr.prev;
            Node next = curr.next;

            prev.next = next;
            next.prev = prev;
            curr.prev = null;
            curr.next = null;
        }
        // 1-4. 마지막 노드를 삭제하는 경우
                // 1-4-1. 마지막 노드로 이동
                // 1-4-2. prev 참조
                // 1-4-3. 링크 변경
                // 1-4-4. last 수정
        else {
            Node prev = curr.prev;

            prev.next = null;
            curr.prev = null;

            last = prev;
        }
        // 2. 사이즈 줄이기
        size--;
        return removed;
    }

    // index 번째 노드 탐색
    private Node find(int index) {
        Node curr = first;
        // 0. 앞에서 탐색할지 뒤에서 탐색할지 판단
            // 0-1. 중간 위치보다 작은 곳에 있으면 앞에서 탐색
            // 0-2. 중간 위치보다 같거나 큰 곳에 있으면 뒤에서 탐색
        if (index < size/2) {
            for (int i=0; i<index; i++) {
                curr = curr.next;
            }
        } else {
            curr = last;
            for (int i=0; i<size-index-1; i++) {
                curr = curr.prev;
            }
        }

        return curr;
    }

    // index 번째에 노드 추가하기
    public void add(int index, Object obj) {
        // 0. 검증
            // 0-1. 인덱스가 허용 범위에 포함되는지
        if (!isIncludeIndex(index))
            throw new IndexOutOfBoundsException();

        // 1. 노드 생성
        Node newNode = new Node(obj);

        // 2. 추가
            // 2-0. 리스트가 비어있는 경우
            // 2-1. 맨 앞 추가
            // 2-2. 중간 추가
            // 2-3. 맨 뒤 추가
        if (size == 0) {
            add(obj);
        } else if (index == 0) {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        } else if (0 < index && index < size) {
            Node curr = find(index);
            Node prev = curr.prev;

            prev.next = newNode;
            newNode.prev = prev;

            newNode.next = curr;
            curr.prev = newNode;
        } else {
            Node curr = last;

            last.next = curr;
            curr.prev = last;
        }
        // 3. 사이즈업
        size++;
    }

    // index 번째에 데이터 더미를 추가함
    public void addAll(int index, Collection c) {
        // 0. 검증
            // 0-1. 잘못된 인덱스 범위
        if (!isIncludeIndex(index))
            throw new IndexOutOfBoundsException();

        // 1. index 번째 이동
        Node curr = find(index);

        // 2. 이터레이터 생성
        Iterator it = c.iterator();
        int tmpSize = 0;

        // 3. 이어 붙이기
            // 3-0. 리스트가 비어있는 경우
                // 3-0-0. 현재 노드 기록
                // 3-0-1. 노드 생성
                // 3-0-2. 현재 노드와 생성된 노드 연결
                // 3-0-3. 현재 노드 다음으로 이동
                // 3-0-4. 임시 사이즈 업
        if (size == 0) {
            while (it.hasNext()) {
                Node newNode = new Node(it.next());
                curr.next = newNode;
                newNode.prev = curr;
                curr = curr.next;
                tmpSize++;
            }
        }
            // 3-1. 맨 앞에부터 이어 붙이는 경우
                // 3-1-0. index 번째 노드로 이동, 현재 노드 기록
                // 3-1-1. 노드 생성
                // 3-1-2. first에 생성된 노드 기록
                // 3-1-3. 생성된 노드와 현재 노드 연결
                // 3-1-5. 임시 사이즈 업
        else if (index == 0) {
            if (it.hasNext()) {
                Node newNode = new Node(it.next());
                newNode.next = curr;
                curr.prev = newNode;
                first = newNode;
                curr = newNode;
                tmpSize++;

            }
            while (it.hasNext()) {
                Node newNode = new Node(it.next());
                Node next = curr.next;

                newNode.prev = curr;
                curr.next = newNode;

                next.prev = newNode;
                newNode.next = next;

                curr = curr.next;
                tmpSize++;
            }
        }
        // 3-2. 중간서부터 이어 붙이는 경우
                // 3-2-0. index 번째 노드로 이동, 현재 노드 기록
                // 3-2-1. 노드 생성
                // 3-2-2. 현재 노드와 생성된 노드 연결
                // 3-2-3. 생성된 노드와 다음 노드 연결
                // 3-2-4. 현재 노드 다음으로 이동
                // 3-2-5. 임시 사이즈 업
        else if (0 < index && index < size-1) {
            while (it.hasNext()) {
                Node newNode = new Node(it.next());
                Node prev = curr.prev;

                newNode.prev = prev;
                prev.next = newNode;

                newNode.next = curr;
                curr.prev = newNode;

                tmpSize++;
            }
        }
        // 3-3. 맨 뒤에서부터 이어 붙이는 경우
                // 3-3-0. 마지막 노드로 이동, 현재 노드 기록
                // 3-3-1. 노드 생성
                // 3-3-2. 현재 노드와 생성된 노드 연결
                // 3-3-3. 현재노드 다음으로 이동
                // 3-3-4. last 업데이트
                // 3-3-5. 임시 사이즈 업
        else {
            while (it.hasNext()) {
                Node newNode = new Node(it.next());

                newNode.prev = curr;
                curr.next = newNode;

                curr = curr.next;

                last = curr;

                tmpSize++;
            }
        }

        // 4. 사이즈업
        size += tmpSize;
    }

    public Object getFirst() {
        return first != null ? first.obj : null;
    }

    public Object getLast() {
        return last != null ? last.obj : null;
    }

    // 뒤에서 부터 탐색해서 obj 있으면 반환
    public int lastIndexOf(Object obj) {
        Node curr = last;
        int index = size-1;

        while (curr != null) {
            if (curr.obj.equals(obj)) {
                return index;
            }
            curr = curr.prev;
            index--;
        }

        return -1;
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) return false;
        Node curr = find(index);

        if (index == 0) {
            if (curr.next != null) {
                Node next = curr.next;

                curr.next = null;
                next.prev = null;

                first = next;
            } else {
                first = null;
                last = null;
            }
        } else if (0 < index && index <=size-1) {
            Node prev = curr.prev;
            Node next = curr.next;

            prev.next = next;
            curr.prev = null;

            next.prev = prev;
            curr.next = null;
        } else {
            Node prev = curr.prev;

            prev.next = null;
            curr.prev = null;

            last = prev;
        }

        size--;
        return true;
    }


    // 리스트 비어있는지 확인
     public boolean isEmpty() {
        return size == 0;
     }

     // 리스트 사이즈(저장된 노드 개수) 반환
     public int size() {
        return size;
     }
     // 인덱스에 객체가 존재하는지 확인
     private boolean isElementsOnIndex(int index) {
        return 0 <= index && index < size;
     }

     private boolean isIncludeIndex(int index) {
        return (0 <= index && index <= size);
     }
}

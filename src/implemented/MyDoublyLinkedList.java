package implemented;

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

    // 리스트 뒤에 객체를 노드형태로 추가
    public boolean add(Object obj) {
        // 0. 객체 -> 노드
        Node newNode = new Node(obj);

        // 1-1. 리스트가 비어있는 경우
            // 1-1-1. 첫번째 노드에 생성된 노드 기록
        if (size == 0) {
            first = newNode;
            last = newNode;
        }
        // 1-2. 리스트가 비어있지 않은 경우
            // 1-2-1. 마지막 노드의 다음 링크에 연결
            // 1-2-2. 생성된 노드의 이전 링크에 기존의 미지막 노드 연결
        else {
            last.next = newNode;
            newNode.prev = last;
            last = last.next;
        }

        // 2. 마지막 노드 생성된 노드로 기록 및 사이즈업
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

    private Node find(int index) {
        Node curr = first;
        for (int i=0; i<index; i++) {
            curr = curr.next;
        }

        return curr;
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

}

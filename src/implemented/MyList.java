package implemented;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Node {
    public Object obj;
    public Node next;

    public Node() {}

    public Node(Object obj) {
        this(obj, null);
    }

    public Node(Object obj, Node next) {
        this.obj = obj;
        this.next = next;
    }
}


public class MyList {
    public Node root;
    public int size;

    public MyList() {
        root = null;
        size = 0;
    }

    public MyList(Collection c) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            add(obj);
        }
    }

    public boolean add(Object obj) {
        Node node = new Node(obj);

        if (root == null) {
            root = node;
            size++;
            return true;
        }

        Node curr = root;
        while (curr != null && curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
        size++;

        return true;
    }

    public void add(int index, Object obj) {
        // 0. 검증 - 추가 가능 인덱스?
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("잘못된 범위입니다.");

        // 1. 해당 리스트가 null 인경우
        if (root == null) {
            add(obj);
            return;
        }

        Node newNode = new Node(obj);
        // 2. 추가 - 맨앞 / 중간 & 맨뒤
        // 맨앞
        // 중간 & 맨뒤
        if (index == 0) {
            newNode.next = root;
            root = newNode;
        } else {
            Node prev = find(index - 1);
            Node next = prev.next;

            prev.next = newNode;
            newNode.next = next;
        }
        size++;
    }

    public void addAll(int index, Collection c) {
        // 0. 검증 처리 - 1. 컬렉션 null?, 2. 잘못된 인덱스?
        if (c == null) throw new NullPointerException();
        if (!isPositionIndex(index)) throw new IndexOutOfBoundsException();

        // 1. 리스트가 비어있을 때
            // 1-1. c -> ll(사이즈 계산)
            // 1-2 링크 수정(루트에 연결)
            // 1-3 사이즈 업데이트

        // 2. 리스트가 비어있지 않을 때
            // 2-1. c -> ll(사이즈 계산)
            // 2-2. first, last 기록
            // 2-3. prev, next 기록
            // 2-4. 링크 수정
            // 2-5. 사이즈 업데이트

        if (root == null) {
            Iterator it = c.iterator();
            Node first = null;
            int subSize = 0;

            if (it.hasNext()) {
                first = new Node(it.next());
                subSize++;
            }

            Node curr = first;
            while (it.hasNext()) {
                Node newNode = new Node(it.next());
                curr.next = newNode;
                curr = curr.next;
                subSize++;
            }

            root = first;
            size += subSize;
        } else {
            Node first = null, last = null;
            Node prev = null, next = null;
            int subSize = 0;

            Iterator it = c.iterator();
            if (it.hasNext()) {
                first = new Node(it.next());
                subSize++;
            }

            Node curr = first;
            while (it.hasNext()) {
                Node newNode = new Node(it.next());
                curr.next = newNode;
                curr = curr.next;
                subSize++;
            }
            last = curr;

            if (index == 0) {
                next = root;
                last.next = next;
                root = first;
            } else {
                prev = find(index - 1);
                next = prev.next;

                prev.next = first;
                last.next = next;
            }
            size += subSize;
        }
    }

    private Node find(int index) {
        Node curr = root;
        for (int i=0; i<index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public Object get(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("잘못된 인덱스를 입력하셨습니다.");

        Node curr = root;
        for (int i=0; i<index; i++) {
            curr = curr.next;
        }

        return curr.obj;
    }

    public int indexOf(Object obj) {
        int index = 0;

        if (obj == null) {
            for (Node curr = root; curr != null; curr = curr.next) {
                Object o = curr.obj;
                if (o == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node curr = root; curr != null; curr = curr.next) {
                Object o = curr.obj;
                if (o.equals(obj)) {
                    return index;
                }
                index++;
            }
        }

        return -1;
    }

    public Object remove(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("잘못된 범위 입니다");

        Node prev = root, curr = root;
        if (0 < index && index < size) {
            for (int i=0; i<index; i++) {
                prev = curr;
                curr = curr.next;
            }
        }

        Object removed = curr.obj;
        prev.next = curr.next;
        curr.next = null;

        return removed;
    }

    public boolean remove(Object obj) {
        boolean ok = false;
        // 0. 리스트가 비어있음
        if (root == null) return ok;

        // 1. 찾음
            // 1-1. root 인 경우
            // 1-2. root 가 아닌 경우
        // 2. 못찾음
        Node curr = root, prev = null;
        while (curr != null) {
            if (curr.obj.equals(obj)) {
                if (curr == root) {
                    root = curr.next;
                } else {
                    prev.next = curr.next;
                }
                curr.next = null;
                ok = true;
            }

            if (ok) {
                size--;
                break;
            }

            prev = curr;
            curr = curr.next;
        }
        return ok;
    }

    public int lastIndexOf(Object obj) {
        // 0. index = -1 초기화
        int index = -1;
        // 1. 탐색
        Node curr = root;
        int j = 0;
        while (curr != null) {
            // 2. 객체 찾을 때마다 index에 기록
            if (curr.obj.equals(obj)) {
                index = j;
            }
            curr = curr.next;
            j++;
        }
        // 3. 마지막 index 반환
        return index;
    }

    public Object getFirst() {
        if (root == null)
            throw new NoSuchElementException();

        return root.obj;
    }

    public Object getLast() {
        if (root == null)
            throw new NoSuchElementException();

        Node curr = root;
        while (curr != null && curr.next != null) {
            curr = curr.next;
        }

        return curr.obj;
    }

    private boolean isElementIndex(int index) {
        return (0 <= index && index < size);
    }

    private boolean isPositionIndex(int index) {
        return (0 <= index && index <= size);
    }

    public int size() {
        return size;
    }

}
package implemented;

// 외부 패키지에서 테스트 진행, 따라서 public 으로 열어둠
public class MyVector {
    public Object[] elements;
    public int size; // 현재 객체 배열에서 객체 개수
    public int capacity; // 현재 객체 배열의 용량(크기)
    public int capacityIncrement; // 확장 단위, 해당 값이 0이면 더블링, 그렇지 않으면 확장 단위만큼 확장

    public MyVector() {
        this(10);
    }

    public MyVector(int capacity) {
        elements = new Object[capacity];
        size = 0;
        this.capacity = capacity;
        this.capacityIncrement = 0;
    }

    public MyVector(int capacity, int capacityIncrement) {
        this(capacity);
        this.capacityIncrement = capacityIncrement;
    }

    // 사이즈(객체의 개수) 반환
    public int size() {
        return size;
    }

    // 객체 배열의 용량(크기) 반환
    public int capacity() {
        return capacity;
    }

    // 용량이 확실한지 확인
    // minCapacity 보다 작은 용량인 경우 grow()를 호출해서 용량 확장
    public void ensureCapacity(int minCapacity) {
        // 현재 용량이 최소 용량 이하인 경우
        if (capacity - minCapacity <= 0) {
            // 용량 확장
            grow(minCapacity);
        }
    }

    // 용량 확장
    // 더블링하거나 확장 단위만큼 용량 확장
    private void grow(int minCapacity) {
        // 확장할 용량 길이
        // capacityIncrement 가 0이면 더블링, 그렇지 않으면 확장 단위만큼 확장
        int expendLength = capacityIncrement > 0 ? capacityIncrement : elements.length;

        // 공간 확보
        Object[] tmp = new Object[minCapacity + expendLength];

        // 기존 배열 내용 복사
        for (int i=0; i<elements.length; i++) {
            tmp[i] = elements[i];
        }

        // 참조 변경
        elements = tmp;
        // 현재 용량 변경
        capacity = elements.length;
    }

    // 사이즈(객체의 개수)가 0인지 확인
    public boolean isEmpty() {
        return size == 0;
    }

    // 객체 배열에서 size 번째에 객체 추가
    public void add(Object obj) {
        ensureCapacity(size); // size가 capacity보다 작은지 확인, 그렇지 않으면 용량 확장
        elements[size++] = obj; // 객체 추가
    }

    // 객체 배열의 index 번째에 객체 추가
    public void add(int index, Object obj) {
        // 객체 배열 허용 범위 내에 있는지 확인
        if (!(0 <= index && index < size))
            throw new IndexOutOfBoundsException("잘못된 범위입니다.");

        // size가 capacity보다 작은지 확인, 그렇지 않으면 용량 확장
        ensureCapacity(size);

        // index 번째 이후의 값들을 뒤로 한칸씩 이동
        // 마지막 요소부터 옮김(뒤에서부터)
        for (int i=size-1; i>=index; i--) {
            elements[i+1] = elements[i];
        }

        // index 번째에 객체 추가
        elements[index] = obj;
        size++;
    }

    // 객체 배열의 index 번째 객체 조회
    public Object get(int index) {
        // 객체 배열 허용 범위 내에 있는지 확인
        if (!(0 <= index && index < size)) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        // index 번째 객체 반환
        return elements[index];
    }

    // obj의 index 값 조회
    public int indexOf(Object obj) {
        int index = -1; // obj가 없을 때 -1 반환

        // 0~size 까지 탐색
        for (int i=0; i<size; i++) {
            // obj를 찾았을때 index에 i 저장하고 반복문 탈출
            if (elements[i].equals(obj)) {
                index = i;
                break;
            }
        }

        return index;
    }

    // 객체 배열 비움
    public void clear() {
        // 0~size까지 null로 저장
        for (int i=0; i<size; i++) {
            elements[i] = null;
        }

        // size, capacity 초기화
        size = 0;
        capacity = 10;
    }

    // obj가 있는지 확인
    public boolean contains(Object obj) {
        boolean found = false;

        // 0~size 까지 탐색
        for (int i=0; i<size; i++) {
            // obj를 찾았을때 체크하고 반복문 탈추
            if (elements[i].equals(obj)) {
                found = true;
                break;
            }
        }

        return found;
    }

    // index 번째 객체 지우기
    public Object remove(int index) {
        // 객체 배열 허용 범위 내에 있는지 확인
        if (!(0 <= index && index < size))
            throw new IndexOutOfBoundsException("잘못된 범위입니다.");

        // 객체 배열에서 index 번째 객체 조회
        Object removed = get(index);
        // 덮기 : index 번째 이후(index+1)의 덩어리를 한칸 올림
        System.arraycopy(elements, index+1, elements, index, size-index-1);
        // 지우기 : 마지막 번째 null 넣기
        elements[size-1] = null;
        // 개수 줄이기 : 저장된 객체 개수 줄이기
        size--;

        return removed;
    }

    // 객체 배열의 obj 객체 지움
    public boolean remove(Object obj) {
        // obj의 index 조회
        int index = indexOf(obj);
        // obj가 없는 경우 false 반환
        if (index == -1) return false;

        // index에 있는 객체 지우기
        remove(index);
        return true;
    }

    // 객체 배열의 모든 객체를 지움
    public void removeAllElements() {
        // 객체가 없는 경우
        if (size == 0) return;

        // i~size 까지 객체 null로 지움
        for (int i=0; i<size; i++) {
            elements[i] = null;
        }

        size = 0;
    }


    @Override
    public String toString() {
        // 기초 세팅
        String prefix = "[", suffix = "]", str = "";

        // 접두사
        str += prefix;

        // 내용물 추가
        for (int i=0; i< capacity; i++) {
            Object obj = elements[i];
            str += obj + ", ";
        }

        // 접미사
        str = str.substring(0, str.length()-2); //  마지막에 ", " 부분 자르기
        str += suffix; // 접미사 붙이기

        return str;
    }
}
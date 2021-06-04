public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public LinkedList(T val) {
        this.head.setVal(val);
        this.size = 0;
    }

    public T peek() {
        return this.head.getVal();
    }

    public T pop() {
        T val = this.head.getVal();
        this.head = this.head.getNext();
        this.size--;
        return val;
    }

    public void push(T val) {
        this.head = new Node<>(val, this.head);
        this.size++;
    }

    public void set(T val) {
        this.head.setVal(val);
    }

    public void set(int index, T val) {
        this.get(this.head, index).setVal(val);
    }

    public T next() {
        return this.head.getNext().getVal();
    }

    public T next(T val) {
        T prevValue = this.head.getNext().getVal();
        this.head.getNext().setVal(val);
        return prevValue;
    }

    private Node<T> get(Node<T> head, int remainder){
        if (remainder > 0 && head.getNext() != null)
            return get(head.getNext(), remainder - 1);
        else if (remainder > 0) {
            System.out.println("Index out of bounds.");
            return null;
        }

        return head;
    }

    public T get(int index) {
        return get(this.head, index).getVal();
    }

    private T remove(Node<T> head, int remainder){
        if (remainder > 0 && head.getNext() != null)
            return this.remove(head.getNext(), remainder - 1);
        else if (head.getNext() == null) {
            System.out.println("Index out of bounds.");
            return null;
        }

        T val = head.getNext().getVal();
        head.setNext(head.getNext().getNext());
        this.size--;
        return val;
    }

    public T remove(int index) {
        return this.remove(this.head, index - 1);
    }

    //Test this for whether or not the pointer is on the first head node or the current head within the recursive method
    // when it is setting the next head.
    public void add(int index, T val) {
        this.get(this.head, index - 1).setNext(new Node<>(val, head.getNext()));
        this.size++;
    }

    public int getSize(){
        return this.size;
    }

    private class Node<T> {
        private T val;
        private Node<T> next;

        public Node() {
            this.val = null;
            this.next = null;
        }

        public Node(T val) {
            this.val = val;
            this.next = null;
        }

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }

        public T getVal() {
            return this.val;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public Node<T> getNext() {
            return this.next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}

public class DLL {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    // 1. Add First
    void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // 2. Add Last
    void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // 3. Add Between (position starts from 1)
    void addBetween(int data, int position) {
        int len = length();

        if (position < 1 || position > len + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            addFirst(data);
            return;
        }

        if (position == len + 1) {
            addLast(data);
            return;
        }

        Node temp = head;

        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // 4. Remove First
    void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    // 5. Remove Last
    void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    // 6. Remove Between (position starts from 1)
    void removeBetween(int position) {
        int len = length();

        if (position < 1 || position > len) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            removeFirst();
            return;
        }

        if (position == len) {
            removeLast();
            return;
        }

        Node temp = head;

        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // 7. Length
    int length() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // 8. Reverse
    void reverse() {
        Node current = head;
        Node temp = null;

        tail = head;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    // 9. Display Forward
    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    // 10. Display Backward
    void displayBackward() {
        Node temp = tail;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {
        DLL list = new DLL();

        list.addFirst(20);
        list.addFirst(10);

        System.out.println("After addFirst:");
        list.display();

        list.addLast(30);
        list.addLast(40);

        System.out.println("After addLast:");
        list.display();

        list.addBetween(25, 3);

        System.out.println("After addBetween:");
        list.display();

        System.out.println("Length: " + list.length());

        list.removeFirst();

        System.out.println("After removeFirst:");
        list.display();

        list.removeLast();

        System.out.println("After removeLast:");
        list.display();

        list.removeBetween(2);

        System.out.println("After removeBetween:");
        list.display();

        list.reverse();

        System.out.println("After reverse:");
        list.display();

        System.out.println("Backward display:");
        list.displayBackward();
    }
}

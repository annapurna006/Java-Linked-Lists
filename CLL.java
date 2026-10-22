public class CLL {

        static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
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
            tail.next = head;
            return;
        }

        newNode.next = head;
        head = newNode;
        tail.next = head;
    }

    // 2. Add Last
    void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        tail.next = head;
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
        tail.next = head;
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

        Node temp = head;

        while (temp.next != tail) {
            temp = temp.next;
        }

        tail = temp;
        tail.next = head;
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

        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    // 7. Length
    int length() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        Node temp = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    // 8. Reverse
    void reverse() {
        if (head == null || head == tail) {
            return;
        }

        Node previous = tail;
        Node current = head;
        Node next;

        tail = head;

        do {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        } while (current != head);

        head = previous;
        tail.next = head;
    }

    // 9. Display
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        CLL list = new CLL();

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
    }
}

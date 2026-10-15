public class SLL{
    class Node{
        int data;
        Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
Node head = null;

void addFirst(int data){
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
}

void addLast(int data){
    Node newNode = new Node(data);
    if(head==null){
        head=newNode;
        return;
    }
    Node temp =head;
    while(temp.next!=null){
        temp=temp.next;
    }
    temp.next=newNode;
}

void addBetween(int data,int position){
    if(position<1){
        System.out.println("Invalid");
        return;
    }
    if(position==1){
        addFirst(data);
        return;
    }
    Node temp =head;
    for(int i=1;i<position-1 && temp!=null;i++){
        temp=temp.next;
    }
    if(temp==null){
        System.out.println("invalid position");
        return;
    }
    Node newNode = new Node(data);
    newNode.next=temp.next;
    temp.next=newNode;
}

void removeFirst(){
    if(head==null){
        System.out.println("List is empty");
        return;
    }
    head=head.next;
}

void removeLast(){
     if(head==null){
        System.out.println("List is empty");
        return;
    }
    Node temp =head;
    while(temp.next.next!=null){
        temp=temp.next;
    }
    temp.next=null;
}

void removeBetween(int position){
    if(head==null){
        System.out.println("List is empty");
        return;
    }
    if(position<1){
        System.out.println("Invalid");
    }
    if(position==1){
        removeFirst();
        return;
    }
    Node temp =head;
    for(int i=1;i<position-1 && temp!=null;i++){
        temp=temp.next;
    }
    if(temp==null && temp.next==null){
        System.out.println("invaild position");
        return;
    }
    temp.next=temp.next.next;
}

int length(){
    int count=0;
    Node temp = head;
    while(temp!=null){
        count++;
        temp=temp.next;
    }
    return count;
}

void reverse(){
    Node prev = null;
    Node temp = head;
    Node next;
    while(temp!=null){
        next=temp.next;
        temp.next=prev;
        prev=temp;
        temp=next;
    }
    head=prev;
}

void display(){
    Node temp = head;
    while(temp!=null){
        System.out.print(temp.data + " -> ");
        temp=temp.next;
    }
     System.out.println("Null");
}

public static void main(String[] args){
    SLL list =new SLL();
    list.addFirst(20);
    list.addFirst(10);
    list.display();
    list.addLast(30);
    list.addLast(40);
    list.display();
    list.addBetween(25,3);
    list.display();
    System.out.println("length: "+ list.length());
    list.removeFirst();
    list.display();
    list.removeLast();
    list.display();
    list.removeBetween(2);
    list.display();
    list.reverse();
    list.display();
}

}



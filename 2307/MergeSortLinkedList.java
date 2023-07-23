import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class MergeSortLinkedList {

    static Node merge(Node head1, Node head2) {
        Node temp = null;
        Node head = null;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                if (temp == null) {
                    head = head1;
                    temp = head;
                } else {
                    temp.next = head1;
                    temp = temp.next;
                }
                head1 = head1.next;
            } else {
                if (temp == null) {
                    head = head2;
                    temp = head;
                } else {
                    temp.next = head2;
                    temp = temp.next;
                }
                head2 = head2.next;
            }
        }

        if (head1 != null) {
            temp.next = head1;
        } else {
            temp.next = head2;
        }

        return head;
    }

    static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = sort(head);
        Node right = sort(nextOfMiddle);

        return merge(left, right);
    }

    static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of nodes in the first linked list: ");
        int n1 = scanner.nextInt();

        System.out.println("Enter the elements of the first linked list: ");
        Node head1 = null;
        for (int i = 0; i < n1; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);

            if (head1 == null) {
                head1 = newNode;
            } else {
                Node temp = head1;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        System.out.println("Enter the number of nodes in the second linked list: ");
        int n2 = scanner.nextInt();

        System.out.println("Enter the elements of the second linked list: ");
        Node head2 = null;
        for (int i = 0; i < n2; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);

            if (head2 == null) {
                head2 = newNode;
            } else {
                Node temp = head2;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        Node mergedList = sort(merge(head1, head2));

        System.out.println("The merged and sorted linked list is: ");
        while (mergedList != null) {
            System.out.print(mergedList.data + " ");
            mergedList = mergedList.next;
        }
    }
}

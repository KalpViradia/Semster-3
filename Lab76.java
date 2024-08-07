class Node {
    int coefficient;
    int exponent;
    Node next;

    Node(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}

class Polynomial {
    Node head;

    public void addTerm(int coefficient, int exponent) {
        Node newNode = new Node(coefficient, exponent);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            Node prev = null;
            while (temp != null && temp.exponent > exponent) {
                prev = temp;
                temp = temp.next;
            }
            if (temp != null && temp.exponent == exponent) {
                temp.coefficient += coefficient;
            } else {
                newNode.next = temp;
                if (prev == null) {
                    head = newNode;
                } else {
                    prev.next = newNode;
                }
            }
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.coefficient + "x^" + temp.exponent);
            if (temp.next != null) {
                System.out.print(" + ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public static Polynomial addPolynomials(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        Node t1 = p1.head;
        Node t2 = p2.head;

        while (t1 != null && t2 != null) {
            if (t1.exponent > t2.exponent) {
                result.addTerm(t1.coefficient, t1.exponent);
                t1 = t1.next;
            } else if (t1.exponent < t2.exponent) {
                result.addTerm(t2.coefficient, t2.exponent);
                t2 = t2.next;
            } else {
                result.addTerm(t1.coefficient + t2.coefficient, t1.exponent);
                t1 = t1.next;
                t2 = t2.next;
            }
        }

        while (t1 != null) {
            result.addTerm(t1.coefficient, t1.exponent);
            t1 = t1.next;
        }

        while (t2 != null) {
            result.addTerm(t2.coefficient, t2.exponent);
            t2 = t2.next;
        }

        return result;
    }
}

public class Lab76 {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.addTerm(5, 2);
        p1.addTerm(4, 1);
        p1.addTerm(2, 0);

        Polynomial p2 = new Polynomial();
        p2.addTerm(5, 1);
        p2.addTerm(5, 0);

        System.out.println("Polynomial 1:");
        p1.display();

        System.out.println("Polynomial 2:");
        p2.display();

        Polynomial result = addPolynomials(p1, p2);

        System.out.println("Resultant Polynomial after Addition:");
        result.display();
    }
}
public class Node {
    int data; // Almacena el valor del nodo
    Node next; // Referencia al siguiente nodo en la lista
    
    public Node(int data) {
        this.data = data;  
        this.next = null;
    }
}

class LinkedList {
    Node head;
    
    public LinkedList() {
        this.head = null;
    }
    
    public void add(int data) { // Agrega un nuevo nodo al final de la lista.
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    public void addFirst(int data) { // Agrega un nuevo nodo al inicio de la lista.
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    public void addMiddle(int data, int position) { // Agrega un nodo en una posición específica.
        Node newNode = new Node(data);
        if (head == null || position <= 0) {
            addFirst(data);
            return;
        }
        Node current = head;
        int count = 0;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    
    public void remove(int data) { // Elimina el nodo que continene un valor especifico. 
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }
    
    public void printList() { // Imprime los valores de la lista,
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public void reverse() { // Invierte el orden de los nodos en la lista.
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    
    public boolean contains(int value) { // Verifica si un valor existe en la lista.
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        System.out.println("=== Operaciones para Grupo 1 ==="); // Grupo 1: Estudiantes cuyo carnet termina en 0, 2, 4, 6, 8
        
        System.out.println("1. Agregando el número 0 al inicio de la lista"); // 1. Agregar el número 0 al inicio de la lista
        list.addFirst(0);
        
        System.out.println("2. Agregando el número 2 al final de la lista"); // 2. Agregar el número 2 al final de la lista
        list.add(2);
        
        System.out.println("3. Agregando el número 4 al medio de la lista (en la posición 1)"); // 3. Agregar el número 4 al medio de la lista (en la posición 1)
        list.addMiddle(4, 1);
        
        System.out.println("4. Lista actual:"); // 4. Mostrar la lista actual
        list.printList();
        
        System.out.println("5. Removiendo el número 2 de la lista"); // 5. Remover el número 2 de la lista
        list.remove(2);
        
        System.out.println("6. Lista después de la eliminación:"); // 6. Mostrar la lista después de la eliminación
        list.printList();
        
        System.out.println("7. Agregando el número 6 al final de la lista"); // 7. Agregar el número 6 al final de la lista
        list.add(6);
        
        System.out.println("8. ¿La lista contiene el número 4? " + list.contains(4)); // 8. Verificar si el número 4 está en la lista (Método contains)
        
        System.out.println("9. ¿La lista contiene el número 8? " + list.contains(8)); // 9. Verificar si el número 8 está en la lista (Método contains)
        
        System.out.println("10. Revirtiendo la lista"); // 10. Revertir la lista (Método reverse)
        list.reverse();
        
        System.out.println("11. Lista después de revertir:"); // 11. Mostrar la lista después de revertir
        list.printList();
        
        System.out.println("12. Agregando el número 8 al inicio de la lista"); // 12. Agregar el número 8 al inicio de la lista
        list.addFirst(8);
        
        System.out.println("13. Lista final:"); // 13. Mostrar la lista final
        list.printList();
    }
}
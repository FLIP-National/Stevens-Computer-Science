/*
 * Submitted by Chaitanya Ramesh Pawar
 * CS570 B - data Structures
 * Stevens Institute of Technology | Hoboken, New Jersey
 * IDLListTest.java
 * */
public class IDLListTest {

	public static void main(String[] args) {
		// create an empty indexed double linked list, data type is Integer
        IDLList<Integer> idlList = new IDLList<Integer>();

        // add element 25 at the head, 25 becomes the first element
        idlList.add(25);
        System.out.println("The first element of the list is: " + idlList.toString() + "\n");

        // add element 7 at the head, 7 becomes the first element
        idlList.add(0,7);
        System.out.println("After add 7 at the head, the list becomes " + idlList.toString() + "\n");

        // add element 10 at index 1
        idlList.add(1,10);
        System.out.println("After add 10 at index 1, the list becomes " + idlList.toString() + "\n");


        // append element 44 at the end of the list
        idlList.append(44);
        System.out.println("After append, the list is : " + idlList.toString() + "\n");

        // returns the object at position index 1 from the head
        System.out.println("Current list is: " + idlList.toString());
        System.out.println("Get element of position 1 in list : " + idlList.get(1) + "\n");

        // return the object at the head
        System.out.println("Current list is: " + idlList.toString());
        System.out.println("Get head object in list: " + idlList.getHead() + "\n");

        // return the object at the tail
        System.out.println("Current list is: " + idlList.toString());
        System.out.println("Get tail object in list: " + idlList.getLast() + "\n");

        // return the list size
        System.out.println("The current list size is: " + idlList.size() + "\n");

        // remove and return element at the head
        System.out.println("Now the list is: " + idlList.toString());
        System.out.println("The removed head element is: " + idlList.remove());
        System.out.println("After remove, the current list is: " + idlList.toString() + "\n");

        // remove and return the element at the tail
        System.out.println("Now the list is: " + idlList.toString());
        System.out.println("The removed tail element is: " + idlList.removeLast());
        System.out.println("After remove, the current list is: " + idlList.toString() + "\n");

        // add two elements 35
        idlList.append(35);
        idlList.add(2, 35);
        System.out.println("Now the list is: " + idlList.toString());

        // remove the first occurrence of 35
        idlList.remove(35);
        System.out.println("After removed the first occurrence of 35, now the list is: "
                + idlList.toString());

	}

}

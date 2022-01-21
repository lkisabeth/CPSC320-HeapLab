import java.util.ArrayList;
import java.util.Scanner;

public class HeapSort {
    ArrayList<Integer> makeTree(Scanner input) {
        // Create an ArrayList from the input
        ArrayList<Integer> binaryTree = new ArrayList<>();
        while (input.hasNext()) {
            if (input.hasNextInt()) {
                binaryTree.add(input.nextInt());
            } else {
                input.next();
            }
        }

        // Since this is just a binary tree, not a binary search tree or something else, it does not need to be sorted yet.
        // Return the complete binary tree
        return binaryTree;
    }

    void makeHeap(ArrayList<Integer> binaryTree, int n) {
        // Assume n (the root) is the largest element in the ArrayList (even though it doesn't need to be at this point)
        int largest = n;
        int left = (n * 2) + 1;
        int right = (n * 2) + 2;

        // If the left child is within the bounds of the array and is greater than the current largest element, update the largest element index
        if (left < binaryTree.size() && binaryTree.get(left) > binaryTree.get(largest)) largest = left;

        // Do the same for the right child
        if (right < binaryTree.size() && binaryTree.get(right) > binaryTree.get(largest)) largest = right;

        if (largest != n) {
            int temp = binaryTree.get(n);
            binaryTree.set(n, binaryTree.get(largest));
            binaryTree.set(largest, temp);

            // run makeHeap again on this child node
            makeHeap(binaryTree, largest);
        }
    }

    ArrayList<Integer> heapSort(ArrayList<Integer> heap) {
        // Create a new ArrayList to store the sorted list
        ArrayList<Integer> sortedList = new ArrayList<>();

        // Sorted list should be largest to smallest.
        // While the heap isn't empty, remove the largest element and add it to the sorted list
        while (!heap.isEmpty()) {
            // Remove the root element
            int root = heap.get(0);
            heap.remove(0);

            // Add it to the sorted list
            sortedList.add(root);

            // Make it a heap again
            makeHeap(heap, 0);
        }

        // Return the sorted list
        return sortedList;
    }
}

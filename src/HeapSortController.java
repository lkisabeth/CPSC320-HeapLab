import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HeapSortController {
    public void go() {
        // Use JFileChooser to select a file that contains a list of integers
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        Scanner input = null;
        try {
           input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        // Make a binary tree from that list
        HeapSort methods = new HeapSort();
        ArrayList<Integer> binaryTree = methods.makeTree(input);

        // Print the tree (mainly for debugging)
        HeapSortView view = new HeapSortView();
        view.printList("Tree: ", binaryTree);

        // Make the tree a heap
        for (int i = binaryTree.size()/2 - 1; i >= 0; i--) methods.makeHeap(binaryTree, i);

        // Print the heap (mainly for debugging)
        view.printList("Heap: ", binaryTree);

        // Heap Sort the tree (largest to smallest)
        ArrayList<Integer> sortedList = methods.heapSort(binaryTree);

        // Print out the sorted list
        view.printList("Sorted List: ",sortedList);
    }
}

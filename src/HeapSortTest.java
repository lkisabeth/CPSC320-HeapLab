import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Scanner;

class HeapSortTest {
    @Test
    void makeTreeTest() {
        Scanner input = new Scanner("22 31 45 66 77 82 11");
        HeapSort methods = new HeapSort();
        ArrayList<Integer> binaryTree = methods.makeTree(input);
        assertEquals(binaryTree.size(), 7);
        assertEquals(binaryTree.get(0), 22);
        assertEquals(binaryTree.get(1), 31);
        assertEquals(binaryTree.get(2), 45);
        assertEquals(binaryTree.get(3), 66);
        assertEquals(binaryTree.get(4), 77);
        assertEquals(binaryTree.get(5), 82);
        assertEquals(binaryTree.get(6), 11);
    }

    @Test
    void makeHeapTest() {
        Scanner input = new Scanner("22 31 45 66 77 82 11");
        HeapSort methods = new HeapSort();
        ArrayList<Integer> binaryTree = methods.makeTree(input);
        for (int i = binaryTree.size()/2 - 1; i >= 0; i--) methods.makeHeap(binaryTree, i);
        // Should be [82, 77, 45, 66, 31, 22, 11]
        assertEquals(binaryTree.get(0), 82);
        assertEquals(binaryTree.get(1), 77);
        assertEquals(binaryTree.get(2), 45);
        assertEquals(binaryTree.get(3), 66);
        assertEquals(binaryTree.get(4), 31);
        assertEquals(binaryTree.get(5), 22);
        assertEquals(binaryTree.get(6), 11);
    }

    @Test
    void heapSortTest() {
        HeapSort methods = new HeapSort();
        ArrayList<Integer> heap = new ArrayList<>();
        heap.add(0, 82);
        heap.add(1, 66);
        heap.add(2, 77);
        heap.add(3, 31);
        heap.add(4, 45);
        heap.add(5, 11);
        heap.add(6, 22);
        ArrayList<Integer> sortedList = methods.heapSort(heap);
        // Should be [82, 77, 66, 45, 31, 22, 11]
        assertEquals(sortedList.get(0), 82);
        assertEquals(sortedList.get(1), 77);
        assertEquals(sortedList.get(2), 66);
        assertEquals(sortedList.get(3), 45);
        assertEquals(sortedList.get(4), 31);
        assertEquals(sortedList.get(5), 22);
        assertEquals(sortedList.get(6), 11);
    }
}
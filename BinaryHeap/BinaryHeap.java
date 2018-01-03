package BinaryHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BinaryHeap {
	
	private static final int d = 2;
	private int[] heap;
	private int heapSize;
	
	BinaryHeap(int pCapacity) {
		heapSize = 0;
		heap = new int[pCapacity+1];
		Arrays.fill(heap, -1);
	}
	
	/**
	 * Check is empty.
	 * @return
	 */
	public boolean isEmpty() {
		return this.heapSize <= 0 ? true : false;
	}
	
	/**
	 * Check isfull
	 * @return
	 */
	public boolean isFull() {
		return this.getHeapSize() == this.heap.length;
	}
	
	public void makeEmpty() {
		this.heapSize = 0;
	}
	
	private int parent(int i) {
		return (i-1)/d;
	}
	
	private int kthChild(int i, int k) {
		return (i*d)+k;
	}
	
	public int deleteMAX() {
		int item = this.heap[0];
		System.out.println("deleted : "+ item);
		heap[0] = heap[this.heapSize-1];
		heapSize--;
		
		heapify(0);
		//delete(0);
		return item;
	}
	
	
	public void insert(int x) {
		if(this.isFull()) {
			throw new NoSuchElementException("Overflow exception");
		}
		
		heap[this.heapSize++]  = x;
		hepifyUp(heapSize-1);
	}
	
	private void hepifyUp(int childInd) {
		int tmp = heap[childInd];
		
		while(childInd > 0 && tmp > heap[this.parent(childInd)])  {
			heap[childInd] = heap[parent(childInd)];
			childInd = parent(childInd);
		}
		
		heap[childInd] = tmp;
	}
	
	
	private void heapify(int ind) {
		
		int tmp = heap[ind];
		int t2;
		while(ind < this.heapSize) {
			if(this.kthChild(ind, 1) >= this.heapSize || this.kthChild(ind, 2) >= this.heapSize) {
				break;
			}
			int val = this.findMax(this.kthChild(ind, 1), this.kthChild(ind, 2));
			if(heap[ind] < heap[val]) {
				t2 = heap[ind];
				heap[ind] = heap[val];
				heap[val] = t2;
			}
			ind = val;
		}
		heap[ind] = tmp;
	}
	
	private int findMax(int i, int j) {
		return heap[i] < heap[j] ? j : i;
	}
		
	/**
	 * @return the heapSize
	 */
	public int getHeapSize() {
		return heapSize;
	}


	/**
	 * @param heapSize the heapSize to set
	 */
	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}

	public int getMax() {
		if(!this.isEmpty()) {
			return this.heap[0];
		}else {
			return 0;
		}
	}
	
	/**
	 * Method to find the min element in MAX HEAP.
	 * 
	 * @return
	 */
	public int findMin() {
		
		// list to store all leaf elements.
		List<Integer> lst = new ArrayList<>();
		
		for(int i = 0; i < this.heapSize; i++) {
			
			//Collecting all leaf nodes.
			if(kthChild(i, 1) > this.heapSize-1 || kthChild(i, 2) > this.heapSize-1) {
				lst.add(heap[i]);
			}
		}
		
		/* Sorting all the left element to find the min
		  as the leaf will only contain the min element in MAX HEAP.
		*/
		
		//Minimum in leaf elements.
		return Collections.min(lst);
	}
	
	
	public void printHeap() {
		System.out.println("\n Heap");
		for(int i = 0; i < this.heapSize; i++) {
			System.out.println(heap[i] + " ");
		}
		
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        System.out.println("Binary Heap Test\n\n");
        System.out.println("Enter size of Binary heap");
        /** Make object of BinaryHeap **/
        BinaryHeap bh = new BinaryHeap(scan.nextInt() );
        bh.insert(9);
        bh.insert(8);
        bh.insert(31);
        bh.insert(14);
        bh.insert(12);
        bh.insert(10);
        char ch;
        /**  Perform Binary Heap operations  **/
        do    
        {
            System.out.println("\nBinary Heap Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete min");
            System.out.println("3. check full");            
            System.out.println("4. check empty");
            System.out.println("5. clear");
            System.out.println("6. Find min");
            
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                try
                {
                    System.out.println("Enter integer element to insert");
                    bh.insert( scan.nextInt() ); 
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage() );
                }
                break;                          
            case 2 : 
                try
                {
                    System.out.println("Min Element : "+ bh.deleteMAX()); 
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage() );
                }                 
                break;                                
            case 3 : 
                System.out.println("Full status = "+ bh.isFull());
                break;                                   
            case 4 : 
                System.out.println("Empty status = "+ bh.isEmpty());
                break; 
            case 5 : 
                bh.makeEmpty();
                System.out.println("Heap Cleared\n");
                break;   
            case 6 :
            	System.out.println("Min value in max heap is = :"+bh.findMin());
            	break;
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /** Display heap **/
            bh.printHeap();  
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');
        
        if(ch == 'n' || ch == 'N') {
        	System.exit(0);
        }
    }
}

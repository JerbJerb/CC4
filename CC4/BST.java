import java.util.Scanner;
import java.util.Arrays;

/**
 * CC4 Data Structures
 * Laboratory Number 8
 *
 */
public class bst2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		tree tree = new tree();

		int total;
		int nums[];

		System.out.print("Enter number of integers to input:  ");
		total = sc.nextInt();
		nums = new int[total];

		for (int i = 0; i < total; i++) {
			System.out.print("Number " + (i + 1) + ": ");
			nums[i] = sc.nextInt();
			tree.bst[0] = Integer.toString(nums[0]);

			if (i > 0) {
				tree.add(nums[i]);
			}
		}

		System.out.println("\nARRAY REPRESENTATION OF THE BST");
		tree.print();

		int dec;
		for (;;) {
			System.out.print("\nInsert[0]" + "\nDelete[1]" + "\nExit[2]" + "\nPick one: ");
			dec = sc.nextInt();

			if (dec == 0) {
				System.out.print("Enter number to be inserted: ");
				int num = sc.nextInt();
				tree.add(num);
				tree.print();
			} else if (dec == 1) {
				System.out.print("Enter number to be deleted: ");
				int num = sc.nextInt();
				tree.delete(num);
				tree.print();
			} else {
				System.exit(0);
			}
		}

	}
	// index always starts at 0
	// static String[] delete(int number, String[] prevArr, int index){

	// }

}

/**
 * Is a class that models a binary search tree which uses arrays as its data structure
 *
 */
class tree {
	String[] bst;
	int height;

	/**
	 * Default constructor of tree that initializes the bst array to have 1 element
	 * and a height of zero.
	 */
	tree() {
		bst = new String[1];
		height = 0;
	}

	/**
	 * Prints the elements of the tree in an array form. It uses the toString() method
	 * from the built-in class, Arrays.
	 */
	void print() {
		System.out.println(Arrays.toString(bst));
	}

	/**
	 * This method solves for the right amount of nodes in the tree.
	 * It uses the formula 2^(Height+1)-1 and makes it the size of the new array.
	 * Since you can't change the size of an array, this method creates a new array
	 * and transfers all the elements from the old array to the new array that has
	 * the right size. 
	 * 
	 * It then returns the new tree with the right size.
	 * @param treee A string array that represents a tree.
	 * @return A new array that has the right size depending on the height of the tree.
	 */
	String[] addNulls(String[] treee) {
		//initializes a new array with a size according to the formula of the maximum number nodes of a tree.
		String[] newTree = new String[(int) Math.pow(2, height + 1) - 1]; 
		
		//Transfers the elements from the old array to the new array.
		int length = treee.length >= newTree.length ? newTree.length : treee.length;
		for (int i = 0; i < length; i++)
			newTree[i] = treee[i];
		
		return newTree;
	}

	/**
	 * This method solves for the height of the tree. In solving the height, it first
	 * gets the element/node that is in the very bottom of the tree (The last number in the array).
	 * After getting the value of the node that is in the very bottom, we traverse it to the tree
	 * until we find the element/node with the value and every time we traverse to a child, a counter increments
	 * since we a moving a level down. 
	 * 
	 * After traversing, the method returns the counter.
	 * @param treee String array that represents a tree.
	 * @return Height of the tree.
	 */
	int getHeight(String[] treee) {
		//Solves for the farthest node/element in the tree/array.
		int farthest = Integer.parseInt(treee[0]);
		for (int i = treee.length - 1; i >= 0; i--) {
			if (treee[i] != null) {
				farthest = Integer.parseInt(treee[i]);
				break;
			}
		}
		//Traversing the farthest node/element in the tree/array.
		int counter = 0;
		for (int j = 0; j < treee.length;) {
			if (treee[j] != null) {
				if (farthest == Integer.parseInt(treee[j])) {
					break;
				}
				if (farthest > Integer.parseInt(treee[j])) {
					j = j * 2 + 2;
					counter++;
				} else {
					j = j * 2 + 1;
					counter++;
				}
			}
		}
		return counter;
	}

	/**
	 * This method is for the insertion of a number in the tree. This method firstly
	 * solves for the position of the number to be inserted in the tree. To solve for the position,
	 * it traverses the number to be inserted to the tree starting from the root 
	 * and compares it to the root. If the number is larger than the root, index increases by 
	 * 2i+2(right child of root) where i is the index of the root
	 * and if number is less than the root, index increases by 2i+1(left child of the root) then
	 * compares it again to the value of the child and increases the index again and again until
	 * we find an empty(null) spot in the tree and keep track of the index. The index is the
	 * position of the array.
	 * 
	 * If the position/index of the number is larger than the array size, a new array with a
	 * larger size will be created and transfers the elements from the old array to the new
	 * array including the number that is to be inserted.
	 * 
	 * If the position/index of the number is less than the array size, just put the number
	 * in the array with the right position/index.
	 * @param number Number to be inserted.
	 */
	void add(int number) {
		String[] newArr;
		int size = bst.length;
		int position = 0;

		//Loops through the array up to it's length starting from the root.
		for (int j = 0; j < bst.length;) {
			//If we find a null element, this will be the position of the number to be inserted.
			if (bst[j] == null) {
				position = j;
				break;
			} else {
				//If number is greater than the element in the array, it goes to the right child of the element/node.
				//Else, it goes to the left child.
				if (number > Integer.parseInt(bst[j])) {
					//Changing the index to the right child.
					j = j * 2 + 2;
					//If the value of j is now greater than the size of the array, it now sets j+1 as the value of size
					//to be put in the new array.
					if (j > bst.length - 1) {
						size = j + 1;
						height++;
					}
				} else {
					//Changing the index to the left child.
					j = j * 2 + 1;
					//If the value of j is now greater than the size of the array, it now sets j+1 as the value of size
					//to be put in the new array.
					if (j > bst.length - 1) {
						size = j + 1;
						height++;
					}
				}
			}
		}
		if(size == bst.length){
			bst[position] = Integer.toString(number);
		}else{
			newArr = new String[size];
			for (int i = 0; i < bst.length; i++) {
				newArr[i] = bst[i];
			}
			newArr[size - 1] = Integer.toString(number);
			bst = addNulls(newArr);
		}
	}
	
	/**
	 * This method deletes a number in the tree/array.
	 * 
	 * Before the deletion of the number, it first looks through the tree
	 * if the number exist. It returns "Number to be deleted is not found." 
	 * if number doesn't exist. If number exist, it keeps track of the
	 * index and then uses the deleteRec(index) method to remove the number
	 * and properly do the adjustments with its children. 
	 * 
	 * After removing the number, it uses the addNulls() method to adjust
	 * the array for it to have the right size.
	 * @param num Number to be deleted from the tree.
	 */
	void delete(int num) {
		int index = 0;
		if (bst[index] == null) {
			System.out.println("Number to be deleted is not found.");
			return;
		}
		while (num != Integer.parseInt(bst[index])) {
			if (num > Integer.parseInt(bst[index])) {
				index = index * 2 + 2;
			} else if (num < Integer.parseInt(bst[index])) {
				index = index * 2 + 1;
			}

			if (index >= bst.length) {
				System.out.println("Number to be deleted is not found.");
				return;
			}
		}
		deleteRec(index);
		if (index == 0 && bst.length == 1) {
			bst[0] = null;
		} else {
			height = getHeight(bst);
			bst = addNulls(bst);
		}

	}

	/**
	 * Removes the number in the array given it's index and adjusts its children
	 * to their right positions if ever it has children.
	 * @param index Index of the number to be deleted.
	 */
	void deleteRec(int index) {
		if ((index * 2 + 1) >= bst.length) {
			bst[index] = null;
			return;
		}

		if (bst[index * 2 + 1] == null) {
			bst[index] = bst[index * 2 + 2];
			follow(index, index * 2 + 2);
			return;
		} else if (bst[index * 2 + 2] == null) {
			bst[index] = bst[index * 2 + 1];
			bst[index * 2 + 1] = null;
			follow(index, index * 2 + 1);
			return;
		} else {
			bst[index] = bst[maxLeft(index * 2 + 1)];
			deleteRec(maxLeft(index * 2 + 1));
		}

	}
	void follow(int curr, int prev) {
		if (prev * 2 + 2 < bst.length) {
			// left
			bst[curr * 2 + 1] = bst[prev * 2 + 1];
			follow(curr * 2 + 1, prev * 2 + 1);

			// right
			bst[curr * 2 + 2] = bst[prev * 2 + 2];
			follow(curr * 2 + 2, prev * 2 + 2);
		}
	}

	int maxLeft(int index) {
		int max = index;
		if ((index * 2 + 2) < bst.length) {
			while (bst[index * 2 + 2] != null) {
				index = index * 2 + 2;
				max = index;
				if ((index * 2 + 2) >= bst.length) {
					break;
				}
			}
		}
		return max;
	}
}
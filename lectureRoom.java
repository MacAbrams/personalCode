import java.util.*;

class lectureRooms{



	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in).useDelimiter("\n");
		MergeSort sort = new MergeSort();
		ArrayList<String> input = new ArrayList<String>();
		//takes all user inputs
		System.out.print("\033[2JEnter a time range of two Integers seperated by a comma:\n\033[S5");

		while(true){
			System.out.print("\033[5BQ to Exit");
			System.out.print("\033[5A");
			String in = scan.nextLine();
			in.toLowerCase();
			int exit = in.indexOf("q");
			if(exit!=-1){
				break;
			}
			input.add(in);
			System.out.print("\033[4B\033[2K");
			//scroll accidentally down
			System.out.print("\033[S");

		}

		Iterator<String> it = input.iterator();
		int[][] nums = new int[input.size()][3];
		// extracting numbers
		int i = 0;
		while(it.hasNext()){
			String temp = it.next();
			Scanner sc = new Scanner(temp).useDelimiter(",");

			nums[i][0] = Integer.valueOf(sc.next());
			nums[i][1] = Integer.valueOf(sc.next());
			nums[i][2] = nums[i][1]-nums[i][0];

			i++;
		}


		int rooms = 0;
		for(int h = 0;h<i;h++){
			int tempRooms = 0;
			for(int g = 0;g<i;g++){


				if(nums[h][1]>=nums[g][0] && nums[h][0]<=nums[g][1]){
					tempRooms++;
				}

			}
			if(tempRooms>rooms){
				rooms=tempRooms;
			}
		}

		//sorting
		// sort.printArray(nums);
		// sort.sort(nums,0,i-1);
		// sort.printArray(nums);
		System.out.println("\nRooms needed: "+rooms);
	}


} 


/* Java program for Merge Sort */
class MergeSort 
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[][], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        int L[][] = new int[n1][2];
        int R[][] = new int[n2][2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
        	for(int h = 0; h<2;h++)
            	L[i][h] = arr[l + i][h];
        for (int j = 0; j < n2; ++j)
        	for(int g = 0; g<2;g++)
            	R[j][g] = arr[m + 1 + j][g];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i][0] <= R[j][0]) {
        		for(int h = 0; h<2;h++)
                	arr[k][h] = L[i][h];
            	i++;
            }
            else {
            	for(int g = 0; g<2;g++)
                	arr[k][g] = R[j][g];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
        	for(int h = 0; h<2;h++)
				arr[k][h] = L[i][h];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
        	for(int g = 0; g<2;g++)
				arr[k][g] = R[j][g];
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[][], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
  
    /* A utility function to print array of size n */
    static void printArray(int arr[][])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i){
        	System.out.print("(");
        	for(int h=0;h<2;h++)
            	System.out.print(arr[i][h] + " ");
            System.out.print("),");
        }
        System.out.println();
    }
  

}
/* This code is contributed by Rajat Mishra */
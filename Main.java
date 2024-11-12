import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);

      System.out.println("\n\nBubble sort results ----------------------------------------------");
      long startTime = System.nanoTime();
      ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
      long endTime = System.nanoTime();
      Lab4.outputList(bubbleSortedList);
      System.out.println("\nBubble Sort Time: " + (endTime - startTime));

      System.out.println("\n\nInsertion sort results -------------------------------------------");
      startTime = System.nanoTime();
      ArrayList<Integer> insertionSortedList = Lab4.insertionSort(integerList);
      endTime = System.nanoTime();
      Lab4.outputList(insertionSortedList);
      System.out.println("\nInsertion Sort Time: " + (endTime - startTime));
    }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implement insertion sort algorithm here
    for(int i = 1; i < integerList.size(); i++)
    {
      int currentValue = integerList.get(i);

      int k;
      for(k = i -1; k >= 0 && integerList.get(k) < currentValue; k--)
      {
        integerList.set(k+1, integerList.get(k));
      }
      integerList.set(k+1, currentValue);

    }

    return integerList;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) 
  {
    // Step 2 - Implement the bubble sort algorithm here
    boolean loop = true;
    for(int k = 1; k < integerList.size() && loop; k++)
    {
      loop = false;

      for(int i = 0; i < integerList.size() - k; i++)
      {
        if(integerList.get(i) > integerList.get(i+1))
        {
            int temp = integerList.get(i);
            integerList.set(i, integerList.get(i+1));
            integerList.set(i+1, temp);
            loop = true;
        }

      }
    }
    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
        while ((line = br.readLine()) != null) {
            integerList.add(Integer.parseInt(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
        System.out.print(integerList.get(i) + " ");
    }
  }
}

/* 
1. If I was implementing a sort algorithm in a new language with the intent to minimize exection time, I would pick insertion sort based on
   the fact that it seems to run faster than bubble sort. If I was focused on making it easier for myself to understand, I would choose bubble sort (see question 3).

2. Bubble sort took roughly twice as long as insertion sort. Although they have the same time complexities, it makes sense that bubble sort
   takes longer because it requires more swaps and more comparisons than insertion sort. Insertion sort also has a best-case scenario of O(n),
   which bubble sort does not have.

3. Bubble sort is the easier algorithm for me to understand. Insertion sort seems to be harder because not only do you have to walk through the array
   forwards, but you also have to walk through it backwards making comparisons. Bubble sort, you just walk forward through the array, albeit many times.
*/
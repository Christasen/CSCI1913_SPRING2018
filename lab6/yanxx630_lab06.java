//binary search
//Guangyu yanxx630


class BinaryVsLinear
{
  private static int linearSearch(int key, int [] array)
  {
      int n = array.length;
      for (int i = 0; i < n; i++)
      {
          // Return the index of the element if the element
          // is found
          if (array[i] == key)
              return i;
      }
      // return -1 if the element is not found
      return array.length;

  }

    private static int binarySearch(int key, int [] array)
    {
     int low = 0;
     int high = array.length- 1;
     int count = 0;

     while(high >= low) {
         int middle = (low + high) / 2;
         if(array[middle] == key){
            count += 1;
             break;
           }
         else if(array[middle] < key){
             low = middle + 1;
             count += 2;
           }
         else{
             high = middle - 1;
             count += 2;
           }
        }
    return count;
    }

    public static void main(String [] args)
    {
      for (int length = 1; length <= 30; length += 1)
      {
        int[] array = new int[length];
        for (int index = 0; index < length; index += 1)
        {
          array[index] = index;
        }

        double linearTotal = 0.0;
        double binaryTotal = 0.0;
        for (int element = 0; element < length; element += 1)
        {
          linearTotal += linearSearch(element, array);
          binaryTotal += binarySearch(element, array);
        }

        double linearAverage = linearTotal / length;
        double binaryAverage = binaryTotal / length;
        System.out.println(length + "\t" + linearAverage + "\t" + binaryAverage);
      }
    }
}

//output
// 1	0.0	1.0
// 2	0.5	2.0
// 3	1.0	2.3333333333333335
// 4	1.5	3.0
// 5	2.0	3.4
// 6	2.5	3.6666666666666665
// 7	3.0	3.857142857142857
// 8	3.5	4.25
// 9	4.0	4.555555555555555
// 10	4.5	4.8
// 11	5.0	5.0
// 12	5.5	5.166666666666667
// 13	6.0	5.3076923076923075
// 14	6.5	5.428571428571429
// 15	7.0	5.533333333333333
// 16	7.5	5.75
// 17	8.0	5.9411764705882355
// 18	8.5	6.111111111111111
// 19	9.0	6.2631578947368425
// 20	9.5	6.4
// 21	10.0	6.523809523809524
// 22	10.5	6.636363636363637
// 23	11.0	6.739130434782608
// 24	11.5	6.833333333333333
// 25	12.0	6.92
// 26	12.5	7.0
// 27	13.0	7.074074074074074
// 28	13.5	7.142857142857143
// 29	14.0	7.206896551724138
// 30	14.5	7.266666666666667


//A short written answer to this question: Based on your graph, for what array sizes is linear search more efficient than binary search? (5 points).
//From the graph, it is obvious that from size 0-5,linear search is more efficiene than binary search

//A short written answer to this question: Based on your graph, for what array sizes is binary search more efficient than linear search? (5 points).
//From the graph, it is obvious that for a sample size larger than 5,binary search is more efficiene than linear search

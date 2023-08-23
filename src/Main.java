import  java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        {
            int[] array = {1, 2, 3, 4};
            array = PushBack(array, 5); // push in array back

            array = RemoveElement(array, 2);

            cycleSwap(array);
            cycleSwap(array, 5);

            /*
            import  java.util.Arrays;

            Arrays.toString(array) — returning a string representation of an array.
            Arrays.deepToString(array) — returning a string representation of a multidimensional array.
            Arrays.copyOf(array, length) — copying an array with a specific length.
            Arrays.equals(array1, array2) — comparing arrays.
            Arrays.deepEquals(array1, array2) — comparing multidimensional arrays.
            Arrays.sort(array) — sorting the elements of a specific array into ascending numerical order.
            Arrays.binarySearch(array, element) — searching a specific array for the element value and returning its index if the element is found.
            Arrays.fill(array, element) — filling array elements with the value element.
             */

            System.out.println(Arrays.toString(array)); // Print array
        }

        {
            int[][] matrix = { {1, 2, 3},
                                {3, 4, 5},
                                {6, 7, 8}};

            matrix = TransposeMirror(matrix);

            System.out.println(Arrays.deepToString(matrix).replace("],", "],\n" ));
        }
    }
    public static int[] RemoveElement(int[] arr, int index) {
        int[] result = new int[arr.length - 1];
        System.arraycopy(arr, 0, result, 0, index);
        if (arr.length != index) {
            System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
        }
        return result;
    }
    public static int[] PushBack(int[] arr, int element) {
        int[] result = new int[arr.length + 1];
        System.arraycopy(arr, 0, result, 0, arr.length);
        result[result.length-1] = element;
        return result;
    }
    static void cycleSwap(int[] array) {
        if(array.length == 0) return;

        int[] modified_array = new int[array.length];

        System.arraycopy(array, 0, modified_array, 1, array.length-1);
        modified_array[0] = array[array.length-1];

        System.arraycopy(modified_array, 0, array, 0, array.length);
    }
    static void cycleSwap(int[] array, int shift) {
        if(array.length == 0) return;

        int[] modified_array = new int[array.length];

        shift %= array.length;

        System.arraycopy(array, 0, modified_array, shift, array.length-shift);
        System.arraycopy(array, array.length-shift, modified_array, 0, shift);

        System.arraycopy(modified_array, 0, array, 0, array.length);
    }

    /////////////////////////////////////////////////////////////////////////
    public static int[][] TransposeMirror(int[][] matrix) {
        final int rows = matrix.length;
        final int col = matrix[0].length;

        int[][] new_matrix = new int[col][rows];

        for(int y = 0;y < rows;y++) {
            for(int x = 0;x < col;x++){
                new_matrix[x][y] = matrix[y][x];
            }
        }

        return new_matrix;
    }

}
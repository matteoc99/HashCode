package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Arrays;
import java.io.FileWriter;
import java.util.Arrays;

/**
 * @author Matteo Cosi
 * @since 01.03.2018
 */
public class CodeUtils {
    public static void hello() {
        System.out.println("hi");
    }

    public static String readInString(String file){
        String ret = "";
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            ret = sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }

    public static char[][] readInArray(String file){
        char[][] ret = null;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();

            int lines = Integer.parseInt(line.substring(0, 1));
            int zeichn = Integer.parseInt(line.substring(2, 3));
            int zusatz1 = Integer.parseInt(line.substring(4, 5));
            int zusatz2 = Integer.parseInt(line.substring(6, 7));

            ret = new char[lines][zeichn];
            int i = 0;
            line = br.readLine();
            while (line != null) {
                for (int j = 0; j < zeichn; j++){
                    char c = line.charAt(j);
                    ret[i][j] = c;
                }
                i++;
                System.out.println("\n");
                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return (ret != null)? ret : null;
    }

    public static void writeArray(char[][] data, String filename){
        String name = System.getProperty("user.dir") + "/src/files/"+filename;
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(name))){
            for(int i = 0; i < data.length; i++){
                bw.write(Arrays.toString(data[i])+"\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * quicksort
     * @param arr the array
     * @param low 0
     * @param high arr.length -1
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }

}

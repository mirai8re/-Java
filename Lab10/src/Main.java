//Миронова Анна, 8 группа
import java.lang.*;
import java.util.*;
import java.util.concurrent.Exchanger;

class SortThread implements Runnable{

    Exchanger<ArrayList<Integer>> exArray;
    Exchanger<Integer> exOrder;
    ArrayList<Integer> array;
    Integer order;

    SortThread(Exchanger<ArrayList<Integer>> exArray, Exchanger<Integer> exOrder){
        this.exArray = exArray;
        this.exOrder = exOrder;
    }

    public void run(){
        System.out.println("Sort started...");
        try{
            array = exArray.exchange(array);
            order = exOrder.exchange(order);
            if(order == 1) {
                Collections.sort(array);
            }
            else {
                Collections.sort(array, Collections.reverseOrder());
            }
            exArray.exchange(array);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Sort finised...");
    }

}

class MainThread implements Runnable{

    Exchanger<ArrayList<Integer>> exArray;
    Exchanger<Integer> exOrder;

    MainThread(Exchanger<ArrayList<Integer>> exArray, Exchanger<Integer> exOrder){
        this.exArray = exArray;
        this.exOrder = exOrder;
    }

    public static int arraySize() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input array size: ");
        int size = in.nextInt();
        return size;
    }

    public static ArrayList<Integer> createArray(int size) {
        Random random = new Random();
        ArrayList<Integer> array = new ArrayList<Integer>(size);
        for(int i = 1; i <= size; i++) {
            array.add(random.nextInt(size) + 1);
        }
        return array;
    }

    public static void printInfo(ArrayList<Integer> array) {
        System.out.println("Size: " + array.size() + "; Array: " + array);
    }

    public static int askOrder() {
        System.out.println("Sort order. 1 if in ascending order, else 0");
        Scanner sc = new Scanner(System.in);
        Integer result = sc.nextInt();
        return result;
    }

    public void run(){
        System.out.println("Main started...");
        int size = arraySize();
        ArrayList<Integer> array = createArray(size);
        printInfo(array);
        try{
            exArray.exchange(array);
            exOrder.exchange(askOrder());
            array = exArray.exchange(array);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(array);
        System.out.println("Main finised...");
    }

}

public class Main {



    public static void main(String[] args) {

        Exchanger<ArrayList<Integer>> exArray = new Exchanger<>();
        Exchanger<Integer> exOrder = new Exchanger<>();
        new Thread(new MainThread(exArray, exOrder)).start();
        new Thread(new SortThread(exArray, exOrder)).start();
    }
}



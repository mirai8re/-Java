//Миронова Анна
//В данной действительной квадратной матрице порядка n найти max по модулю элемент.
//Получить квадратную  матрицу  порядка n-1 путем  выбрасывания из исходной какой-либо строки и столбца,
//на пересечении которых расположен элемент с найденным значением.
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task35 {
    private static Integer numb;
    private static ArrayList<ArrayList<Integer>> matr;

    //Заполнение матрицы
    public static void create_matr(ArrayList<ArrayList<Integer>> matr){
        Random number = new Random();
        for(int i = 0; i < numb.intValue(); i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < numb.intValue(); j++) {
                temp.add(number.nextInt() % 100);
            }
            matr.add(temp);
        }
    }

    //Вывод матрицы
    public static void print(ArrayList<ArrayList<Integer>> matr){
        System.out.println("Matrix:");
        for(int i = 0; i < numb.intValue(); i++){
            for (int j = 0; j < numb.intValue(); j++) {

                System.out.print(matr.get(i).get(j) + " ");
            }
            System.out.print('\n');
        }
    }

    //поиск максимального элемента и создание новой матрицы
    public static ArrayList<ArrayList<Integer>> change_matr(ArrayList<ArrayList<Integer>> matr) {
        Integer max = Math.abs(matr.get(0).get(0)), maxI = 0, maxJ = 0;
        //поиск элемента и запоминание его позиции
        for (int i = 0; i < numb.intValue(); i++)
            for (int j = 0; j < numb.intValue(); j++)
                if (max < Math.abs(matr.get(i).get(j))) {
                    max = matr.get(i).get(j);
                    maxI = i;
                    maxJ = j;
                }
        //создание новой матрицы n-1 порядка
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numb.intValue(); i++) {
            if(i == maxI.intValue()) continue;
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int j = 0; j < numb.intValue(); j++) {
                if(j == maxJ.intValue()) continue;
                tmp.add(matr.get(i).get(j));
            }
            temp.add(tmp);
        }
        numb--;
        return(temp);
    }

    public static void main(String[] args) {
        System.out.println("Enter matrix size: ");
        Scanner sc = new Scanner(System.in);
        String numbS = sc.next();
        numb = Integer.parseInt(numbS);
        if(numb > 0) {
            matr = new ArrayList<ArrayList<Integer>>();
            create_matr(matr);
            print(matr);
            matr = change_matr(matr);
            print(matr);
        }
        else
            System.out.println("Wrong matrix size!");
    }
}

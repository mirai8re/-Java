// Миронова Анна
//Элемент матрицы называется локальным минимумом, если он строго меньше всех имеющихся у него соседей.
//Соседями элемента ajj в матрице назовем элементы aki  с i-1<=k<=i+1, j-1<=l<=j+1,(k,l)(i,j).
//Подсчитать количество локальных минимумов заданной матрицы.
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Task21 {

    private static Integer numb;
    private static Vector<Vector<Integer>> matr;

    //Заполнение матрицы
    public static void create_matr(Vector<Vector<Integer>> matr){
        Random number = new Random();
        for(int i = 0; i < numb.intValue(); i++) {
            Vector<Integer> temp = new Vector<Integer>();
            for (int j = 0; j < numb.intValue(); j++) {
                temp.add(number.nextInt() % 100);
            }
            matr.add(temp);
        }
    }

    //Вывод матрицы
    public static void print(Vector<Vector<Integer>> matr){
        System.out.println("Matrix:");
        for(int i = 0; i < numb.intValue(); i++){
            for (int j = 0; j < numb.intValue(); j++) {
                System.out.print(matr.get(i).get(j) + " ");
            }
            System.out.print('\n');
        }
    }

    //Поиск локального минимума
    public static String search_loc_min(Vector<Vector<Integer>> matr) {
        int count = 0, temp_count = 0;
        int flag1 = 0, flag2 = 0, flag3 = 0, flag4 = 0;
        for (int i = 0; i < numb.intValue(); i++) {
            for (int j = 0; j < numb.intValue(); j++) {
                if(i - 1 >= 0) {//проверка выхода индекса соседа за пределы матрицы
                    flag1++;
                    if (matr.get(i - 1).get(j) > matr.get(i).get(j)) {//проверка меньше ли соседа
                        temp_count++;
                    }
                }
                if(i + 1 <= numb - 1) {
                    flag2++;
                    if (matr.get(i + 1).get(j) > matr.get(i).get(j)) {
                        temp_count++;
                    }
                }
                if(j - 1 >= 0) {
                    flag3++;
                    if (matr.get(i).get(j - 1) > matr.get(i).get(j)) {
                        temp_count++;
                    }
                }
                if(j + 1 <= numb - 1) {
                    flag4++;
                    if (matr.get(i).get(j + 1) > matr.get(i).get(j)) {
                        temp_count++;
                    }
                }
                if(flag1 + flag2 + flag3 + flag4 == temp_count)
                    count++;
                temp_count = 0;
                flag1 = 0;
                flag2 = 0;
                flag3 = 0;
                flag4 = 0;
            }
        }
        if(count > 0) return("I found " + count + " local minimum");
        else return("I didn't found local minimums :(");
    }

    public static void main(String[] args) {
        System.out.println("Enter matrix size: ");
        Scanner sc = new Scanner(System.in);
        String numbS = sc.next();
        numb = Integer.parseInt(numbS);
        if(numb > 0) {
            matr = new Vector<Vector<Integer>>();
            create_matr(matr);
            print(matr);
            System.out.println(search_loc_min(matr));
        }
        else
            System.out.println("Wrong matrix size!");
    }
}

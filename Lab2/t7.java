// Миронова Анна
//7.Найти максимальный среди всех элементов тех строк заданной матрицы,
//  которые упорядочены (либо по возрастанию, либо по убыванию).
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task7 {

    //заполнение матрицы рандомными значениями
    public static void create_matr(Integer matr[][]){
        Random numb = new Random();
        for(int i = 0; i < matr.length; i++)
            for (int j = 0; j < matr[i].length; j++) {
                matr[i][j] = numb.nextInt() % 100;
            }
    }

    //главная функция
    public static void main_procces(Integer matr[][]){
        Integer temp[] = new Integer[matr.length];
        int flag = 0;
        for(int i = 0; i < matr.length; i++){
            if (increase(matr[i])){
                temp[flag] = matr[i][matr[i].length - 1];
                flag++;
            }
            else if (decrease(matr[i])){
                temp[flag] = matr[i][0];
                flag++;
            }
        }
        Integer elem[] = new Integer[flag];
        for (int i = 0; i < flag; i++) {
            elem[i] = temp[i];
        }
        System.out.println(max_elem(elem));
    }

    //поиск максимального элемента из массива
    //максимальных элементов строговозрастающих
    //и строгоубывающих  строк
    public static String max_elem(Integer elem[]){
        if(elem.length > 0){
            Arrays.sort(elem);
            return ("Max element: " + elem[elem.length - 1].toString());
        }
        else
            return("Matrix have no increased or decreased strings :(");
    }

    //проверка строки на строгое возрастание
    public static boolean increase(Integer matr[]){
        int flag = 0;
        for (int i = 0; i < matr.length - 1; i++) {
            if(matr[i] < matr[i + 1])
                flag++;
            else
                break;
        }
        if(flag == matr.length - 1)
            return true;
        else
            return false;
    }

    //проверка строки на строгое убывание
    public static boolean decrease(Integer matr[]){
        int flag = 0;
        for (int i = 0; i < matr.length - 1; i++) {
            if(matr[i] > matr[i + 1])
                flag++;
            else
                break;
        }
        if(flag == matr.length - 1)
            return true;
        else
            return false;
    }

    //вывод матрицы
    public static void print(Integer matr[][]){
        System.out.println("Matrix:");
        for(int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter matrix size: ");
        Scanner sc = new Scanner(System.in);
        String numbS = sc.next();
        Integer numb = Integer.parseInt(numbS);
        if(numb > 0) {
            Integer matr[][] = new Integer[numb][numb];
            create_matr(matr);
            print(matr);
            main_procces(matr);
        }
        else
            System.out.println("Wrong matrix size!");
    }
}


//Миронова Анна 
//разложение cos в ряд Тейлора
import java.math.BigDecimal;
import java.util.Scanner;

public class Cos {
    //функция нахождения косинуса
    static double cosinus(double value, int scale){
            value %= 2 * Math.PI;
        double cosin = 1;
        double deg = 2;
        double factor = 1;
        double square = 1;
        double flag = 1;
        double sc = 1, scC = Math.pow(10, -scale);
        while(Math.abs(sc) > scC){
            factor = factor * deg * (deg - 1);
            square = square * value * value;
            deg += 2;
            flag *= -1;
            sc = square / factor * flag;
            cosin += sc;
        }
        BigDecimal res = new BigDecimal(cosin);
        cosin = res.setScale(scale, BigDecimal.ROUND_DOWN).doubleValue();
        return cosin;
    }

    public static void main(String[] args) {
        //считывание входных данных
        System.out.println("Введите значение для вычисления cos: ");
        Scanner sX = new Scanner(System.in);
        String valueS = sX.nextLine();
        double value = Double.parseDouble(valueS);
        System.out.println("Введите точность вычисления (количество знаков после запятой): ");
        Scanner sS = new Scanner(System.in);
        String scaleS = sX.nextLine();
        int scale = Integer.parseInt(scaleS);

        BigDecimal res = new BigDecimal(Math.cos(value));
        //Вывод
        System.out.println("Результат через программу: " + cosinus(value, scale) + "\n"
                         + "Результат через встроенную функцию: " + res.setScale(scale, BigDecimal.ROUND_DOWN).doubleValue());
    }
}

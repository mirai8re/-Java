//Миронова Анна разложение cos в ряд Тейлора c использованием BigDecimal и BigInteger
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class CosB {
    public static void main(String[] args) {
        //считывание входных данных
        System.out.println("Введите значение для вычисления cos: ");
        Scanner sX = new Scanner(System.in);
        String valueS = sX.nextLine();
        BigDecimal value = new BigDecimal(valueS);
        System.out.println("Введите точность вычисления (количество знаков после запятой): ");
        Scanner sS = new Scanner(System.in);
        String scaleS = sX.nextLine();
        //объявление и инициализация переменных
        BigInteger scale = new BigInteger(scaleS);
        BigDecimal pi = new BigDecimal(Math.PI * 2);
        BigDecimal res = new BigDecimal(Math.cos(value.doubleValue()));
        BigDecimal cosin = new BigDecimal(1);
        BigDecimal square = new BigDecimal(1);
        BigInteger deg = new BigInteger("2");
        BigInteger factor = new BigInteger("1");
        BigDecimal sc = new BigDecimal(1);
        BigDecimal scC = new BigDecimal(Math.pow(10, -scale.intValue()));
        Integer flag = new Integer(1);
        value = value.remainder(pi);
        //вычисление косинуса с помощью ряда тейлора
        while(sc.abs().compareTo(scC) > 0){
            factor = factor.multiply(deg.multiply(deg.subtract(new BigInteger("1"))));
            square = square.multiply(value.multiply(value));
            deg = deg.add(new BigInteger("2"));
            flag *= -1;
            sc = square.divide(new BigDecimal(factor.multiply(new BigInteger(flag.toString()))), BigDecimal.ROUND_CEILING);
            cosin = cosin.add(sc);
        }
        //вывод
        System.out.println("Результат через программу: " + cosin.setScale(scale.intValue(), BigDecimal.ROUND_CEILING) + "\n"
                + "Результат через встроенную функцию: " + res.setScale(scale.intValue(), BigDecimal.ROUND_CEILING));
    }
}

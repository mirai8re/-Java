// Миронова Анна
//Словом в строке считается последовательность букв латинского алфавита,
//остальные символы рассматриваются как разделители между словами.
//Слова в каждой из двух исходных строк упорядочены по алфавиту.
//Необходимо сформировать новую строку из всех слов исходных строк.
//Слова в новой строке должны быть также упорядочены по алфавиту.
//Прописные и строчные буквы в словах не различать. Слова в исходной
//строке разделяются некоторым множеством разделителей. Слова в новой
//строке должны разделяться ровно одним пробелом.
import java.util.Locale;
import java.util.Random;

public class Task7_1 {

    public static String random_str(int size){
        //заполнение строки size случайными символами
        String str = "";
        Random symbol = new Random();
        if(size > 0)
        for (int i = 0; i < size; i++) {
            Character smb = (char) (32 + Math.abs(symbol.nextInt()) % 221);
            str += smb.toString();
        }
        else
            System.out.println("Wrong string size :(");
        return str;
    }

    public static String[] sort_str(String[] str){
        //удаление из массива строк "пустых" элементов
        int length = str.length;
        for (int i = 0; i < length; i++) {
            if(str[i].compareTo("") == 0)
            if(i < length - 1)
                while(str[i].compareTo("") == 0 && i < length - 1) {
                    for (int j = i; j < length - 1; j++)
                        str[j] = str[j + 1];
                    length--;
                }
            if(str[i].compareTo("") == 0)
                if(i == length - 1)
                length--;
        }

        String[] result_str = new String[length];
        for (int i = 0; i < length; i++)
            result_str[i] = str[i];
        //сортировка массива строк без учёта регистра букв
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++)
                if(result_str[i].toLowerCase(Locale.ROOT).compareTo(result_str[j].toLowerCase(Locale.ROOT)) < 0) {
                    String temp = result_str[i];
                    result_str[i] = result_str[j];
                    result_str[j] = temp;
                }

        str = result_str;
        return str;
    }

    public static String toString(String[] str){
        //преобразование массива строк в одну строку
        String res = "";
        for (int i = 0; i < str.length; i++)
            res += str[i] + " ";
        return res;
    }

    public static void main(String[] args) {
        String split_pattern = "[ -№&&[^A-Za-zа-яА-я]]"; // паттерн регулярного выражения, который находит все символы кроме
                                                        // строчных и прописных букв английского и русского алфавитов
        String str1, str2;
        String[] str1_s, str2_s;

        str1 = random_str(10);
        str2 = random_str(10);

        System.out.println("Original lines: ");
        System.out.println(str1);
        System.out.println(str2);

        //разделение строки на подстроки, разделённые в строке любыми символами
        // кроме букв английского и русского алфавитов
        str1_s = str1.split(split_pattern);
        str2_s = str2.split(split_pattern);

        str1_s = sort_str(str1_s);
        str2_s = sort_str(str2_s);

        str1 = toString(str1_s);
        str2 = toString(str2_s);

        System.out.println("Sorted lines only with gaps: ");
        System.out.println(str1);
        System.out.println(str2);

        String str_con = str1 + str2;
        String[] str_con_s = str_con.split(" ");
        str_con_s = sort_str(str_con_s);
        str_con = toString(str_con_s);
        System.out.println("Result string");
        System.out.println(str_con);
    }
}

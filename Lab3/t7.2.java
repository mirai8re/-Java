//Миронова Анна
//Задан текстовый файл input.txt. Требуется определить строки этого файла,
//содержащие максимальную по длине подстроку, состоящую из одинаковых символов
//русского алфавита. Заглавные и строчные буквы не различаются. Если таких строк
//несколько, найти первые 10. Результат вывести на консоль в форме, удобной для чтения.
import java.io.*;
import java.util.Locale;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7_2 {

    public static void read_input(Vector<String> input) throws IOException {
        //считывание из файла
        BufferedReader input_stream = new BufferedReader(new FileReader("src/Lab3/Lab7.Resources/input.txt"));
        String input_temp = input_stream.readLine();
        while(input_temp != null) {
            input.add(input_temp);
            input_temp = input_stream.readLine();
        }
        input_stream.close();
    }

    public static int longest_substring(String string){
        //поиск наибольшей подстроки из одинаковых букв русского алфавита в строке
        Pattern pattern = Pattern.compile("[а-яА-Я]");
        int substr_len = 0, substr_len_max = 0;
        for(int i = 0; i < string.length();){
            //считывание элемента строки
            String letter = String.valueOf(string.charAt(i)).toLowerCase(Locale.ROOT);
            Matcher matcher = pattern.matcher(letter);
            if(matcher.find()) {//проверка на вхождение в диапазон, заданный регулярным выражением
                while(i < string.length() && letter.compareTo(String.valueOf(string.charAt(i)).toLowerCase(Locale.ROOT)) == 0 ) {
                    substr_len++;//вычисление длины подстроки
                    i++;
                }
                if (substr_len > substr_len_max)
                    substr_len_max = substr_len;//сравнение с максимальной длиной
                substr_len = 0;
            }
            else  i++;
        }
        return substr_len_max;
    }

    public static int[] search_strings(Vector<String> data){
        //поиск строк с максимально длинной подстрокой
        int temp, temp_max = 0, iter = 0;
        int [] index = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            //для каждой строки вызывается функция поиска самой длинной подстроки, происходит сравнение
            //полученных длин и занесение индексов строк с самыми длинными подстроками в массив
            temp = longest_substring(data.elementAt(i));
            if(temp > temp_max) {
                temp_max = temp;
                index = new int[data.size() - i];
                iter = 0;
                index[iter] = i;
                iter++;
            }
            else
            if(temp == temp_max){
                index[iter] = i;
                iter++;
            }
        }
        int [] index_result = new int[iter];
        System.arraycopy(index, 0, index_result,0, iter);
        return index_result;
    }

    public static void print_strings(int[] index, Vector<String> data){
        int i = 0;
        //зная индексы нужных строк выводятся либо все найденные, либо первые 10 строк
        while(i < index.length && i < 10){
            System.out.println(data.elementAt(index[i]));
            i++;
        }
    }

    public static void main(String[] args) throws IOException {
        Vector<String> data = new Vector<String>();
        int[] index;
        read_input(data);
        System.out.println("All text: ");
        for (String iterator: data)
            System.out.println(iterator);
        System.out.println('\n' + "String with longest substrings: ");
        index = search_strings(data);
        print_strings(index, data);
    }
}

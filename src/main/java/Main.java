import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        int size = 10;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите модификатор:");
        int input = sc.nextInt();
        //Здесь IDEa сама предложила заменить лямбду на метод. Я не стал отказываться
        int[] array1 = getFilledArray(size, input, Integer::sum);
        print(array1);

        int[] array2 = getFilledArray(size, input, (index, input1) -> index * input1);
        print(array2);

        int[] array3 = getFilledArray(size, input, (index, input1) -> {
            if ((index % 2) == 0) {
                return index / 2 + input1;
            }
            return index * index - input1;
        });
        print(array3);

        //Для индексов меньше 6 - сумма квадратов индекса и модификатора; в лругих случаях - разница квадратов
        int[] array4 = getFilledArray(size, input, (index, input1) -> {
            if (index < 6) {
                return index * index + input1 * input1;
            }
            return index * index - input1 * input1;
        });
        print(array4);

        //Если модификатор меньше или равен индексу по абсолютному значению, вывести ноль;
        //в других случаях вывести остаток от деления модификатора на (индекс+1)
        int[] array5 = getFilledArray(size, input, (index, input1) -> {
            if (input1 <= index) {
                return 0;
            }
            return input1 % (index + 1);
        });
        print(array5);
    }

    public static int[] getFilledArray(final int size, final int input, final Runnable calc) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = calc.process(i, input);
        }
        return array;
    }

    //Метод для вывода массивов
    public static void print(final int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}


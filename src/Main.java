import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    // Объявить метод «сгенерироватьМассив»
    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    public static void task1() {
        System.out.println("Задача №1");
        int[] arr = generateRandomArray();
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);
    }

    public static void task2() {
        System.out.println("");
        System.out.println("Задача №2");
        int[] arr = generateRandomArray();
        OptionalInt maxCost = Arrays.stream(arr).max();
        int minCost = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (minCost > arr[i]) {
                minCost = arr[i];
            }
        }
        System.out.println("Минимальная сумма трат за день составила " + minCost + " рублей. " +
                "Максимальная сумма трат за день составила " + maxCost.getAsInt() + " рублей");
    }

    public static void task3() {
        System.out.println("");
        System.out.println("Задача №3");
        int[] arr = generateRandomArray();
        long sum = 0;
        long count = 0;
        for (int i : arr) {
            sum += i;
            count++;
        }
        OptionalDouble avr = count > 0 ? OptionalDouble.of((double) sum / count) : OptionalDouble.empty();
        System.out.printf("Средняя сумма трат за месяц составила %.2f рублей", avr.getAsDouble());
    }

    public static void task4() {
        System.out.println("");
        System.out.println("Задача №4");
        char[] reverseFullName = {'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        /*for (int i = 0; i < reverseFullName.length; i++) {
            System.out.print(reverseFullName[i]);
        }*/
        for (int i = 0; i < reverseFullName.length / 2; i++) {
            char tmp = reverseFullName[i];
            reverseFullName[i] = reverseFullName[reverseFullName.length - i - 1];
            reverseFullName[reverseFullName.length - i - 1] = tmp;
        }
        System.out.print(reverseFullName);
    }
}
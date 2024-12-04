import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення номера студента
        System.out.print("Введіть номер студента N: ");
        int N = scanner.nextInt();
        int size = 3 * (N + 10);
        int maxValue = N + 1;

        // Генерація випадкової послідовності
        Random random = new Random();
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            sequence.add(random.nextInt(maxValue) + 1);
        }

        // Виведення початкової послідовності
        System.out.println("Початкова послідовність: " + sequence);

        // Сортування послідовності
        List<Integer> sortedSequence = new ArrayList<>(sequence);
        Collections.sort(sortedSequence);
        System.out.println("Впорядкована послідовність: " + sortedSequence);

        // Обчислення моди
        int mode = calculateMode(sortedSequence);
        System.out.println("Мода: " + mode);

        // Обчислення медіани
        double median = calculateMedian(sortedSequence);
        System.out.println("Медіана: " + median);

        // Обчислення середнього арифметичного
        double mean = calculateMean(sortedSequence);
        System.out.println("Середнє арифметичне: " + mean);

        // Перевірка алгоритму обчислення моди
        testModeCalculation();

        // Закриття сканера
        scanner.close();
    }

    // Метод для обчислення моди
    private static int calculateMode(List<Integer> sortedSequence) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : sortedSequence) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int mode = sortedSequence.get(0);
        int maxFrequency = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mode = entry.getKey();
            }
        }
        return mode;
    }

    // Метод для обчислення медіани
    private static double calculateMedian(List<Integer> sortedSequence) {
        int size = sortedSequence.size();
        if (size % 2 == 0) {
            return (sortedSequence.get(size / 2 - 1) + sortedSequence.get(size / 2)) / 2.0;
        } else {
            return sortedSequence.get(size / 2);
        }
    }

    // Метод для обчислення середнього арифметичного
    private static double calculateMean(List<Integer> sequence) {
        double sum = 0;
        for (int num : sequence) {
            sum += num;
        }
        return sum / sequence.size();
    }

    // Метод для перевірки алгоритму обчислення моди
    private static void testModeCalculation() {
        System.out.println("\nПеревірка алгоритму обчислення моди:");

        List<List<Integer>> testCases = Arrays.asList(
                Arrays.asList(1, 2, 2, 3, 4),
                Arrays.asList(5, 5, 5, 1, 1),
                Arrays.asList(1, 2, 3, 4, 4, 4, 5),
                Arrays.asList(3, 3, 3, 3, 3)
        );

        for (List<Integer> testCase : testCases) {
            System.out.println("Тестовий набір: " + testCase);
            int mode = calculateMode(testCase);
            System.out.println("Обчислена мода: " + mode);
        }
    }
}
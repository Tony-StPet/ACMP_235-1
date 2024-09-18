import java.util.Scanner;
public class MapRobot {

    // создаем матрицу и заполняем нулями - это поле
    public static int[][] createField() {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя количество строк и столбцов
        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int columns = scanner.nextInt();

        // Создаем матрицу
        int[][] field = new int[rows][columns];

// Заполняем матрицу нулями
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                field[i][j] = 0;
            }
        }

        return field;
    }

    // Функция для вывода матрицы
    public static void printField(int[][] field) {
        for (int[] row : field) {
            for (int value : row) {
                System.out.printf("%4d ", value);
            }
            System.out.println();
        }
    }


}

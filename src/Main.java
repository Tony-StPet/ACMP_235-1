import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //прочитать "программу робота", то есть строку из консоли
        String proga = readProga();
        //интерпретировать "программу робота" в соответствии с условием, то есть про    ти строку посимвольно
        //runProga(proga);

        // MapRobot.printField (MapRobot.createField());

        Robot robot = new Robot();
        runProgaForRobot(proga, robot, MapRobot.createField());



    }









    private static void runProgaForRobot(String proga, Robot bot, int[][] field) {
        int steps = 0;
        boolean foundTwo = false;
        for (char symbol: proga.toCharArray()) {
            switch (symbol) {
                case 'S':
                    roboStepForward(bot, field, steps);
                    if (field[bot.y][bot.x] == 2) {
                        System.out.println("Номер шага, на котором значение ячейки стало 2: " + steps);
                        foundTwo = true;
                    }
                    steps++;
                    break;
                case 'R':
                    roboTurnRight(bot);
                    if (field[bot.y][bot.x] == 2) {
                        System.out.println("Номер шага, на котором значение ячейки стало 2: " + steps);
                        foundTwo = true;
                    }
                    break;
                case 'L':
                    roboTurnLeft(bot);
                    if (field[bot.y][bot.x] == 2) {
                        System.out.println("Номер шага, на котором значение ячейки стало 2: " + steps);
                        foundTwo = true;
                    }
                    break;
                default:
                    System.out.println("Сбой программы");
            }
        }
            // Проверяем весь массив
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] == 2) {
                        foundTwo = true;
                        break;
                    }
                }
            }

        // Выводим массив значений
        System.out.println("Текущее состояние поля:");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.printf("%3d ", field[i][j]);
            }
            System.out.println();
        }

            if (!foundTwo) {
                System.out.println("Робот делал уникальные шаги -1");
            }
    }


    public static void printRoboState(Robot bot){
        System.out.println("x = " + bot.x);
        System.out.println("y = " + bot.y);
        System.out.println("direction = "+bot.direction);
    }

    public static void roboStepForward(Robot bot, int[][] field, int steps){

        System.out.println("шаг вперед");
        switch (bot.direction){
            case "right": if (field[bot.y][bot.x] == 1) {
                System.out.println("Номер шага работа, через которое он уже проходил: " + steps);
            } field[bot.y][bot.x]++; bot.x++;   break;
            case "left":  if (field[bot.y][bot.x] == 1) {
                System.out.println("Номер шага работа, через которое он уже проходил: " + steps);
            } field[bot.y][bot.x]++; bot.x--;  break;
            case "up":    if (field[bot.y][bot.x] == 1) {
                System.out.println("Номер шага работа, через которое он уже проходил: " + steps);
            } field[bot.y][bot.x]++; bot.y++;  break;
            case "down":  if (field[bot.y][bot.x] == 1) {
                System.out.println("Номер шага работа, через которое он уже проходил: " + steps);
            } field[bot.y][bot.x]++; bot.y--;  break;
        }
        printRoboState(bot);
    }

    public static void roboTurnRight(Robot bot){
        System.out.println("поворот вправо");
        switch (bot.direction){
            case "right": bot.direction = "down"; break;
            case "left":  bot.direction = "up"; break;
            case "up":    bot.direction = "right"; break;
            case "down":  bot.direction = "left"; break;
        }
        printRoboState(bot);
    }

    public static void roboTurnLeft(Robot bot){
        System.out.println("поворот налево");
        switch (bot.direction){
            case "right": bot.direction = "up"; break;
            case "left":  bot.direction = "down"; break;
            case "up":    bot.direction = "left"; break;
            case "down":  bot.direction = "right"; break;
        }
        printRoboState(bot);
    }








    private static String readProga() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите программу робота, содержащую буквы S, L, R без пробелов ");
        String s = scanner.next();
        return s;
    }
}

class Robot{
    int x=8, y=8;
    String direction="right"; //"left", "up", "down"
}

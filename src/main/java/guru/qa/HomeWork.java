public class HomeWork {
    public static void main(String[] args) {
        // 0) Арифметические операции
        System.out.println("=== 0.Арифметические операции ( + , -, * , /) над двумя примитивами типа int ===");
        int a = 15, b = 4;
        System.out.println(a + " + " + b + " = " + (a + b));
        System.out.println(a + " - " + b + " = " + (a - b));
        System.out.println(a + " * " + b + " = " + (a * b));
        System.out.println(a + " / " + b + " = " + (a / b) + " (целочисленное деление)");
        System.out.println(a + " % " + b + " = " + (a % b) + " (остаток)");

        // 1) Смешанные операции
        System.out.println("=== 1. Смешанные операции (int и double) ===");
        double d = 2.5;
        System.out.println(a + " + " + d + " = " + (a + d));
        System.out.println(a + " * " + d + " / 2 = " + (a * d / 2));

        // 2) Логические операции
        System.out.println("=== 2. Логические операции ===");
        System.out.println(a + " > " + b + " : " + (a > b));
        System.out.println(a + " < " + b + " : " + (a < b));
        System.out.println(a + " >= 15 : " + (a >= 15));
        System.out.println(a + " <= 20 : " + (a <= 20));


        // 4) Переполнение
        System.out.println("=== 4. Переполнение ===");
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Integer.MAX_VALUE = " + maxInt);
        System.out.println("Integer.MAX_VALUE + 1 = " + (maxInt + 1));
    }
}
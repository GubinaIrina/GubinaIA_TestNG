package ru.lanit.testng;

public class Math {

    public Object sumTest(Object two, Object tree) {
        System.out.println("Складываем "+ two + " и " + tree);
        int i = (Integer)two + (Integer)tree;
        return i;
    }

    public Object subtractionTest(Object two, Object tree) {
        System.out.println("Вычитаем "+ two + " и " + tree);
        int i = (Integer)two - (Integer)tree;
        return i;
    }

    public Object multiplicationTest(Object two, Object tree) {
        System.out.println("Умножаем "+ two + " и " + tree);
        int i = (Integer)two * (Integer)tree;
        return i;
    }

    public Object divisionTest(Object two, Object tree) {
        System.out.println("Делим "+ two + " и " + tree);
        int i = (Integer)two / (Integer)tree;
        return i;
    }
}

/**Реализуйте алгоритм сортировки пузырьком числового массива, 
 результат после каждой итерации запишите в лог-файл.*/
 
import java.util.Arrays;
import java.util.logging.Logger;

public class Buble_Sorting {
        private static final Logger logger = Logger.getGlobal();
        public static void main(String[] args) {
        int[] massive = {12, 23, 1, 45, -1, 34, 9};
        buble_sort(massive);

    }

    private static  void  buble_sort(int[] mas){

        boolean flag = true;
        int temp;

        while (flag){
            flag = false;
            for (int i = 0; i < mas.length - 1; i++){
                if (mas[i] > mas[i+1]){
                    flag = true;

                    temp = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = temp;
                    logger.info(String.format("Moved a number %d to the position of that number %d",mas[i+1], mas[i]));
                }
            }
        }
        logger.info("Finished work");
        System.out.println(Arrays.toString(mas));
    }
}

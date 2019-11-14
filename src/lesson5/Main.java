package lesson5;

public class Main {
    private static final int size = 10000000;
    private static final int h = size / 2;

    private static void arrCalc(float[] a, int startInd, int valCount) {
        int j = 0;
        for (int i = startInd; i < valCount; i++, j++) {
            a[j] = (float)(a[j] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

    }

    private static void method1(){
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long bt = System.currentTimeMillis();
        arrCalc(arr, 0 , arr.length);
        long et = System.currentTimeMillis();

        System.out.println(String.format("Время выполнения Method1: %d", et-bt));
    }
    private static void method2(){
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        float[] ar1 = new float[h];
        int h2 = arr.length-h;
        float[] ar2 = new float[h2];

        long bt = System.currentTimeMillis();

        System.arraycopy(arr, 0, ar1, 0, h);
        System.arraycopy(arr, h, ar2, 0, ar2.length);

        Runnable r1 = () -> arrCalc(ar1,0,h);
        Thread t1 = new Thread(r1);
        Runnable r2 = () -> arrCalc(ar2,h,h2);
        Thread t2 = new Thread(r2);

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(ar1, 0, arr, 0, h);
        System.arraycopy(ar2, 0, arr, h, h);
        long et = System.currentTimeMillis();

        System.out.println(String.format("Время выполнения Method2: %d", et-bt));
    }

    public static void main(String[] args) {
        method1();
        method2();
    }

}

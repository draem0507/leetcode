package leetcode.bytedance.other;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-20 19:17
 * @desc: 线程按顺序打印
 * https://blog.csdn.net/xuefeng0707/article/details/80531801
 */
public class OrderThread {

    static Object lock = new Object();

    static volatile int current = 0;

    static int len = 3;

    public static void main(String[] args) {

        int current = 0;
        int size = 3;

        PrintThread[] printThreads = {new PrintThread(0), new PrintThread(1), new PrintThread(2)};


        for (int i = 0; i < printThreads.length; i++) {

         new Thread(printThreads[i]).start();

        }


        int threadCount = 3;
        int max = 100;
        for(int i=0;i<threadCount;i++) {
         //   new Thread(new PrintSequenceThread(i,threadCount, max)).start();

}

    }


    static class PrintThread implements Runnable {

        private int id;

        public PrintThread(int id) {

            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {

                    System.out.print("id" + id);
                    while (current % len != id) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    current++;
                    if (current == len) {
                        current = 0;
                    }
                    System.out.println("   current:" + current);
                    lock.notifyAll();
                }

            }
        }
    }


    static class PrintSequenceThread implements Runnable {

        private static final Object LOCK = new Object();

        /**
         * 当前即将打印的数字
         */
        private static int current = 0;

        /**
         * 当前线程编号，从0开始
         */
        private int threadNo;

        /**
         * 线程数量
         */
        private int threadCount;

        /**
         * 打印的最大数值
         */
        private int max;

        public PrintSequenceThread(int threadNo, int threadCount, int max) {
            this.threadNo = threadNo;
            this.threadCount = threadCount;
            this.max = max;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    // 判断是否轮到当前线程执行
                    while (current % threadCount != threadNo) {
                        if (current > max) {
                            break;
                        }
                        try {
                            // 如果不是，则当前线程进入wait
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 最大值跳出循环
                    if (current > max) {
                        break;
                    }
                    System.out.println("thread-" + threadNo + " : " + current);
                    current++;
                    // 唤醒其他wait线程
                    LOCK.notifyAll();
                }
            }
        }

    }
}

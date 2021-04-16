package leetcode.bytedance.other;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2019-12-21 19:40
 * @desc:
 */
public class JvmTest {

    private static final int M = 1024 * 1024;

    public static void test() {
        byte[] alloc1, alloc2, alloc3, alloc4;
        alloc1 = new byte[5 * M];
        alloc2 = new byte[5 * M];
        alloc3 = new byte[5 * M];
        alloc4 = new byte[10 * M];

    }

    public static void main(String[] args) {
        test();
    }
}

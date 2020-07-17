import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Random;

/**
 * 自定义队列测试
 *
 * @author chy
 * @date 2020-07-16 15:16
 */
public class QueueTest {

    private static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        double time1 = testQueue(new ArrayQueue<>(), opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");
        double time2 = testQueue(new LoopQueue<>(), opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");
    }

}

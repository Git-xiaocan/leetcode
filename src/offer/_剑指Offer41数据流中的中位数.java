import java.util.PriorityQueue;
import java.util.Queue;
import javax.print.attribute.standard.MediaPrintableArea;

public class _剑指Offer41数据流中的中位数 {

  Queue<Integer> maxQueue;
  Queue<Integer> minQueue;

  /** initialize your data structure here. */
  public _剑指Offer41数据流中的中位数() {
    //大顶堆储存较大的一半
    maxQueue = new PriorityQueue<>((a, b) -> b - a);
    //小顶堆 储存较小的一半
    minQueue = new PriorityQueue<>();
  }

  public void addNum(int num) {
    if(maxQueue.size()==0){
        maxQueue.offer(num);
    }else if(maxQueue.size()!=minQueue.size()){
        maxQueue.offer(num);
        minQueue.offer(maxQueue.poll());
    }else {
        minQueue.offer(num);
        maxQueue.offer(minQueue.poll());
    }
  }

  public double findMedian() {
      System.out.println(maxQueue.size());
    if ((maxQueue.size() + minQueue.size()) % 2 == 0) {
      return (minQueue.peek() + maxQueue.peek()) / 2.0;
    } else return maxQueue.peek();
  }

  public static void main(String[] args) {
    _剑指Offer41数据流中的中位数 s = new _剑指Offer41数据流中的中位数();
    s.addNum(1);
    s.addNum(2);
    s.addNum(3);
    s.addNum(4);
    s.addNum(5);
    System.out.println(s.findMedian());
  }
}

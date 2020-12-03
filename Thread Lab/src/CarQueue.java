import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
	Random dir;
	Queue<Integer> queue;
	public CarQueue() {
		dir=new Random();
		queue=new ArrayDeque<Integer>();
		queue.add(dir.nextInt(4));
		queue.add(dir.nextInt(4));
		queue.add(dir.nextInt(4));
		queue.add(dir.nextInt(4));
		queue.add(dir.nextInt(4));
		queue.add(dir.nextInt(4));
	}
	public int deleteQueue() {
		int randomInt;
		randomInt=queue.remove();
		return randomInt;
		
	}
	public void addToQueue() {
		
		class Run implements Runnable{
			@Override
			public void run() {
				
				try {
					while (true) {
						queue.add(dir.nextInt(4));
						Thread.sleep(100);
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		Run myRun=new Run();
		Thread runThread=new Thread(myRun);
		runThread.start();
	}
}

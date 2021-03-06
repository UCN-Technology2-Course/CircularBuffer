
public class Producer extends Thread {
	
	CircularBuffer buffer;

	public Producer(CircularBuffer buffer) {
		super("Producer");

		this.buffer = buffer;
	}

	@Override
	public void run() {
		try {
			for (int v = 1; v <= 8; v++) {

				Thread.sleep((int) (Math.random() * 3001));

				System.out.println(getName() + " producing value: " + v);
				this.buffer.setValue(v);
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println(getName() + " done producing");
	}
}

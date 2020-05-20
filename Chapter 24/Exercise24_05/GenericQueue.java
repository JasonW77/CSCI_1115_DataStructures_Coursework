public class GenericQueue<E> extends java.util.LinkedList<E> {
	public void enQueue(E e) {
		addLast(e);
	}
	public E deQueue() {
		return removeFirst();
	}
	public int getSize() {
		return size();
	}
}
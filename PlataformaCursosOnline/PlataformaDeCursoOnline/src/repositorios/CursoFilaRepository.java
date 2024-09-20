package repositorios;

import java.util.ArrayList;

public class CursoFilaRepository<T> {
	private ArrayList<T> queueList;

	public CursoFilaRepository() {
		this.queueList = new ArrayList<>();
	}

	public void enqueue(T value) {
		queueList.add(value);
	}

	public T dequeue() {
		if (!queueList.isEmpty()) {
			return queueList.remove(0);
		} else {
			throw new RuntimeException("A fila está vazia.");
		}
	}

	public int size() {
		return queueList.size();
	}

	public T front() {
		if (!queueList.isEmpty()) {
			return queueList.get(0);
		} else {
			throw new RuntimeException("A fila está vazia.");
		}
	}

	public boolean empty() {
		return queueList.isEmpty();
	}

}

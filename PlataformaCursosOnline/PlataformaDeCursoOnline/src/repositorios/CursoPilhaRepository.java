package repositorios;

import java.util.ArrayList;

public class CursoPilhaRepository<T> {
	private ArrayList<T> stackList;

	public CursoPilhaRepository(ArrayList<T> pilha) {
		this.stackList = pilha;
	}

	public void push(T value) {
		stackList.add(value);
	}

	public T pop() {
		if (!stackList.isEmpty()) {
			return stackList.remove(stackList.size() - 1);
		} else {
			return null;
		}
	}

	public int size() {
		return stackList.size();
	}

	public T stackpop() {
		if (!stackList.isEmpty()) {
			return stackList.get(stackList.size() - 1);
		} else {
			return null;
		}
	}

	public boolean empty() {
		return stackList.isEmpty();
	}
}

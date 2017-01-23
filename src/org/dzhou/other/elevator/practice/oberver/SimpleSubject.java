package org.dzhou.other.elevator.practice.oberver;

import java.util.LinkedList;
import java.util.List;

public class SimpleSubject implements Subject {

	List<Observer> observers = null;

	public SimpleSubject() {
		this.observers = new LinkedList<>();
	}

	@Override
	public void register(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void unregister(Observer observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(null);
		}
	}

}

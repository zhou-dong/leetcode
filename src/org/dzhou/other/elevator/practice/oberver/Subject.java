package org.dzhou.other.elevator.practice.oberver;

public interface Subject {

	public void register(Observer observer);

	public void unregister(Observer observer);

	public void notifyObservers();

}

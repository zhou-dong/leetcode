package org.dzhou.other.elevator.practice.oberver;

import java.util.List;

import org.dzhou.other.elevator.practice.Engine.Status;

public class SimpleObserver implements Observer {

	Subject subject;

	public SimpleObserver(Subject subject) {
		this.subject = subject;
		register(subject);
	}

	@Override
	public void update(List<Status> megs) {
		for (Status status : megs) {
			System.out.println(status);
		}
	}

	@Override
	public void register(Subject subject) {
		subject.register(this);
	}

}

package org.dzhou.other.elevator.practice.oberver;

import java.util.List;

import org.dzhou.other.elevator.practice.Engine.Status;

public interface Observer {

	public void update(List<Status> status);

	public void register(Subject subject);
}

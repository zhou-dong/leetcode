package org.dzhou.other.elevator.practice;

public class Start {

	public static void main(String[] args) {
		Controller controller = new ControllerImpl();

		Elevator e1 = new Elevator(1, new EngineSCAN());
		Elevator e2 = new Elevator(2, new EngineSCAN());
		Elevator e3 = new Elevator(3, new EngineSCAN());
		Elevator e4 = new Elevator(4, new EngineSCAN());

		controller.addElevator(e1);
		controller.addElevator(e2);
		controller.addElevator(e3);
		controller.addElevator(e4);

		controller.start();
	}

}

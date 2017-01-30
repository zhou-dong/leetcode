package org.dzhou.other.designpattern;

public class FactoryPattern {

	interface Auto {
		public String getBrand();

		public double getPrice();
	}

	static class BMW implements Auto {
		@Override
		public String getBrand() {
			return "BMW";
		}

		@Override
		public double getPrice() {
			return 30000.00;
		}
	}

	static class DODGE implements Auto {
		@Override
		public String getBrand() {
			return "DODGE";
		}

		@Override
		public double getPrice() {
			return 20000.00;
		}
	}

	static class AutoFactory {
		public Auto createAuto(String name) {
			switch (name) {
			case "BMW":
				return new BMW();
			case "DODGE":
				return new DODGE();
			default:
				return null;
			}
		}
	}

	public static void main(String[] args) {
		AutoFactory factory = new AutoFactory();
		Auto bmw = factory.createAuto("BMW");
		Auto dodge = factory.createAuto("DODGE");
		System.out.println(bmw.getBrand());
		System.out.println(bmw.getPrice());
		System.out.println(dodge.getBrand());
		System.out.println(dodge.getPrice());
	}

}

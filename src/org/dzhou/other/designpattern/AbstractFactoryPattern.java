package org.dzhou.other.designpattern;

public class AbstractFactoryPattern {

	public static abstract class Auto {
		private double price;
		private String brand;
		private String color;

		public abstract void makeAuto();

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
	}

	public static class BMW extends Auto {
		AutoFactory factory;

		public BMW(AutoFactory factory) {
			this.factory = factory;
		}

		@Override
		public void makeAuto() {
			setBrand(factory.addBrand());
			setColor(factory.addColor());
			setPrice(factory.addPrice());
		}
	}

	public static class DODGE extends Auto {
		AutoFactory factory;

		public DODGE(AutoFactory factory) {
			this.factory = factory;
		}

		@Override
		public void makeAuto() {
			setBrand(factory.addBrand());
			setColor(factory.addColor());
			setPrice(factory.addPrice());
		}
	}

	interface AutoFactory {
		public String addBrand();

		public String addColor();

		public double addPrice();
	}

	public static class BMWFactory implements AutoFactory {
		@Override
		public String addBrand() {
			return "BMW";
		}

		@Override
		public String addColor() {
			return "BROWN";
		}

		@Override
		public double addPrice() {
			return 30000.00;
		}
	}

	public static class DODGEFactory implements AutoFactory {
		@Override
		public String addBrand() {
			return "DODGE";
		}

		@Override
		public String addColor() {
			return "RED";
		}

		@Override
		public double addPrice() {
			return 20000.00;
		}
	}

	public static abstract class AutoBuilding {
		protected abstract Auto makeAuto(String typeOfAuto);

		public Auto orderAuto(String typeOfAuto) {
			Auto auto = makeAuto(typeOfAuto);
			auto.makeAuto();
			return auto;
		}
	}

	public static class BasicAutoBuilding extends AutoBuilding {
		@Override
		protected Auto makeAuto(String typeOfAuto) {
			switch (typeOfAuto) {
			case "BMW":
				return new BMW(new BMWFactory());
			case "DODGE":
				return new DODGE(new DODGEFactory());
			}
			return null;
		}
	}

	public static void main(String[] args) {
		AutoBuilding basicAutoBuilding = new BasicAutoBuilding();
		Auto bmw = basicAutoBuilding.orderAuto("BMW");
		Auto dodge = basicAutoBuilding.orderAuto("DODGE");
		print(bmw);
		print(dodge);
	}

	private static void print(Auto auto) {
		System.out.println("brand: " + auto.getBrand());
		System.out.println("color: " + auto.getColor());
		System.out.println("price: " + auto.getPrice());
		System.out.println();
	}

}

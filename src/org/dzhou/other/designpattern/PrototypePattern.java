package org.dzhou.other.designpattern;

public class PrototypePattern {

	interface Auto extends Cloneable {
		Auto copy();

		String getBrand();

		double getPrice();
	}

	static class BENZ implements Auto {

		double price;

		@Override
		public Auto copy() {
			try {
				return (Auto) clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
				return null;
			}
		}

		@Override
		public String getBrand() {
			return "Benz";
		}

		@Override
		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
	}

	public static void main(String[] args) {
		BENZ auto = new BENZ();
		Auto copy = auto.copy();
		auto.setPrice(60000);
		print(auto);
		print(copy);
		System.out.println(auto == copy);
	}

	private static void print(Auto auto) {
		System.out.println("brand: " + auto.getBrand());
		System.out.println("price: " + auto.getPrice());
		System.out.println("hashcode: " + auto.hashCode());
	}

}

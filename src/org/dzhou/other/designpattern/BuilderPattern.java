package org.dzhou.other.designpattern;

public class BuilderPattern {

	public static class Auto {
		double price;
		String brand;
		String color;
		String country;
		int engines;
	}

	public static class AutoBuilder {

		public static AutoBuilder Builder(String brand, double price) {
			return new AutoBuilder(brand, price);
		}

		Auto auto = null;

		private AutoBuilder() {
		}

		private AutoBuilder(String brand, double price) {
			auto = new Auto();
			auto.brand = brand;
			auto.price = price;
		}

		public AutoBuilder setColor(String color) {
			auto.color = color;
			return this;
		}

		public AutoBuilder setCountry(String country) {
			auto.country = country;
			return this;
		}

		public AutoBuilder setEngines(int engines) {
			auto.engines = engines;
			return this;
		}

		public Auto build() {
			return auto;
		}
	}

	public static void main(String[] args) {
		Auto bmw = AutoBuilder.Builder("BMW", 50000.00).setColor("Black").setEngines(8).setCountry("Germany").build();
		print(bmw);
	}

	private static void print(Auto auto) {
		StringBuilder sb = new StringBuilder();
		sb.append("brand: ").append(auto.brand);
		sb.append(", price: ").append(auto.price);
		sb.append(", color: ").append(auto.color);
		sb.append(", country: ").append(auto.country);
		sb.append(", engines: ").append(auto.engines);
		System.out.println(sb.toString());
	}

}

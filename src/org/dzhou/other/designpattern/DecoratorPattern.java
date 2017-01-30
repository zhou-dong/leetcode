package org.dzhou.other.designpattern;

public class DecoratorPattern {

	interface Pizza {
		String getDescription();

		double getPrice();
	}

	static class PlainPizza implements Pizza {
		@Override
		public String getDescription() {
			return "Thin dough";
		}

		@Override
		public double getPrice() {
			return 4.00;
		}
	}

	abstract static class PizzaDecorator implements Pizza {
		protected Pizza pizza;

		public PizzaDecorator(Pizza pizza) {
			this.pizza = pizza;
		}
	}

	static class Mozzarella extends PizzaDecorator {
		public Mozzarella(Pizza pizza) {
			super(pizza);
		}

		@Override
		public String getDescription() {
			return pizza.getDescription() + ", Mozzarella";
		}

		@Override
		public double getPrice() {
			return pizza.getPrice() + 2.00;
		}
	}

	static class TomatoSauce extends PizzaDecorator {
		public TomatoSauce(Pizza pizza) {
			super(pizza);
		}

		@Override
		public String getDescription() {
			return pizza.getDescription() + ", tomato-sauce";
		}

		@Override
		public double getPrice() {
			return pizza.getPrice() + 2.00;
		}
	}

	public static void main(String[] args) {
		Pizza pizza = new PlainPizza();
		print(pizza);
		pizza = new Mozzarella(pizza);
		print(pizza);
		pizza = new TomatoSauce(pizza);
		print(pizza);
	}

	static void print(Pizza pizza) {
		System.out.println(pizza.getDescription() + " " + pizza.getPrice());
	}

}

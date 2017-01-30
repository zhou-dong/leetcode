package org.dzhou.other.designpattern;

public class StrategyPattern {

	interface Sound {
		public void sound();
	}

	static class Tweet implements Sound {
		@Override
		public void sound() {
			System.out.println("ga ga");
		}
	}

	static class Bark implements Sound {
		@Override
		public void sound() {
			System.out.println("wang wang");
		}
	}

	static class Animal implements Sound {
		protected String name;
		protected double height;
		protected double weight;
		protected Sound sound;

		@Override
		public void sound() {
			sound.sound();
		}
	}

	static class Bird extends Animal {
		public Bird() {
			super();
			this.sound = new Tweet();
		}
	}

	static class Dog extends Animal {
		public Dog() {
			super();
			this.sound = new Bark();
		}
	}

	public static void main(String[] args) {
		new Bird().sound();
		new Dog().sound();
	}
}

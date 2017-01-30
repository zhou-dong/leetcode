package org.dzhou.other.designpattern;

import java.util.HashSet;
import java.util.Set;

public class ObserverPattern {

	interface Observer {
		public void update(double googlePrice, double faceBookPrice);
	}

	interface Subject {
		public void register(Observer observer);

		public void unregister(Observer observer);

		public void notifyAllObservers();
	}

	static class WebOberver implements Observer {
		public WebOberver(Subject subject) {
			subject.register(this);
		}

		@Override
		public void update(double googlePrice, double faceBookPrice) {
			StringBuilder sb = new StringBuilder();
			sb.append("This is web observer ");
			sb.append("google price is: ").append(googlePrice);
			sb.append(" facebook price is: ").append(faceBookPrice);
			System.out.println(sb.toString());
		}
	}

	static class PhoneOberver implements Observer {
		public PhoneOberver(Subject subject) {
			subject.register(this);
		}

		@Override
		public void update(double googlePrice, double faceBookPrice) {
			StringBuilder sb = new StringBuilder();
			sb.append("This is phone observer ");
			sb.append("google price is: ").append(googlePrice);
			sb.append(" facebook price is: ").append(faceBookPrice);
			System.out.println(sb.toString());
		}
	}

	static class StockTop implements Subject {
		private double googlePrice;
		private double faceBookPrice;

		Set<Observer> observers;

		public StockTop() {
			this.observers = new HashSet<>();
		}

		@Override
		public void register(Observer observer) {
			observers.add(observer);
		}

		@Override
		public void unregister(Observer observer) {
			observers.remove(observer);
		}

		@Override
		public void notifyAllObservers() {
			for (Observer observer : observers) {
				observer.update(googlePrice, faceBookPrice);
			}
		}

		public void setGooglePrice(double googlePrice) {
			this.googlePrice = googlePrice;
			notifyAllObservers();
		}

		public void setFaceBookPrice(double faceBookPrice) {
			this.faceBookPrice = faceBookPrice;
			notifyAllObservers();
		}
	}

	public static void main(String[] args) {
		StockTop stockTop = new StockTop();
		new WebOberver(stockTop);
		new PhoneOberver(stockTop);
		stockTop.setFaceBookPrice(100);
		stockTop.setGooglePrice(200);
	}

}

package org.dzhou.other.designpattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// bad example: just for test this pattern
public class CompositePattern {

	static abstract class Json {
		public void addJson(Object key, Object value) {
			throw new UnsupportedOperationException();
		}

		public void addJson(Json json) {
			throw new UnsupportedOperationException();
		}

		public abstract void remove(Object key);
	}

	static class JsonObject extends Json {
		Map<Object, Object> map;

		public JsonObject() {
			map = new HashMap<>();
		}

		@Override
		public void addJson(Object key, Object value) {
			map.put(key, value);
		}

		@Override
		public void remove(Object key) {
			map.remove(key);
		}
	}

	static class JsonList extends Json {
		List<Json> list;

		public JsonList() {
			list = new ArrayList<>();
		}

		@Override
		public void addJson(Json json) {
			list.add(json);
		}

		@Override
		public void remove(Object key) {
			list.remove(key);
		}
	}
}

# JAVA 多线程总结

### 启动新线程：

1. extends Thread
2. implements Runnable

不管是继承Thread还是Runnable，都需要override run()方法。但是新线程的启动需要 thread.start();如果是直接调用run()方法的话，不会启动的新的线程，而是会在主线程中调用run()方法。🐷

```Java
class NewThread extends Thread {
	@Override
	public void run() {
		System.out.println("This is a thread...");
	}
}
public static void main(String[] args) {
	new NewThread().start();
}
```

```java
class NewRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("This is a runnable...");
	}
}
public static void main(String[] args) {
	new Thread(new NewRunnable()).start();
}
```
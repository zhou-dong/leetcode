# JAVA 多线程总结

### 启动新线程：

1. extends Thread
2. implements Runnable

不管是继承Thread还是Runnable，都需要Override run()方法。但是新线程的启动需要 thread.start();如果是直接调用run()方法的话，不会启动的新的线程，而是会在主线程中调用run()方法。

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

### volatile 关键字

有的Java编译器，为了优化代码，可能会缓存某些字段，使用volatile关键字以后，可以防止编译器缓存，这样这个值得改变就能被线程感应到。

```java
class Processor extends Thread {
	// volatile prevent thread caching this property
	private volatile boolean running = true;
	@Override
	public void run() {
		while (running) {
			System.out.println("hello world");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void shutDown() {
		running = false;
	}
}
```

### CountDownLatch

使用latch.await();来等待latch.getCount()==0，使用latch.countDown();来count--

```java
int count = 3;
CountDownLatch latch = new CountDownLatch(count);
for (int i = 0; i < count; i++) {
	new Thread(new Runnable() {
		@Override
		public void run() {
			System.out.println("this is new thread");
			latch.countDown();
		}
	}).start();
}
try {
	latch.await();
} catch (InterruptedException e) {
	e.printStackTrace();
}
System.out.println("programming finished");
```

### wait notify

必须在synchronized块中使用，使用wait();方法交出synchronized权限，其它线程可以使用notify();来唤醒wait状态的线程。

使用wait和notify可以创建BlockingQueue，queue空的时候remove方法wait，满的时候push方法wait

### ReentrantLock

Just like synchronized keyword but add more functions;

```java
lock.lock();
try {
	doSth();
} finally {
	lock.unlock();
}
```

### Prevent dead lock

```java
private void acquireLock(Lock lock1, Lock lock2) throws InterruptedException {
	while (true) {
		boolean gotFirstLock = false;
		boolean gotSecondLock = false;
		try {
			gotFirstLock = lock1.tryLock();
			gotSecondLock = lock2.tryLock();
		} finally {
			if (gotFirstLock && gotSecondLock) 
				return;
			if (gotFirstLock) 
				lock1.unlock();
			if (gotSecondLock) 
				lock2.unlock();
		}
		Thread.sleep(1);
	}
}
``` 


### Semaphore

可以用在连接池实现中，限制资源的个数，资源全被acquire以后，除非有别的线程release，否则当先线程只能等待。

```java
Semaphore semaphore = new Semaphore(2);
semaphore.acquire();
semaphore.acquire();
semaphore.release();
semaphore.acquire();	
```

### Callable Future

一般来说一个线程启动以后，运行完以后就消失了，跟主线程没有关系，但是Callable和Future，可以让子线程运行完以后有返回值给主线程，而且也可以在主线程中处理子线程中的异常。

### Interrupting Thread

这个命令并不会真正关闭线程，而是告诉线程希望关闭当前线程，线程可以不理会这个提示继续运行，也可以捕捉到这个异常以后做相应的处理。
import java.util.concurrent.CountDownLatch;

class Foo {
    private CountDownLatch secondLatch;
    private CountDownLatch thirdLatch;

    public Foo() {
        secondLatch = new CountDownLatch(1); // Ensure second() waits for first()
        thirdLatch = new CountDownLatch(1); // Ensure third() waits for second()
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondLatch.countDown(); // Signal that first() is done
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondLatch.await(); // Wait for first() to complete
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thirdLatch.countDown(); // Signal that second() is done
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdLatch.await(); // Wait for second() to complete
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

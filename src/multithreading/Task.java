package multithreading;

import java.util.concurrent.Callable;

public class Task<T> {

    private final Callable<T> callable;
    private volatile T result;
    private boolean isInProgress;
    private TaskRuntimeException thrown;

    public Task(Callable<T> callable) {
        this.callable = callable;
    }

    public T get() throws TaskRuntimeException {
        T callResult = result;
        Exception exception = thrown;
        if (callResult == null) {
            if (exception == null) {
                await();
                try {
                    callResult = doCall();
                } catch (Exception e) {
                    thrown = new TaskRuntimeException(e);
                    throw thrown;
                }
            } else {
                throw thrown;
            }
        }
        return callResult;
    }

    private synchronized T doCall() throws Exception {
        T callResult = null;
        if (result == null) {
            isInProgress = true;
            callResult = result = callable.call();
            isInProgress = false;
        }
        return callResult;
    }

    private synchronized void await() {
        while (isInProgress) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
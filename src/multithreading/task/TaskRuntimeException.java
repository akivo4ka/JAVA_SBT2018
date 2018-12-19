package multithreading.task;

public class TaskRuntimeException extends RuntimeException {

    private final Throwable throwable;

    TaskRuntimeException(Throwable throwable) {
        this.throwable = throwable;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
package com.example.threading;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("We are in thread: " + Thread.currentThread().getName());
            throw new RuntimeException("Intentional Exception");
        });
        thread.setName("Worker thread - 1");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread: " + t.getName());
            }
        });
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");
    }
}
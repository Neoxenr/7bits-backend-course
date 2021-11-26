package it.sevenbits.fifthpractice.gm.ThreadExecutor;

import it.sevenbits.fifthpractice.gm.Account.Account;

/**
 * Class with threads
 */
public class ThreadExecutor {
    /**
     * Method which demonstrates functional of threads
     * @param millis - time for threads
     * @throws InterruptedException - thread's exception
     */
    public void showAccountFilling(final long millis) throws InterruptedException {
        Account account = new Account(0);

        Thread firstThread = new Thread(() -> {
            try {
                final int income = 20;

                System.out.println("Stream " + Thread.currentThread().getName() + " has been started");

                while (!Thread.interrupted()) {
                    account.addToBalance(income);
                }
            } catch (Exception e) {
                System.out.println("Stream " + Thread.currentThread().getName() + " has been finished");
            }
        });

        Thread secondThread = new Thread(() -> {
            try {
                final int income = -5;

                System.out.println("Stream " + Thread.currentThread().getName() + " has been started");

                while (!Thread.interrupted()) {
                    account.addToBalance(income);
                }

            } catch (Exception e) {
                System.out.println("Stream " + Thread.currentThread().getName() + " has been finished");
            }
        });

        Thread thirdThread = new Thread(() -> {
            try {
                final int income = 10;

                System.out.println("Stream " + Thread.currentThread().getName() + " has been started");

                while (!Thread.interrupted()) {
                    account.addToBalance(income);
                }
            } catch (Exception e) {
                System.out.println("Stream " + Thread.currentThread().getName() + " has been finished");
            }
        });

        firstThread.start();
        secondThread.start();
        thirdThread.start();

        Thread.sleep(millis);

        firstThread.interrupt();
        secondThread.interrupt();
        thirdThread.interrupt();

        firstThread.join();
        secondThread.join();
        thirdThread.join();

        System.out.println(account);
    }
}

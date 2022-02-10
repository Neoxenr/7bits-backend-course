package it.sevenbits.fifthpractice.gm;

import it.sevenbits.fifthpractice.gm.Account.Account;
import it.sevenbits.fifthpractice.gm.ListOperator.ListOperator;
import it.sevenbits.fifthpractice.gm.ThreadExecutor.ThreadExecutor;

import java.util.ArrayList;
import java.util.LinkedList;

public final class Main {
    /**
     * Input point
     * @param args - input args
     * @throws InterruptedException - thread's exception
     */
    public static void main(final String[] args) throws InterruptedException {
        ListOperator listOperator = new ListOperator();

        // 1
        ArrayList<Integer> arrayList = new ArrayList<>();

        final int first = 3;
        final int second = 10;
        final int third = 4;

        arrayList.add(first);
        arrayList.add(second);
        arrayList.add(third);

        final int arrayListStart = 0;
        final int arrayListEnd = 3;

        System.out.println(listOperator.max(arrayList, arrayListStart, arrayListEnd));

        listOperator.changeElementsPosition(arrayList, 1, 2);
        System.out.println(arrayList);

        System.out.println();

        // 2
        LinkedList<Account> linkedList = new LinkedList<>();

        final int firstBalance = 100;
        final int secondBalance = 5;
        final int thirdBalance = 12;

        linkedList.add(new Account(firstBalance));
        linkedList.add(new Account(secondBalance));
        linkedList.add(new Account(thirdBalance));

        final int linkedListEnd = 3;

        System.out.println(listOperator.max(linkedList, 0, linkedListEnd));

        listOperator.changeElementsPosition(linkedList, 0, 1);
        System.out.println(linkedList);

        System.out.println();

        // 3
        ThreadExecutor threadExecutor = new ThreadExecutor();
        threadExecutor.showAccountFilling(2);
    }
    private Main() {}
}

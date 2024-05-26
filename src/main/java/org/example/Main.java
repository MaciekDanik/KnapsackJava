package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int itemTypeCount = 3;
        int seed = 1;
        int capacity = 20;

        Problem problem = new Problem(itemTypeCount,seed,1,10);
        Result res =  problem.Solve(capacity);

        System.out.println(res.toString());
    }
}
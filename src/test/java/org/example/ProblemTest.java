package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProblemTest {
    @Test
    public void atLeastOne(){
        int typeCount = 2;
        Problem problem = new Problem(typeCount,1,1,10);

        List<Item> itemList = new ArrayList<Item>();
        for (int i = 1; i<=typeCount; i++){
            Item item = new Item(i,i+1,2*i);
            itemList.add(item);
        }

        problem.setItemTypeList(itemList);
//        problem.toString();


        Result res =  problem.Solve(3);
        Assertions.assertEquals(1, res.getFinalItems().size());
    }

    @Test
    public void none(){
        int typeCount = 3;
        Problem problem = new Problem(typeCount,1,1,10);

        List<Item> itemList = new ArrayList<Item>();
        for (int i = 1; i<=typeCount; i++){
            Item item = new Item(i,i+4,2*i);
            itemList.add(item);
        }

        problem.setItemTypeList(itemList);


        Result res =  problem.Solve(3);
        Assertions.assertEquals(0, res.getFinalItems().size());
    }

    public boolean isInRange(int val, int min, int max){
        if(val >= min && val <= max){return true;}

        return false;
    }

    @Test
    public void isInRange(){
        int typeCount = 3;
        int minValue = 1;
        int maxValue = 10;
        boolean areInRange = true;
        Problem problem = new Problem(typeCount,1,minValue,maxValue);

        for (Item item : problem.getItemTypeList()){
            if(!isInRange(item.getWeight(),minValue,maxValue) || !isInRange(item.getValue(), minValue, maxValue)){
                areInRange = false;
            }
        }

//        Result res =  problem.Solve(3);
        Assertions.assertEquals(true, areInRange);
    }

    @Test
    public void specificInstance(){
        int typeCount = 3;
        int minValue = 1;
        int maxValue = 10;
        int seed = 1;
        int capacity = 20;

        Problem problem = new Problem(typeCount,seed,minValue,maxValue);
        Result res =  problem.Solve(capacity);

        Assertions.assertEquals(20, res.getTotalWeight());
        Assertions.assertEquals(30,res.getTotalValue());
    }

}
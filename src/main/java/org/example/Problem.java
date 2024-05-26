package org.example;

import java.util.*;

public class Problem {
    private int itemTypeCount;
    private int seed;
    private int minValue;
    private int maxValue;
    private List<Item> itemTypeList;

    public Problem(int itemTypeCount, int seed, int minValue, int maxValue){
        this.itemTypeCount = itemTypeCount;
        this.seed = seed;
        this.minValue = minValue;
        this.maxValue = maxValue;
        Random random = new Random();
        random.setSeed(seed);


        itemTypeList = new ArrayList<Item>();
        for (int i = 0; i < this.itemTypeCount; i++){
            int weight = random.nextInt((maxValue - minValue + 1) + minValue);
            int value = random.nextInt((maxValue - minValue + 1) + minValue);
            if (weight == 0){weight = random.nextInt((maxValue - minValue + 1) + minValue);}
            if (value == 0){value = random.nextInt((maxValue - minValue + 1) + minValue);}

            Item item =  new Item(i, weight, value);
            itemTypeList.add(item);
        }
    }

    public Result Solve(int capacity){
        List<Item> resultList = new ArrayList<Item>();
        int knapsackWeight = 0;
        int knapsackValue = 0;
        for (Item item : itemTypeList){
            System.out.println(item.toString());
        }

        Collections.sort(itemTypeList, Comparator.comparing(Item::getRatio));
        itemTypeList = itemTypeList.reversed();

        int index = 0;
        while (knapsackWeight <= capacity && index < itemTypeList.size()) {
            if ((knapsackWeight + itemTypeList.get(index).getWeight()) <= capacity) {
                resultList.add(itemTypeList.get(index));
                knapsackWeight += itemTypeList.get(index).getWeight();
                knapsackValue += itemTypeList.get(index).getValue();
            }
            else {
                index++;
            }
        }
        Result result = new Result(knapsackWeight,knapsackValue,resultList);
        return result;
    }
    @Override
    public String toString() {
        return "f";
    }

    public void setItemTypeList(List<Item> itemList){
        this.itemTypeList = itemList;
    }

    public List<Item> getItemTypeList(){
        return this.itemTypeList;
    }

    public String printItems(){
        String str = "";

        for (Item item : itemTypeList){
            str += item.toString() + System.lineSeparator();
        }
        return str;
    }
}

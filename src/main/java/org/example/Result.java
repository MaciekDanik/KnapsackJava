package org.example;

import java.util.List;

public class Result {
    private int totalWeight;
    private int totalValue;
    private List<Item> finalItems;

    public Result(int totalWeight, int totalValue, List<Item> finalItems){
        this.totalWeight = totalWeight;
        this.totalValue = totalValue;
        this.finalItems = finalItems;
    }

    @Override
    public String toString(){
        String str = "Total weight: " + totalWeight + System.lineSeparator() + "Total Value: " + totalValue + System.lineSeparator() + System.lineSeparator() + "Items in backpack (" +finalItems.size() + "): ";

        for(Item item : finalItems){
            str += System.lineSeparator() + item.toString();
        }

        return str;
    }

    public List<Item> getFinalItems(){
        return this.finalItems;
    }

    public int getTotalWeight(){
        return this.totalWeight;
    }

    public int getTotalValue(){
        return this.totalValue;
    }
}

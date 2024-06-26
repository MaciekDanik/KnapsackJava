package org.example;

public class Item {
    private int _Id;
    private int Weight;
    private int Value;
    private double Ratio;

    public Item(int id, int weight, int value){
        this._Id = id;
        this.Weight = weight;
        this.Value = value;
        this.Ratio = (double) value / weight;
    }

    public int get_Id(){
        return this._Id;
    }

    public int getWeight(){
        return this.Weight;
    }

    public int getValue(){
        return this.Value;
    }

    public double getRatio(){
        return this.Ratio;
    }

    @Override
    public String toString(){
        return "ID: " + _Id + "\tWeight: " + Weight + "\tValue: " + Value + "\tRatio: " + Ratio;
    }
}

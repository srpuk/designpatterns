package com.design.creational;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    public static void main(String args[]){
        CDBuilder cdBuilder=new CDBuilder();
        CDType cdType1=cdBuilder.buildSonyCD();
        cdType1.showItems();

        CDType cdType2=cdBuilder.buildSamsungCD();
        cdType2.showItems();
    }
}

 interface Packing {
    public String pack();
    public int price();
}

 abstract class CD implements Packing{
}

 abstract class Company extends CD{
}

 class Sony extends Company{
    @Override
    public int price(){
        return 20;
    }
    @Override
    public String pack(){
        return "com.design.creational.Sony com.design.creational.CD";
    }
}//End of the com.design.creational.Sony class.

 class Samsung extends Company {
    @Override
    public int price(){
        return 15;
    }
    @Override
    public String pack(){
        return "com.design.creational.Samsung com.design.creational.CD";
    }
}//End of the com.design.creational.Samsung class.

 class CDType {
    private List<Packing> items=new ArrayList<Packing>();
    public void addItem(Packing packs) {
        items.add(packs);
    }
    public void getCost(){
        for (Packing packs : items) {
            packs.price();
        }
    }
    public void showItems(){
        for (Packing packing : items){
            System.out.print("com.design.creational.CD name : "+packing.pack());
            System.out.println(", Price : "+packing.price());
        }
    }
}//End of the com.design.creational.CDType class.

 class CDBuilder {
    public CDType buildSonyCD(){
        CDType cds=new CDType();
        cds.addItem(new Sony());
        return cds;
    }
    public CDType buildSamsungCD(){
        CDType cds=new CDType();
        cds.addItem(new Samsung());
        return cds;
    }
}// End of the com.design.creational.CDBuilder class.
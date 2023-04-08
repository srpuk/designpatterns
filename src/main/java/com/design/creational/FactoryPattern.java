package com.design.creational;
//in Java, factory pattern is used to create instances of different classes of the same type.

public class FactoryPattern {


    public static void main(String[] args){
       //carfactory is the class which is responsible for selecting the appropriate subclass
       ElectricCarFactory carFactory=new ElectricCarFactory();

        // here we are not exposing the subclass, otherwise it would be like com.design.creational.Car car1=new SUV();
        ElectricCar car1=carFactory.buildCar(CarType.SUV);
        System.out.println(car1);
        ElectricCar car2=carFactory.buildCar(CarType.HATCHBACK);
        System.out.println(car2);
        ElectricCar car3=carFactory.buildCar(CarType.SEDAN);
        System.out.println(car3);


    }
}

class ElectricCarFactory{

    public ElectricCar buildCar(CarType carType){
        ElectricCar car=null;
        switch (carType){
            case SUV:  car=new ElectricSuv(CarType.SUV);break;
            case SEDAN:  car=new ElectricSedan(CarType.SEDAN);break;
            case HATCHBACK: car=new ElectricHatchBack(CarType.HATCHBACK);break;
            default: System.out.println("No car found");break;
        }
        return car;
    }
}

abstract class ElectricCar{
  private CarType model=null;

  public ElectricCar(CarType model){
      this.model=model;
      arrangeParts();
  }
  public void arrangeParts() {System.out.println("Arranging parts");}
  protected abstract void construct();

    public CarType getModel() {
        return model;
    }

    public void setModel(CarType model) {
        this.model = model;
    }
}

class ElectricHatchBack extends ElectricCar{

    ElectricHatchBack(CarType carType) {
        super(carType);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building "+getModel()+" com.design.creational.Car");
    }
}
class ElectricSedan extends ElectricCar{

    ElectricSedan(CarType carType) {
        super(carType);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building "+getModel()+" com.design.creational.Car");
    }
}
class ElectricSuv extends ElectricCar{

    public ElectricSuv(CarType carType) {
        super(carType);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building "+getModel()+" com.design.creational.Car");
    }
}

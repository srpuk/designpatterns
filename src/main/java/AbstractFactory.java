public class AbstractFactory {

    public static void main(String[] args) {
        //another layer of abstrction over factory pattern
        //like now we have global presense and different locations will have diff methods to build car
        // here we are not exposing the subclass, otherwise it would be like Car car1=new SUV()
        Car car1 = CarFactory.buildCar(Location.ASIA, CarType.SUV);
        System.out.println(car1);
        Car car2 = CarFactory.buildCar(Location.USA,CarType.HATCHBACK);
        System.out.println(car2);
        Car car3 = CarFactory.buildCar(Location.EUROPE,CarType.SEDAN);
        System.out.println(car3);
    }
}

enum CarType{
    HATCHBACK,SEDAN,SUV
}
enum Location{
    USA,EUROPE,ASIA
}
abstract class Car{
    private CarType model=null;
    private Location location=null;

    public Car(CarType model,Location location){
        this.model=model;
        this.location=location;
        arrangeParts();
    }
    public void arrangeParts() {System.out.println("Arranging parts");}
    protected abstract void construct();

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CarType getModel() {
        return model;
    }

    public void setModel(CarType model) {
        this.model = model;
    }
}

class HatchBack extends Car{

    HatchBack(Location location) {
        super(CarType.HATCHBACK,location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building "+getModel()+" Car for location "+getLocation());
    }
}
class Sedan extends Car{

    Sedan(Location location) {
        super(CarType.SEDAN,location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building "+getModel()+" Car for location "+getLocation());
    }
}
class Suv extends Car{

    public Suv(Location location) {
        super(CarType.SUV,location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building "+getModel()+" Car for location "+getLocation());
    }
}

class USACarFactory{
    public static Car buildCar(CarType carType){
        Car car=null;
        switch (carType){
            case HATCHBACK: car=new HatchBack(Location.USA); break;
            case SEDAN: car=new Sedan(Location.USA);break;
            case SUV: car=new Suv(Location.USA);break;
            default:System.out.println("car model not found");break;
        }
        return car;
    }
}
class ASIACarFactory{
    public static Car buildCar(CarType carType){
        Car car=null;
        switch (carType){
            case HATCHBACK: car=new HatchBack(Location.ASIA); break;
            case SEDAN: car=new Sedan(Location.ASIA);break;
            case SUV: car=new Suv(Location.ASIA);break;
            default:System.out.println("car model not found");break;
        }
        return car;
    }
}
class EUROPECarFactory{
    public static Car buildCar(CarType carType){
        Car car=null;
        switch (carType){
            case HATCHBACK: car=new HatchBack(Location.EUROPE); break;
            case SEDAN: car=new Sedan(Location.EUROPE);break;
            case SUV: car=new Suv(Location.EUROPE);break;
            default:System.out.println("car model not found");break;
        }
        return car;
    }
}

class CarFactory{

    public static Car buildCar(Location location,CarType carType){
        Car car=null;
        switch (location){
            case EUROPE: car=EUROPECarFactory.buildCar(carType);break;
            case USA: car=USACarFactory.buildCar(carType);break;
            case ASIA: car=ASIACarFactory.buildCar(carType);break;
            default:System.out.println("No global presense in location: "+location);break;
        }
        return car;
    }
}

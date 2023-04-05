public class Singleton {
    //private static Singleton singleton=new Singleton(); //early initialization
    private static Singleton singleton_instance=null;
    String a;
    private Singleton(){
        a="i am the singleton string";
    }

    public static Singleton getSingletonObj(){
        if(singleton_instance==null){ //lazy initialization
            singleton_instance=new Singleton();
        }
        return singleton_instance;
    }

}

class TestClass{
    public static void main(String[] args){
        Singleton si=Singleton.getSingletonObj();
        System.out.println(si);
        Singleton si2=Singleton.getSingletonObj();
        System.out.println(si2);
    }
}

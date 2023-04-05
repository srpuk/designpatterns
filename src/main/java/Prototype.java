import java.util.HashMap;
import java.util.Map;

public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        Movie mov1=(Movie) PrototypeFactory.getInstance("MOVIE");
        System.out.println(mov1);
        Album alb=(Album) PrototypeFactory.getInstance("ALBUM");
        System.out.println(alb);
    }
}

interface PrototypeCloneable extends Cloneable{

    public  PrototypeCloneable clone() throws CloneNotSupportedException;

}

class Movie implements PrototypeCloneable{

    String name=null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public PrototypeCloneable clone() throws CloneNotSupportedException {
        return (Movie)super.clone();
    }
}

class Album implements PrototypeCloneable{
    String name=null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public PrototypeCloneable clone() throws CloneNotSupportedException {
        return (Album)super.clone();
    }
}

enum modelType{
    MOVIE,ALBUM
}

class PrototypeFactory{
    static Map<String,PrototypeCloneable> prototypes=new HashMap<>();

    static{
        prototypes.put(modelType.ALBUM.toString(),new Album());
        prototypes.put(modelType.MOVIE.toString(),new Movie());
    }

    public static PrototypeCloneable getInstance(String s) throws CloneNotSupportedException{
        return (PrototypeCloneable)prototypes.get(s).clone();
    }
}

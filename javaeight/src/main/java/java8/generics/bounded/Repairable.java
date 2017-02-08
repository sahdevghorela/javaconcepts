package java8.generics.bounded;


public interface Repairable {

    default void fix(){
        System.out.println("Fixing "+this.getClass().getName());
    }
}

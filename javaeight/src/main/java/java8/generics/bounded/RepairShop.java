package java8.generics.bounded;

import java.util.Arrays;
import java.util.List;

public class RepairShop {

    public  <T extends Repairable> void fixAll(List<T> list){
        list.forEach(T::fix);

    }

    public static void main(String[] args) {
        List<Repairable> repairables = Arrays.asList(new Blender(),new Furniture());

        new RepairShop().fixAll(repairables);
    }
}

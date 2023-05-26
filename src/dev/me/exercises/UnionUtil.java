package dev.me.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Cake {
    private int num;

    public Cake(int num) {
        this.num = num;
    }
}

class ChocolateCake extends Cake {

    public ChocolateCake(int num) {
        super(num);
    }
}

class StuffedChocolateCake extends ChocolateCake {

    public StuffedChocolateCake(int num) {
        super(num);
    }
}

class VanillaCake extends Cake {

    public VanillaCake(int num) {
        super(num);
    }
}

public class UnionUtil {
    public static <T extends Cake> List<T> union(List<? extends T> list1, List<? extends T> list2) {
        List<T> mergeList = new ArrayList<>();
        mergeList.addAll(list1);
        mergeList.addAll(list2);
        return mergeList;
    }

    public static void main(String[] args) {
        unionOfChocolateCakes();
        unionOfChocolateCakesAndStuffedChocolateCakes();
    }

    public static void unionOfChocolateCakes() {
        List<ChocolateCake> firstList = Arrays.asList(new ChocolateCake(1), new ChocolateCake(3));
        List<ChocolateCake> secondList = Arrays.asList(new ChocolateCake(2), new ChocolateCake(20));

        System.out.println(UnionUtil.union(firstList, secondList));
    }

    public static void unionOfChocolateCakesAndStuffedChocolateCakes()  {
        List<ChocolateCake> firstList = Arrays.asList(new ChocolateCake(1), new ChocolateCake(3));
        List<StuffedChocolateCake> secondList = Arrays.asList(new StuffedChocolateCake(2), new StuffedChocolateCake(20));
        System.out.println(UnionUtil.union(firstList, secondList));
    }

    public void unionOfStuffedChocolateCakesAndChocolateCakes_andThenUnionWithVanillaCakes_nowWithVariables() throws Exception {
        List<StuffedChocolateCake> firstList = Arrays.asList(new StuffedChocolateCake(1), new StuffedChocolateCake(3));
        List<ChocolateCake> secondList = Arrays.asList(new ChocolateCake(2), new ChocolateCake(20));
        List<VanillaCake> thirdList = Arrays.asList(new VanillaCake(11), new VanillaCake(22));

        List<ChocolateCake> chocolateUnion = UnionUtil.union(firstList, secondList);
        List<Cake> fullUnion = UnionUtil.union(chocolateUnion, thirdList);
    }
}

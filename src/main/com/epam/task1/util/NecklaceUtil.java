package main.com.epam.task1.util;

import main.com.epam.task1.model.Jewel;
import main.com.epam.task1.model.Necklace;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NecklaceUtil {

    private NecklaceUtil(){}
    
    //а почему методы static?
    //static методы в основном используются для работы со статическими полями
    //либо для каких-то математических операций - как у тебя в PriceUtils
    //в остальных случаях - это отсылка к функциональному программированию
    public static double summaryWeight(Necklace necklace){
    //хорошо сделано - молодец, но на java8
    //целевая java нашего курса java6-7
    //поэтому прошу тебя переписать через цикл for и т.д.
        return necklace.getJewels().stream()
                .mapToDouble(Jewel::getWeight)
                .sum();
    }


    public static long summaryPrice(Necklace necklace){
        return necklace.getJewels().stream()
                .mapToLong(Jewel::getPrice)
                .sum();
    }

    public static void sortByPrice(Necklace necklace){
        necklace.getJewels().sort(Comparator.comparing(Jewel::getPrice));
    }

    public static List<Jewel> findByRefractiveIndexBetween(Necklace necklace, double from, double to){
        return necklace.getJewels().stream()
                .filter(jewel -> jewel.getRefractiveIndex() >= from && jewel.getRefractiveIndex() <= to)
                .collect(Collectors.toList());
    }
}

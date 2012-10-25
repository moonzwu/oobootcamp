package org.tw.oobootcamp;

import java.util.List;

public abstract class NumberSelector {
    protected List<Integer> numberPool;


    protected NumberSelector(List<Integer> numberPool) {
        this.numberPool = numberPool;
    }

    public Integer showNextAvailableNumber() {
        Integer nextAvailableNumber = getNextAvailableNumber();
        System.out.println(nextAvailableNumber);
        return nextAvailableNumber;
    }

    protected  abstract Integer getNextAvailableNumber();

}

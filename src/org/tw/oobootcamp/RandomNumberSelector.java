package org.tw.oobootcamp;

import java.util.List;
import java.util.Random;

public class RandomNumberSelector extends NumberSelector {

    protected RandomNumberSelector(List<Integer> numberPool) {
        super(numberPool);
    }

    @Override
    protected Integer getNextAvailableNumber() {
        Random random = new Random();
        int i = random.nextInt(numberPool.size());
        return numberPool.get(i);
    }
}

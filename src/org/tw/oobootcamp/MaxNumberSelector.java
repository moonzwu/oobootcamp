package org.tw.oobootcamp;

import java.util.List;

public class MaxNumberSelector extends  NumberSelector {
    protected MaxNumberSelector(List<Integer> numberPool) {
        super(numberPool);
    }

    @Override
    protected Integer getNextAvailableNumber() {
        Integer max = -1;
        int pos = 0;
        for (int i=0 ; i<numberPool.size(); i++) {
             if (max < numberPool.get(i))  {
                 max = numberPool.get(i);
                 pos = i;
             }
        }

        numberPool.set(pos, -1);
        return max;
    }
}
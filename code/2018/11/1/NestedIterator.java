package cn.org.soloist.algorithm;

import java.util.*;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/11/1 22:22
 * @email ly@soloist.top
 * @description
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> nestedIntegers = new ArrayList<>();

    private int index = 0;


    public NestedIterator(List<NestedInteger> nestedList) {
        recursiveNested(nestedList);
    }

    public void recursiveNested(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                nestedIntegers.add(nestedInteger.getInteger());
            } else {
                recursiveNested(nestedInteger.getList());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return nestedIntegers.size() > index;
    }

    @Override
    public Integer next() {
        return nestedIntegers.get(index++);
    }
}

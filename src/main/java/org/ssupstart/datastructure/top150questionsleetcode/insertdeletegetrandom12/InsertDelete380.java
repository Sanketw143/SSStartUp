package org.ssupstart.datastructure.top150questionsleetcode.insertdeletegetrandom12;

import ch.qos.logback.core.testUtil.RandomUtil;

import java.util.ArrayList;
import java.util.Random;

public class InsertDelete380 {
    private ArrayList<Integer> list;
    public InsertDelete380() {
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(list.contains(val)) {
            return false;
        }
        return list.add(val);
    }

    public boolean remove(int val) {
        if(!list.contains(val)) {
            return false;
        }
        list.remove(Integer.valueOf(val));
        return true;
    }

    public int getRandom() {
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }
}

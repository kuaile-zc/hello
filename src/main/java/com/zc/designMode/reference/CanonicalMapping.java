package com.zc.designMode.reference;

import com.zc.designMode.reference.Element;

import java.util.WeakHashMap;

/**
 * @author CoreyChen Zhang
 * @version 2020/12/31 15:59
 * @modified
 */
public class CanonicalMapping {

    public static void main(String[] args){
        int size=1000;
        Key[] keys=new Key[size];
        WeakHashMap<Key,Value> map=new WeakHashMap<Key,Value>();
        for(int i=0;i<size;i++){
            Key k=new Key(Integer.toString(i));
            Value v=new Value(Integer.toString(i));
            if(i%3==0){
                keys[i]=k;
            }
            map.put(k, v);
        }
        System.gc();
        System.out.println("");
    }
}

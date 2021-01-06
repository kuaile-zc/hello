package com.zc.designMode.reference;

import lombok.Data;

import java.util.WeakHashMap;

/**
 * @author CoreyChen Zhang
 * @version 2020/12/31 14:59
 * @modified
 */
class Element {

    private String id;

    public Element(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return id;
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof Element && id.equals(((Element) obj).id);
    }

    @Override
    protected void finalize(){
        System.out.println("Finalizing "+ getClass().getName());
    }

}

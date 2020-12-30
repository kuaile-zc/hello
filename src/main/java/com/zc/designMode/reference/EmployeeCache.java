package com.zc.designMode.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;

/**
 * @author CoreyChen Zhang
 * @version 2020/12/30 17:06
 * @modified
 */
public class EmployeeCache {

    //一个Cache实例
    static  private EmployeeCache cache;

    //用于Cache内容的储存
    private Hashtable<String, EmployeeRef> employeeRefs;

    //垃圾Reference的队列
    private ReferenceQueue<Employee> queue;

    //继承SoftReference 使得每一个实例都具有可识别的标识
    //并且该标识与其在HashMap内的key相同
    private class EmployeeRef extends SoftReference<Employee> {
        private String _key = "";

        public EmployeeRef(Employee referent, ReferenceQueue<? super Employee> q) {
            super(referent, q);
            _key = referent.getId();
        }
    }

    //构建一个缓存器实例
    private EmployeeCache(){
        employeeRefs = new Hashtable<String, EmployeeRef>();
        queue = new ReferenceQueue<Employee>();
    }

    //单例模式取得缓存实例
    public static EmployeeCache getInstance(){
        if (cache==null){
            cache = new EmployeeCache();
        }
        return cache;
    }

    //以软引用的方式对一个Employee 对象实例进行引用并保存该引用
    private void cacheEmployee(Employee employee){
        cleanCache();//清除垃圾引用
        EmployeeRef ref = new EmployeeRef(employee, queue);
        employeeRefs.put(employee.getId(), ref);
    }

    //依据所指定的ID号，重新获取相应Employee对象实例
    public Employee getEmployee(String id){
        Employee employee = null;
        //确认缓存中是否存在软硬用，如果有，从软引用中获取
        if (employeeRefs.contains(id)){
            EmployeeRef ref = (EmployeeRef) employeeRefs.get(id);
            employee = (Employee)ref.get(); //这里添加了强引用所以如果 可达对象没有被回收那么软引用也不会被回收
        }

        //没有则构建新的
        //没有有两种情况第一没有存在缓存内存里面
        //第二 取出来的已经被回收了
        if (employee == null){
            employee = new Employee(id);
            System.out.println("Retrieve from EmployeeInfoCent id="+ id);
            this.cacheEmployee(employee);
        }

        return employee;
    }

    //清除已经被GC回收的软硬用
    private void cleanCache(){
        EmployeeRef ref = null;
        while ((ref = (EmployeeRef) queue.poll()) != null){
            employeeRefs.remove(ref._key);
        }
    }

    //清楚已经被GC的软硬用
    public void clearCache(){
        cleanCache();
        employeeRefs.clear();
        System.gc();
        System.runFinalization();
    }
}

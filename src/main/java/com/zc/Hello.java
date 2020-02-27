package com.zc;

import com.zc.sample.jackson.Car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author zc
 * @create 2019-03-04 20:16
 */
public class Hello {
    public static void main(String[] args) {
//        System.out.println("Hello1");
//        List list1 = new ArrayList<Car>();
//        list1.add(new Car("BenChi",new BigDecimal(1),3.1d));
//        System.out.println(list1.getClass());
//        System.out.println(ArrayList.class);
//        System.out.println(list1.getClass().equals(ArrayList.class));
//        System.out.println(List.class);

        int a = 12535;
        Integer i = 12535;
        System.out.println(a==i);

        HashSet<Integer> set = new HashSet<>(Arrays.asList(123456));
        int b = 123456;
        Integer c = 123456;
        System.out.println(set.contains(b));
        System.out.println(set.contains(c));

        String str = "select convert(varchar, rt.SKUGroupCatalogItemID) + '_' +convert(varchar, cirt.TableKeyID) + '='  + "
                + "isnull(( select  convert(varchar, cirp.TableKeyID) + ',' from [dbo].RatePLan rp "
                + "join [dbo].CatalogItem cirp on cirp.CatalogItemId = rp.RatePlanCatalogItemID "
                + "where rp.RoomTypeCatalogItemID = rt.RoomTypeCatalogItemID for xml path('')), ',') as String "
                + "from [dbo].RoomType rt with(nolock) join [dbo].CatalogItem cirt with(nolock) "
                + "on cirt.CatalogItemId = rt.RoomTypeCatalogItemID "
                + "join [dbo].CatalogItem cisku with(nolock) on cisku.CatalogItemId = rt.SKUGroupCatalogItemID "
                + "where cisku.CatalogItemStatusTypeID = 1 and cirt.CatalogItemStatusTypeID = 1 "
                + "order by rt.SKUGroupCatalogItemID";

        System.out.println(str);

    }
}



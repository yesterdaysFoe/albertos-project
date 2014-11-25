/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import classes.Customer;
import classes.TransactionVo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class TransactionUtil {

    private static Map<Long, Long> categories;

    public static Map<Long, Long> getCategories() {
        if (categories == null) {
        }
        return categories;
    }

    public static void setCategories(Map<Long, Long> categories) {
        TransactionUtil.categories = categories;
    }

    public static List<TransactionVo> convertToTransactionVo(List<Object[]> transactions) {
        List<TransactionVo> transactionVo = new ArrayList<>();
        for (Object[] objects : transactions) {
            TransactionVo vo = new TransactionVo();
            vo.setId((long) objects[0]);
            vo.setDate((Date) objects[1]);
            vo.setCustomerName((String) objects[2]);
            vo.setPrice((double) objects[3]);
            vo.setTotalPrice((double) objects[4]);
             vo.setInvoice((int) objects[5]);

            transactionVo.add(vo);
        }
        return transactionVo;
    }

    public static List<Customer> convertCustomer(List<Object[]> transactions) {
        List<Customer> customers = new ArrayList<>();
        for (Object[] objects : transactions) {
            Customer c = new Customer();
            c.setCompleteName((String) objects[0]);
            c.setAddress((String) objects[1]);
            c.setContactNo((String) objects[2]);
            c.setEmail((String) objects[3]);
            customers.add(c);
        }
        return customers;
    }
}

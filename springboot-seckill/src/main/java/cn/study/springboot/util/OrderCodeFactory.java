package cn.study.springboot.util;

import java.util.UUID;

/**
 * @ClassName: CodeUtil
 * @author: 10724
 * @date: Created in 2019/11/22
 * @Description: 用于生产随机码
 */
public class OrderCodeFactory {

    /*订单类别头*/
    private static final String ORDER_CODE = "1";
    /*退货类别头*/
    private static final String RETURN_CODE = "2";
    /*退款类别头*/
    private static final String REFUND_CODE = "3";
    /*未付款重新支付类别头*/
    private static final String AGAIN_CODE = "4";

    private static final String radom = UUID.randomUUID().toString();

    public static String getOrderCode(){
        StringBuffer sb = new StringBuffer();
        String orderCode = radom.replace("-","");
        sb.append(ORDER_CODE);
        sb.append(orderCode);
        return sb.toString();
    }

}

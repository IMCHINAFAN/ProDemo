package cn.study.base.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @ClassName: JSONUtils
 * @author: ilaryare
 * @date: Created in 2019/9/9 11:30
 * @Description: json工具类，用于json和对象的相互转换
 */
public class JSONUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static{
        //设置json的日期格式
        MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss"));
    }

    /**
     * 将对象转换成json字符串
     * @param data
     * @return
     */
    public static String pojo2Json(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json结果集转换成对象
     * @param str
     * @param beanType
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T json2Pojo(String str, Class<T> beanType) throws Exception {
        try {
            return MAPPER.readValue(str, beanType);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数据转换成List集合
     * @param str json数据集
     * @param beanType 对象类型
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> json2List(String str, Class<T> beanType) throws Exception {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class,beanType);
        try{
            List<T> list = MAPPER.readValue(str,javaType);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

package frank.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import frank.model.Article;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JSONUtil {

    //yyyy-MM-dd HH:mm:ss
    //序列化操作: java对象转变为json类型的字符串.
    public static String serialize(Object obj){
        ObjectMapper objectMapper = new ObjectMapper();
        //定义日期格式
        objectMapper.setDateFormat(new SimpleDateFormat(Constant.DATE_PATTERN));
        try {
            return  objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON序列化失败", e);
        }
    }

    //从我们的输入流获取数据,反序列化为指定的一个java类型对象
    public static <T> T deserialize(InputStream is, Class<T> clazz){
        ObjectMapper objectMapper = new ObjectMapper();
        //定义日期格式
        objectMapper.setDateFormat(new SimpleDateFormat(Constant.DATE_PATTERN));
        try {
            return  objectMapper.readValue(is, clazz);
        } catch (IOException e) {
            throw new RuntimeException("JSON反序列化失败", e);
        }

    }
    public static void main(String[] args) {
        Article article = new Article();
        article.setUserId(3);
        article.setContent("问问我");
        article.setCreateTime(new Date());
        String json = serialize(article);
        System.out.println(json);

    }
}

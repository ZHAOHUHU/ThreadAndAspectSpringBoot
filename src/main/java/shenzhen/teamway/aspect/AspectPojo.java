package shenzhen.teamway.aspect;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface AspectPojo {
    /**
     * @Author: Zhao Hong Ning
     * @Description:何种场景下打印日志
     * @Date: 2019/4/18
     * @param: null
     * @return:
     */
    String modoule();
}

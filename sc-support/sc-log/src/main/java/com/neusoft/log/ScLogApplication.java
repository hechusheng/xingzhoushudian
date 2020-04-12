package com.neusoft.log;

import com.neusoft.core.exception.ScExceptionHandle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * <p>程序入口文件</p>
 * <p>创建日期：2018-02-09</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@SpringBootApplication
public class ScLogApplication {

    /**
     * 异常处理器
     *
     * @return
     */
    @Bean
    public ScExceptionHandle scExceptionHandle() {
        return new ScExceptionHandle();
    }

    public static void main(String[] args) {
        SpringApplication.run(ScLogApplication.class, args);
    }
}

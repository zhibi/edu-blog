package edu.blog.config;

import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static freemarker.template.Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS;

/**
 * @author 执笔
 * @date 2019/4/20 22:17
 */
@Configuration
public class FreemarkerConfig {

    /**
     * 配置freemarker 支持 java8 时间
     *
     * @param configurer
     */
    @Autowired
    private void configureFreemarkerConfigurer(FreeMarkerConfig configurer) {
        configurer.getConfiguration().setObjectWrapper(new CustomObjectWrapper(DEFAULT_INCOMPATIBLE_IMPROVEMENTS));
    }

    /**
     * 自定义转换
     */
    private class CustomObjectWrapper extends DefaultObjectWrapper {
        public CustomObjectWrapper(Version incompatibleImprovements) {
            super(incompatibleImprovements);
        }
        @Override
        public TemplateModel wrap(Object obj) throws TemplateModelException {
            if (obj instanceof LocalDateTime) {
                Timestamp timestamp = Timestamp.valueOf((LocalDateTime) obj);
                return new SimpleDate(timestamp);
            }
            if (obj instanceof LocalDate) {
                Date date = Date.valueOf((LocalDate) obj);
                return new SimpleDate(date);
            }
            if (obj instanceof LocalTime) {
                Time time = Time.valueOf((LocalTime) obj);
                return new SimpleDate(time);
            }
            return super.wrap(obj);
        }
    }
}

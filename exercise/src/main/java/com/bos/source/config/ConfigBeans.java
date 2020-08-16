package com.bos.source.config;

import com.bos.source.bean.Apple;
import com.bos.source.bean.Linux;
import com.bos.source.bean.Orange;
import com.bos.source.bean.Windows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@Import({Apple.class}) //com.bos.source.bean.Apple
public class ConfigBeans {
    @Bean
    @Conditional(Linux.class)
    Linux linux(){
        return  new Linux();
    }


    @Bean
    Orange Orange5566(){  // Orange5566
        return  new Orange();
    }


    @Bean
    @Conditional(Windows.class)
    Windows windows(){
        return  new Windows();
    }
}

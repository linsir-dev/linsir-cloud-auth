package com.linsir.auth;

import com.linsir.base.core.launch.LinsirApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName : AuthApplication
 * @Description :
 * @Author : Linsir
 * @Date: 2023-12-22 15:55
 */

@SpringBootApplication(scanBasePackages="com.linsir")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.linsir.saas.feign"})
public class AuthApplication {

    public static void main(String[] args) {
        LinsirApplication.run("linsir-auth-server", AuthApplication.class,args);
    }
}

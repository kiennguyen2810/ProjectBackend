/**
 * 
 */
package fpt.fsoft.group.training.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author DuongBN
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "fpt.fsoft.group.training.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {

}

package org.fosdem.steinhauer.demo.spring.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
@EnableWebSecurity
class FosdemWebSecurityConfigurerAdapter @Autowired constructor() : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()
            ?.anyRequest()?.authenticated()
            ?.and()?.httpBasic()
    }

    @Bean
    override fun userDetailsService(): UserDetailsService {
        val user = User.withDefaultPasswordEncoder()
            .username("fosdem")
            .password("Fosdem.2021!")
            .roles("USER").build()

        return InMemoryUserDetailsManager(user)
    }
}
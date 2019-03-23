package com.hikaridemo.demo.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "db2EntityManagerFactory",
        transactionManagerRef = "db2TransactionManager",
        basePackages = { "com.hikaridemo.demo.db2Repository" }
)
public class Db2Config {

    @Bean(name = "db2DataSource")
    @ConfigurationProperties(prefix = "spring.second-datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/db2")
                .username("root")
                .password("root")
                .build();
    }

    @Bean(name = "db2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    db2EntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("db2DataSource") DataSource dataSource
    ) {
        return
                builder
                        .dataSource(dataSource)
                        .packages("com.hikaridemo.demo.db2Entities")
                        .persistenceUnit("db2")
                        .build();
    }
    @Bean(name = "db2TransactionManager")
    public PlatformTransactionManager db2TransactionManager(
            @Qualifier("db2EntityManagerFactory") EntityManagerFactory
                   db2EntityManagerFactory
    ) {
        return new JpaTransactionManager(db2EntityManagerFactory);
    }
}

package com.example.csvdatatodb.config;

import com.example.csvdatatodb.model.User;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<User> reader(){
        FlatFileItemReader<User> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("record.csv"));
        reader.setLineMapper(getLineMapper());
        reader.setLinesToSkip(1);
        return reader;
    }

    private LineMapper<User> getLineMapper(){
         DefaultLineMapper<User> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(delimitedLineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetter);

    }
}

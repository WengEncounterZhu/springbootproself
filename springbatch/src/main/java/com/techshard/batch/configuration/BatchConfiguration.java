package com.techshard.batch.configuration;

import com.techshard.batch.dao.entity.Bank;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<Bank> reader() {
        return new FlatFileItemReaderBuilder<Bank>()
                .name("bankItemReader")
                .resource(new ClassPathResource("bank.csv"))
                .delimited()
                .names(new String[]{"bankName", "location"})
                .lineMapper(lineMapper())
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Bank>() {{
                    setTargetType(Bank.class);
                }})
                .build();
    }

    @Bean
    public LineMapper<Bank> lineMapper() {

        final DefaultLineMapper<Bank> defaultLineMapper = new DefaultLineMapper<>();
        final DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(";");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[] {"bankName", "location"});

        final BankFieldSetMapper fieldSetMapper = new BankFieldSetMapper();
        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }

    @Bean
    public BankProcessor processor() {
        return new BankProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Bank> writer(final DataSource dataSource) {
        System.out.println("写数据。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
        return new JdbcBatchItemWriterBuilder<Bank>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO Bank (bankname, location) VALUES (:bankName, :location)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importBankJob(NotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importBankJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Bank> writer) {
        System.out.println("每次度10条提交");
        return stepBuilderFactory.get("step1")
                .<Bank, Bank> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}

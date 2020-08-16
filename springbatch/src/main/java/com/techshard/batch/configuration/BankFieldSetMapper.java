package com.techshard.batch.configuration;

import com.techshard.batch.dao.entity.Bank;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;

@Component
public class BankFieldSetMapper implements FieldSetMapper<Bank> {

    @Override
    public Bank mapFieldSet(FieldSet fieldSet) {
        final Bank bank = new Bank();
        bank.setBankName(fieldSet.readString("bankName"));
        bank.setLocation(fieldSet.readString("location"));
       /* voltage.setVolt(fieldSet.readBigDecimal("volt"));
        voltage.setTime(fieldSet.readDouble("time"));*/
        return bank;

    }
}

package com.techshard.batch.configuration;

import com.techshard.batch.dao.entity.Bank;
import org.springframework.batch.item.ItemProcessor;


public class BankProcessor implements ItemProcessor<Bank, Bank> {

    @Override
    public Bank process(final Bank bank) {

        String bankName=null;

        Bank bk = new Bank();
        if( bank.getBankName().trim().equalsIgnoreCase("BOS") ){
            bankName ="上海银行";
            bk.setBankName(bankName);
            bk.setLocation(bank.getLocation());
        }else{
            bk.setBankName(bank.getBankName());
            bk.setLocation(bank.getLocation());
        }
        return bk;
    }
}

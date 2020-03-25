package com.example.demo.LoanServiceImpl;

import java.math.BigDecimal;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.simple.JSONObject;

import com.example.demo.LoanService.LoanService;

public class LoanServiceImpl {
	LoanService loanService = new LoanService();

	public JSONObject InserToKafka(Integer tenure, BigDecimal ticketSize) {

		// fee
		Integer ticketSizeToInt = Integer.valueOf(ticketSize.intValue());
		double feeTypeDouble = (0.02 * ticketSizeToInt * tenure);
		BigDecimal fee = new BigDecimal(feeTypeDouble);

		// totaLoan
		double totaLoanTypeDouble = ticketSizeToInt + feeTypeDouble;
		BigDecimal totaLoan = new BigDecimal(totaLoanTypeDouble);

		// installmentPerMonth
		double installmentPerMonthTypeDouble = totaLoanTypeDouble / tenure;
		BigDecimal installmentPerMonth = new BigDecimal(installmentPerMonthTypeDouble);

		// status
		String status = "SUBMITTED";

		//mapping data json
		JSONObject json = new JSONObject();
		json.put("tenure", tenure);
		json.put("ticketSize", ticketSize);
		json.put("fee", fee);
		json.put("totaLoan", totaLoan);
		json.put("installmentPerMonth", installmentPerMonth);
		json.put("status", status);

		// proses insert to kafka
//		Producer<String, String> producer = new KafkaProducer<String, String>(loanService.KafkaConfig());
//		producer.send(new ProducerRecord<String, String>(loanService.TopicKafka(), json.toJSONString()));
//		producer.close();

		return json;
	}
}

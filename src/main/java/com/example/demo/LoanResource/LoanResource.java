package com.example.demo.LoanResource;

import java.math.BigDecimal;

import org.json.simple.JSONObject;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Loan.Loan;
import com.example.demo.LoanServiceImpl.LoanServiceImpl;

@RestController
@RequestMapping("/funesia")
public class LoanResource {
	LoanServiceImpl loanServiceImpl = new LoanServiceImpl();

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public JSONObject InsertData(@RequestBody Loan loan) {
		Integer tenure = loan.getTenure();
		BigDecimal ticketSize = loan.getTicketSize();

		return loanServiceImpl.InserToKafka(tenure, ticketSize);
	}

}

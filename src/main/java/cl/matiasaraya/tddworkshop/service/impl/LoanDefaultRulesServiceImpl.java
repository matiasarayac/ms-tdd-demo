package cl.matiasaraya.tddworkshop.service.impl;

import org.springframework.stereotype.Service;

import cl.matiasaraya.tddworkshop.elements.Loan;
import cl.matiasaraya.tddworkshop.service.LoanDefaultRulesService;

@Service("loanDefaultService")
public class LoanDefaultRulesServiceImpl implements LoanDefaultRulesService {

	@Override
	public boolean isInDefaultForDaysPastDue(Loan loan) {
		
		if("hipotecario".equals(loan.getType())) return loan.getDaysPastDue() > 120;
		else return loan.getDaysPastDue() > 90;		
	}

}

package cl.matiasaraya.tddworkshop.service.impl;

import org.springframework.stereotype.Service;

import cl.matiasaraya.tddworkshop.elements.Loan;
import cl.matiasaraya.tddworkshop.service.LoanDefaultRulesService;

@Service("loanDefaultService")
public class LoanDefaultRulesServiceImpl implements LoanDefaultRulesService {

	@Override
	public boolean isInDefaultForDaysPastDue(Loan loan) {
		
		return loan.getDaysPastDue() > 90;
	}

}

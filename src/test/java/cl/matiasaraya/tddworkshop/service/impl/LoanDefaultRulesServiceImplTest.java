package cl.matiasaraya.tddworkshop.service.impl;

import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import cl.matiasaraya.tddworkshop.elements.Loan;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class LoanDefaultRulesServiceImplTest {
	
	@InjectMocks
	LoanDefaultRulesServiceImpl loanDefaultRulesServiceImpl;
	
	private Loan loan;
	
	@Before
	public void init() {
		loan = new Loan();
	}
	
	
	@Test
	public void isInDefaultForDaysPastDueConsumo91Test(){		
		loan.setType("consumo");
		loan.setDaysPastDue(91);
		
		assertThat(loanDefaultRulesServiceImpl.isInDefaultForDaysPastDue(loan)).isTrue();
	}
	
	@Test
	public void isInDefaultForDaysPastDueConsumo90Test(){		
		loan.setType("consumo");
		loan.setDaysPastDue(90);
		
		assertThat(loanDefaultRulesServiceImpl.isInDefaultForDaysPastDue(loan)).isFalse();
	}
	
	@Test
	public void isInDefaultForDaysPastDueHipotecario119Test(){		
		loan.setType("hipotecario");
		loan.setDaysPastDue(119);
		
		assertThat(loanDefaultRulesServiceImpl.isInDefaultForDaysPastDue(loan)).isFalse();
	}
	
	@Test
	public void isInDefaultForDaysPastDueHipotecario121Test(){		
		loan.setType("hipotecario");
		loan.setDaysPastDue(121);
		
		assertThat(loanDefaultRulesServiceImpl.isInDefaultForDaysPastDue(loan)).isTrue();
	}
	
	@Test
	public void isInDefaultForDaysPastDueHipotecario120Test(){		
		loan.setType("hipotecario");
		loan.setDaysPastDue(120);
		
		assertThat(loanDefaultRulesServiceImpl.isInDefaultForDaysPastDue(loan)).isFalse();
	}

}

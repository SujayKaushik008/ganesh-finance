package com.oracle.finance;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.oracle.finance.entity.LoanAccount;
import com.oracle.finance.entity.LoanAccountRequest;
import com.oracle.finance.entity.LoanApplication;
import com.oracle.finance.service.LoanService;

@SpringBootTest
class GaneshFinanceApplicationTests {

	
	@MockBean
	private LoanService loanService;
	
	// Instance 1
	LoanApplication loanApp1 = new LoanApplication("LA123456", "Clerk001", "Customer001", 1, 0, 36, new Date(System.currentTimeMillis()), 5.2f, 50000.0f, null);

	// Instance 2
	LoanApplication loanApp2 = new LoanApplication("LA789012", "Clerk002", "Customer002", 2, 1, 24, new Date(System.currentTimeMillis()), 4.8f, 75000.0f, null);

	// Instance 3
	LoanApplication loanApp3 = new LoanApplication("LA345678", "Clerk003", "Customer003", 3, 2, 48, new Date(System.currentTimeMillis()), 6.0f, 100000.0f, null);

	// Instance 4
	LoanApplication loanApp4 = new LoanApplication("LA678901", "Clerk004", "Customer004", 1, 0, 60, new Date(System.currentTimeMillis()), 5.5f, 90000.0f, null);

	// Instance 5
	LoanApplication loanApp5 = new LoanApplication("LA234567", "Clerk005", "Customer005", 2, 1, 12, new Date(System.currentTimeMillis()), 4.5f, 60000.0f, null);
	
	// Instance 1
	LoanAccount loanAccount1 = new LoanAccount("LA123456789", "Customer001", "Manager001", "LA123456", 1, 50000.0f, 50000.0f, 2500.0f, 5.2f, new Date(System.currentTimeMillis()));

	// Instance 2
	LoanAccount loanAccount2 = new LoanAccount("LA234567890", "Customer002", "Manager002", "LA789012", 2, 75000.0f, 75000.0f, 3750.0f, 4.8f, new Date(System.currentTimeMillis()));

	// Instance 3
	LoanAccount loanAccount3 = new LoanAccount("LA345678901", "Customer003", "Manager003", "LA345678", 3, 100000.0f, 100000.0f, 5000.0f, 6.0f, new Date(System.currentTimeMillis()));


	List<LoanApplication> loanApps = new ArrayList<LoanApplication>();
	List<LoanAccount> loanAccounts = new ArrayList<LoanAccount>();
	@BeforeEach
	void setUp() {
		loanApps.add(loanApp1);
		loanApps.add(loanApp2);
		loanApps.add(loanApp3);
		loanAccounts.add(loanAccount1);
		loanAccounts.add(loanAccount2);
		loanAccounts.add(loanAccount3);
	}
	
	@Test
	void getAllLoanApplicationTest() {
		when(loanService.getAllLoanApplicationService()).thenReturn(loanApps);
		
		List<LoanApplication> actualResult = loanService.getAllLoanApplicationService();
		assertNotNull(actualResult);
		assertEquals(actualResult.size(),loanApps.size());
	}
	
	@Test
	void searchApplicationByNumberTest() {
		when(loanService.searchLoanApplicationByNumberService(loanApp1.getLoan_application_number())).thenReturn(loanApp1);
		
		LoanApplication actualResult = loanService.searchLoanApplicationByNumberService(loanApp1.getLoan_application_number());
		assertEquals(actualResult, loanApp1);
	}
	
	@Test
	void searchApplicationByTypeTest() {
		List<LoanApplication> expectedResult = new ArrayList<LoanApplication>();
		expectedResult.add(loanApp1);
		expectedResult.add(loanApp4);
		when(loanService.searchLoanApplicationByTypeService(loanApp1.getLoan_type())).thenReturn(expectedResult);
		
		List<LoanApplication> actualResult = loanService.searchLoanApplicationByTypeService(loanApp1.getLoan_type());
		for(LoanApplication resultApp : actualResult) {
			assertEquals(resultApp.getLoan_type(), loanApp1.getLoan_type());
		}
	}
	
	@Test
	void getLoanAccountsTest() {
		LoanAccountRequest loanAccountRequest1 = new LoanAccountRequest(1,"ORFIN1","Customer003");
		LoanAccountRequest loanAccountRequest2 = new LoanAccountRequest(2,"ORFIN1","Customer003");
		List<LoanAccount> loanAccounts1 = new ArrayList<LoanAccount>();
		loanAccounts1.add(loanAccount3);
		when(loanService.getLoanAccount(loanAccountRequest2)).thenReturn(loanAccounts1);
		when(loanService.getLoanAccount(loanAccountRequest1)).thenReturn(loanAccounts);
		
		List<LoanAccount> actualResult1 = loanService.getLoanAccount(loanAccountRequest1);
		List<LoanAccount> actualResult2 = loanService.getLoanAccount(loanAccountRequest2);
		
		assertEquals(actualResult1.size(), loanAccounts.size());
		assertEquals(actualResult2.size(), loanAccounts1.size());
	}

}

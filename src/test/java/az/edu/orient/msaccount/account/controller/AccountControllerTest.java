package az.edu.orient.msaccount.account.controller;

import az.edu.orient.msaccount.account.model.AccountCreateRequest;
import az.edu.orient.msaccount.account.model.Currency;
import az.edu.orient.msaccount.account.service.AccountService;
import az.edu.orient.msaccount.account.validation.AccountCreateValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest
class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountService accountService;
    @MockBean
    AccountCreateValidation accountCreateValidation;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getAccounts() {

    }

    @Test
    void getAccountById() {
    }

    @Test
    void addAccount() throws Exception {
        AccountCreateRequest accountCreateRequest = new AccountCreateRequest();
        accountCreateRequest.setName("Nemet");
        accountCreateRequest.setCurrency(Currency.USD);
        accountCreateRequest.setBalance(BigDecimal.valueOf(500));

       MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(accountCreateRequest))
                 ).andReturn();
       assertEquals(mvcResult.getResponse().getStatus(), HttpStatus.CREATED.value());
    }

    @Test
    void updateAccount() {
    }

    @Test
    void deleteAccount() {
    }
}
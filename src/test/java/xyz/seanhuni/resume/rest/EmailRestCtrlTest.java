package xyz.seanhuni.resume.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import xyz.seanhuni.resume.exception.EmailException;
import xyz.seanhuni.resume.pojo.req.EmailForm;
import xyz.seanhuni.resume.pojo.resp.RespDto;
import xyz.seanhuni.resume.service.EmailProcessService;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Log4j2
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EmailRestCtrlTest {
    private final EmailForm emailForm = new EmailForm();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmailProcessService preprocessService;


    @BeforeEach
    void setUp() {
        emailForm.setName("Troy");
        emailForm.setEmail("troy201@msn.com");
        emailForm.setSubject("Testing Email Subject");
        emailForm.setMessage("Testing Message Body.");
    }

    @Test
    void givenEmailProcessService_whenSendingEmail_withErrors_thenReturnSuccess_withMessageSource() throws Exception {
        RespDto resp = new RespDto("Troy", true, "Success", null, LocalDateTime.now());
        when(preprocessService.preprocessAndSendEmail(anyString(), anyString(), anyString(), anyString())).thenReturn(resp);

        ObjectMapper emailJsonObj = new ObjectMapper();
        String jsonEmail = emailJsonObj.writeValueAsString(emailForm);

        MvcResult mvcResult = mockMvc.perform(post("/api/v1/send-email")
                .contentType("application/json;charset=UTF-8")
                .content(jsonEmail))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        verify(preprocessService, times(1)).preprocessAndSendEmail("Troy", "troy201@msn.com", "Testing Email Subject", "Testing Message Body.");
        log.info("Positive Response: {}", mvcResult.getResponse());
    }

    @Test
    void givenEmailProcessService_whenSendingEmail_withErrors_thenThrowEmailException_withErrorMessageSource() throws Exception {
        RuntimeException rte = new RuntimeException("Unchecked Exception");
        doThrow(new EmailException("Alice", rte.getMessage())).when(preprocessService).preprocessAndSendEmail(anyString(), anyString(), anyString(), anyString());

        emailForm.setEmail("troy201@msn.com");
        ObjectMapper emailJsonObj = new ObjectMapper();
        String jsonEmail = emailJsonObj.writeValueAsString(emailForm);

        MvcResult mvcResult = mockMvc.perform(post("/api/v1/send-email")
                .contentType("application/json;charset=UTF-8")
                .content(jsonEmail))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        verify(preprocessService, times(1)).preprocessAndSendEmail("Troy", "troy201@msn.com", "Testing Email Subject", "Testing Message Body.");
        log.info("Negative Response: {}", mvcResult.getResponse());
    }

    @Test
    void givenEmailProcessService_whenSendingEmail_withEmailErrors_thenReturnMessageSource_withValidationErrors() throws Exception {
        emailForm.setEmail("troy201_msn.com");
        ObjectMapper emailJsonObj = new ObjectMapper();
        String jsonEmail = emailJsonObj.writeValueAsString(emailForm);

        MvcResult mvcResult = mockMvc.perform(post("/api/v1/send-email")
                .contentType("application/json;charset=UTF-8")
                .content(jsonEmail))
                .andDo(print())
                .andExpect(status().isBadRequest()) //Invalid Request! Failed validation! Please check all the email-fields & try again.
                .andExpect(jsonPath("$.name").doesNotExist())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.respMsg").value("Invalid Request! Failed validation! Please check all the email-fields & try again."))
                .andExpect(jsonPath("$.errors[0].field").value("email"))
                .andExpect(jsonPath("$.errors[0].errMsg").value("must be a well-formed email address"))
                .andExpect(jsonPath("$.errors[0].rejectedValue").value("troy201_msn.com"))
                .andReturn();

        verify(preprocessService, times(0)).preprocessAndSendEmail(anyString(), anyString(), anyString(), anyString());
        log.info("Negative Response: {}", mvcResult.getResponse());
    }
}
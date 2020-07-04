package xyz.seanhuni.resume.rest;

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
import xyz.seanhuni.resume.service.PreProcessService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Log4j2
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EmailRestCtrlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PreProcessService preprocessService;


    @BeforeEach
    void setUp() {

    }

    @Test
    void sendEmail() throws Exception {
        RuntimeException rte = new RuntimeException("Unchecked Exception");
        doThrow(new EmailException("Alice", rte.getMessage())).when(preprocessService).preprocessAndSendEmail(anyString(), anyString(), anyString(), anyString());

        MvcResult mvcResult = mockMvc.perform(post("/api/v1/send-email")
                .contentType("application/json;charset=UTF-8")
                .content("{}"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        log.info("Response: {}", mvcResult.getResponse());
    }
}
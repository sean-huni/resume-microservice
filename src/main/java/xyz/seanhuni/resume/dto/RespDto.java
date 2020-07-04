package xyz.seanhuni.resume.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespDto {
    private String name;
    @Getter(AccessLevel.NONE)
    private Boolean success;
    private String respMsg;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime timestamp;

    public Boolean isSuccess() {
        return this.success;
    }
}
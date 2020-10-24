package xyz.seanhuni.resume.pojo.resp;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespDto {
    private String name;
    @Getter(AccessLevel.NONE)
    private Boolean success;
    private String respMsg;
    @Setter(AccessLevel.NONE)
    private List<Error> errors;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty
    private LocalDateTime timestamp;

    public Boolean isSuccess() {
        return this.success;
    }
}
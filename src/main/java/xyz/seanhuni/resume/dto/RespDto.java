package xyz.seanhuni.resume.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RespDto {

    @Getter(AccessLevel.NONE)
    private Boolean success;
    private String respMsg;

    public Boolean isSuccess() {
        return this.success;
    }

}
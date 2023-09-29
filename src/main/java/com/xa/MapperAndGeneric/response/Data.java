package com.xa.MapperAndGeneric.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data<T> {

    protected T body;
    protected Long totalCount;
    protected boolean isSuccess;

    protected APIErrorDTO error;

    public Data(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    
}

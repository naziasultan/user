package com.user.service.model;

import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
public class ResponseDTO {
    private Integer version;
}

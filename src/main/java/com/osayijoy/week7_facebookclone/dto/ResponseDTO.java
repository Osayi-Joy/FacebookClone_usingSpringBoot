package com.osayijoy.week7_facebookclone.dto;

import com.osayijoy.week7_facebookclone.models.User;
import lombok.Data;

@Data
public class ResponseDTO {
    private String message;
    private User user;
    private boolean status;
}

package com.yasemindmrts.odev1.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
public class User {

    @Id
    private long id;

    @Size(max = 50)
    private String name;

    @Size(max = 50)
    private String surname;

    @Size(max = 15)
    private String eMail;

    @Size(max = 50)
    private String phoneNumber;

    private Date bornDate;

    private boolean isActive;


}

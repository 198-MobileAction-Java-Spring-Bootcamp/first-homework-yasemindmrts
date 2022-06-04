package com.yasemindmrts.odev1.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@Data
public class UserComment {

    @Id
    private long id;

    @Size(max = 500)
    private String comment;

    private Date commentDate;

    private long productId;

    private User user;


}

package org.softwaremanager.backoffice.auth.web.dto;

import lombok.Data;
import org.softwaremanager.backoffice.auth.domain.User;

@Data
public class UserInfoDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public UserInfoDto(){}

    public UserInfoDto(User user){
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

}

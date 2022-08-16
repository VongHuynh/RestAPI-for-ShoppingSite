package com.gearshop.ShoppingProject.DTO;

import lombok.Data;

@Data
public class AccountDTO extends AbstractDTO<AccountDTO> {
    private Integer id;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String photo;
    private String address;
    private Boolean activated;
}

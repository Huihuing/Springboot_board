package com.korea.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class member {
    private int id;
    private String loginId;
    private String loginPw;
    private String nickname;
    private String regDate;
}

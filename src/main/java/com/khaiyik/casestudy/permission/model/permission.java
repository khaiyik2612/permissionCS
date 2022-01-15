package com.khaiyik.casestudy.permission.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class permission {
    private @Getter @Setter String permission;
    private @Getter @Setter String email;
    private @Getter @Setter boolean enable;

}

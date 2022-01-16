package com.khaiyik.casestudy.permission.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class permissions {
    private @Getter @Setter String featureName;
    private @Getter @Setter String email;
    private @Getter @Setter boolean enable;

}

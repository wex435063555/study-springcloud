package com.wrx.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {
    private Long id;
    private String dname;
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}

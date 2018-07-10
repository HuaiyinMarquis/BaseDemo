package com.exampleDemo.SerializationTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

// implements Serializable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SuperUser{
    private String sex;
}

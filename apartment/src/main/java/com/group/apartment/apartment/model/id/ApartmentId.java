package com.group.apartment.apartment.model.id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class ApartmentId implements Serializable {
    private int doorNo;
    private String aptno;
}

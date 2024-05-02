package com.paolacodes.customerbaseapi.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class DeliveryRecipient {

    @NotBlank
    @Column(name = "name_recipient")
    private String nameRecipient;

    @NotBlank
    @Column(name = "adress_recipient")
    private String adress;

    @NotBlank
    @Column(name = "adress_complement_recipient")
    private String adressComplement;

    @NotBlank
    @Column(name = "country_recipient")
    private String country;

}

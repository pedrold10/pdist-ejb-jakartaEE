package com.gugawag.pdist.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Mensagem {

    @Id
    private long id;
    private String texto;

}

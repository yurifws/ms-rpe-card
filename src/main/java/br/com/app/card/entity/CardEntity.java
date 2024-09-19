package br.com.app.card.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.app.card.enuns.StatusEnum;
import lombok.Data;

@Data
@Entity
@Table(name = "card")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long id;

    @Column(name = "card_number")
    private String number;

    @Column(name = "card_password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_status")
    private StatusEnum status;

    @Column(name = "card_holder_name")
    private String holderName;

    @Column(name = "card_date_created")
    private LocalDateTime dateCreated;

    @Column(name = "card_date_updated")
    private LocalDateTime dateUpdated;

    @OneToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    
}

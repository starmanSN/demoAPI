package com.example.demoapi.entity;

import com.example.demoapi.entity.enums.OrderStatus;
import com.example.demoapi.entity.security.AccountUser;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "shop_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "recipient_username")
    private String recipientName;

    @Column(name = "recipient_mail")
    private String recipientMail;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AccountUser accountUser;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;
}

package com.wedding.api.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "tb_value_undangan")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValueUndanganEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_undangan")
    private Integer idUndangan;
    @OneToOne
    @JoinColumn(name = "id_component", referencedColumnName = "id", updatable = false, insertable = false)
    private ComponentEntity component;
    @OneToOne
    @JoinColumn(name = "id_props", referencedColumnName = "id", updatable = false, insertable = false)
    private PropsEntity props;
    @Column(name = "value")
    private String value;
    @Column(name = "created_at")
    private LocalDateTime created_at;
}

package com.wedding.api.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_undangan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UndanganEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_content_undangan")
    private int idUndanganContent;
    @Column(name = "del_flag")
    private boolean delFlag;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @OneToMany
    @JoinColumn(name = "id_undangan", referencedColumnName = "id_content_undangan", insertable = false, updatable = false)
    private List<ValueUndanganEntity> valueUndanganEntity;
}

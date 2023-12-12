package com.company.model.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@Table(name = "tasks")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String taskName;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dedline;
    @Column(nullable = false)
    private String taskText;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Status> statusList;
}

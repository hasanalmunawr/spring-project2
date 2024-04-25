package hasanalmunawr.Dev.springproject2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hasanalmunawr.Dev.springproject2.domain.RequestContext;
import hasanalmunawr.Dev.springproject2.exception.ApiException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.AlternativeJdkIdGenerator;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public abstract class Auditable {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Long id;
    private String referenceId = new AlternativeJdkIdGenerator().generateId().toString();

    @CreatedBy
    @NotNull
    @Column(name = "created_by",nullable = false, updatable = false)
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    @CreationTimestamp
    @NotNull
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void beforePersist() {
        var userId = 1L;
        if (userId == RequestContext.getUserId()) {
            throw new ApiException("Cannot Persist Entity without user Id in Request Context for this thread");
        }
        setCreatedAt(now());
        setCreatedBy(userId);
        setUpdatedBy(userId);
        setUpdatedAt(now());
    }

    @PreUpdate
    public void beforeUpdate() {
        var userId = 1L;
        if (userId == RequestContext.getUserId()) {
            throw new ApiException("Cannot Update Entity without user Id in Request Context for this thread");
        }
        setUpdatedBy(userId);
        setUpdatedAt(now());
    }


}

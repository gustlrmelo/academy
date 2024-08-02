package com.ctw.workstation.booking.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.teammember.entity.TeamMember;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "t_booking")
public class Booking {

    //rack_id, requester_id, book_from, book_to, created_at, modified_at
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "rack_id", nullable = false)
    private UUID rackId;

    @Column(name = "requester_id", nullable = false)
    private UUID requesterId;

    @Column(name = "book_from")
    private LocalDateTime bookFrom;

    @Column(name = "book_to")
    private LocalDateTime bookTo;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rack_id", nullable = false, updatable = false, insertable = false)
    private Rack rack;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id", nullable = false, updatable = false, insertable = false)
    private TeamMember teamMember;


    public UUID getiD() {
        return id;
    }

    public void setiD(UUID iD) {
        this.id = iD;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    public UUID getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(UUID requesterId) {
        this.requesterId = requesterId;
    }

    public LocalDateTime getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(LocalDateTime bookFrom) {
        this.bookFrom = bookFrom;
    }

    public LocalDateTime getBookTo() {
        return bookTo;
    }

    public void setBookTo(LocalDateTime bookTo) {
        this.bookTo = bookTo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.modifiedAt = LocalDateTime.now();
    }
}

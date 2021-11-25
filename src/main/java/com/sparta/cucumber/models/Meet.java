package com.sparta.cucumber.models;

import com.sparta.cucumber.dto.MeetRequestDto;
import com.sparta.cucumber.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Builder
@Entity(name = "meet")
public class Meet extends Timestamped {
    @Id
    @Column(name = "meetId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "commentUser")
    private User commenter;
    @ManyToOne
    @JoinColumn(name = "targetArticle")
    private Article article;
}
package com.sparta.cucumber.models;

import com.sparta.cucumber.dto.ReviewRequestDto;
import com.sparta.cucumber.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "review")
public class Review extends Timestamped {
    @Id
    @Column(name = "reviewId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "reviewUser")
    private User reviewUser;
    @ManyToOne
    @JoinColumn(name = "reviewTarget")
    private User reviewTargetUser;
    private Integer score;
    private String content;

    @Builder
    public Review(User from, User to, Integer star, String content) {
        this.reviewUser = from;
        this.reviewTargetUser = to;
        this.score = star;
        this.content = content;
    }
}

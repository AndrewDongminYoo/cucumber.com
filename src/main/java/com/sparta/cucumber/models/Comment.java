package com.sparta.cucumber.models;

import com.sparta.cucumber.dto.CommentRequestDto;
import com.sparta.cucumber.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity(name="comment")
@NoArgsConstructor
public class Comment extends Timestamped {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn
    private User user;
    @Column
    private String content;
    @ManyToOne
    @JoinColumn
    private Article article;

    public Comment (User user, Article article, String content) {
        this.user = user;
        this.article = article;
        this.content = content;
    }
}
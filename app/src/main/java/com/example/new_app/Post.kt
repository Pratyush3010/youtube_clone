package com.example.new_app

data class Post(
    val comment: Comment,
    val creator: Creator,
    val postId: String,
    val reaction: Reaction,
    val submission: Submission
)
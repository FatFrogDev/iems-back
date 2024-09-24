package com.fatfrogdev.iemsbackend.exceptions.leaderboard;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class LeaderboardDetailsNotFoundException extends BaseException {
    public LeaderboardDetailsNotFoundException(String message) {
        super(message);
    }
}
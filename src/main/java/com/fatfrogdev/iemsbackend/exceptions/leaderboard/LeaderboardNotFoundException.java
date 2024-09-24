package com.fatfrogdev.iemsbackend.exceptions.leaderboard;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class LeaderboardNotFoundException extends BaseException {
        public LeaderboardNotFoundException(String message) {
            super(message);
        }
}
package com.sii.Factory;

import com.sii.Models.User;

public class UserFactory {

    public static User getTestUser() {
        return new User();
    }
}

package com.oracle.finance.secure.repository;

import com.oracle.finance.secure.model.User;

public interface UserRepository  {
    User findByUsername(String username);
    User save(User user);
}

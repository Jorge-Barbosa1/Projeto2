package org.example.proj2webapp.DTO;

import java.math.BigInteger;

public class UserDTO {
    private static BigInteger adminId;
    private static Integer userId;

    public static BigInteger getAdminId() {
        return adminId;
    }
    public static void setAdminId(BigInteger adminId) {
        UserDTO.adminId = adminId;
    }

    public static Integer getUserId() {
        return userId;
    }

    public static void setUserId(Integer userId) {
        UserDTO.userId = userId;
    }
}

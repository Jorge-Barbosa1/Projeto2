package com.example.proj2ui.DTO;

import java.math.BigInteger;

public class SessionInfo {
    private static BigInteger adminId;
    private static Integer userId;

    public static BigInteger getAdminId() {
        return adminId;
    }
    public static void setAdminId(BigInteger adminId) {
        SessionInfo.adminId = adminId;
    }

    public static Integer getUserId() {
        return userId;
    }

    public static void setUserId(Integer userId) {
        SessionInfo.userId = userId;
    }
}

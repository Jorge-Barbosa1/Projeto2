package com.example.proj2ui.Managers;

import java.math.BigInteger;

public class SessionInfo {
    private static BigInteger adminId;

    public static BigInteger getAdminId() {
        return adminId;
    }
    public static void setAdminId(BigInteger adminId) {
        SessionInfo.adminId = adminId;
    }

}

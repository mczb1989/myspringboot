package com.zb;

import com.zb.commom.JwtToken;

/**
 * Created by zhangbin on 2018/8/8.
 */
public class JwtTokenTest {
    public static void main(String args[]){
        try {
            String token = JwtToken.createToken(1, "1");
            System.out.println(token);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            JwtToken.verifyToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJvcmciOiJkZXZlbG9wdmVyIiwibmFtZSI6InpoYW5nYmluIiwiZXhwIjoxNTMzNzExNTU2LCJpYXQiOjE1MzM3MTE0OTYsImFnZSI6IjI5In0.0OL5Xw66PtZmNx1qC_P4m84iRZCEBOUPvXr-kAHHGko");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

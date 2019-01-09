<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        <form method="GET" action="verificationMethod.htm">      
            <!--                                                  ^^^    deep second controller !! -->
            <div><h3>Welcome to login</h3>
                <div> <input type="text" name="usernameInput"  placeholder="username" alt="Enter your username"  required/></div>
                <div> <input  type="password" name="passwordInput"  placeholder="password" alt="Enter your password"  required/></div>
                <div>I accept the terms of use<input type="checkbox" value="Accept" required></div>
                <input type="submit" value="login">
            </div>
        </form>
    </body>
</html>

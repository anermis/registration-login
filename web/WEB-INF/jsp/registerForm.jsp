<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <script>
            function checkPass() {

                var get_elem = document.getElementById,
                        pass1 = document.getElementById('password'),
                        pass2 = document.getElementById('password2'),
                        message = document.getElementById('confirmMessage'),
                        colors = {
                            goodColor: "#fff",
                            goodColored: "#087a08",
                            badColor: "#fff",
                            badColored: "#ed0b0b"
                        },
                        strings = {
                            "confirmMessage": ["correct", " username and  password must be 5 or more charachters  "]
                        };

                if ((password.value === password2.value) && (username.value.length > 4) && (password.value.length > 4)) {
                    password2.style.backgroundColor = colors["goodColor"];
                    message.style.color = colors["goodColored"];
                    message.innerHTML = strings["confirmMessage"][0];
                    document.getElementById('submit').disabled = false;
                } else {
                    password2.style.backgroundColor = colors["badColor"];
                    message.style.color = colors["badColored"];
                    message.innerHTML = strings["confirmMessage"][1];
                    document.getElementById('submit').disabled = true;
                }
            }
        </script>                          
    </head>
    <body>
        <h3>Welcome to registration</h3>
        <form:form action="insertUserMethod.htm" modelAttribute="user" method="POST">
            <table>
                <tr>
                    <td><form:label path="userName" >username</form:label></td>
                    <td><form:input path="userName" placeholder="username" maxlength="100" id="username"/></td>
                </tr>
                <tr>
                    <td><form:label path="userPassword1">password</form:label></td>
                    <td><form:input path="userPassword1" placeholder="password" maxlength="100" id="password" type="password" onkeyup = "checkPass()"/></td>
                </tr>
                <tr>               
                    <td><form:label path="userPassword2">Re-enter your password</form:label></td>
                    <td><form:input path="userPassword2" placeholder="password" maxlength="100" id="password2" type="password" onkeyup = "checkPass()"/></td>
                    <td><span id="confirmMessage" class="confirmMessage"></span></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input id="submit" type="submit" value="submit" disabled/></td>                   
                </tr>
            </table>
        </form:form>
    </body>
</html>

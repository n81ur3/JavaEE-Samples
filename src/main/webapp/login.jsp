<html>
<head><title>Login Form</title></head>
<body>
    <h1>Login Form</h1>
    <form action='<%= response.encodeURL("j_security_check") %>' method="post">
        Username:
        <input type="text" name="j_username"/><br/>
        Password:
        <input type="password" name="j_password"/><br/>
        <input type="submit" value="Login" />
    </form>
</body>
</html>
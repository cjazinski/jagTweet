<html>
<head>
    <title>Sign into JagTweet</title>
    <meta name="layout" content="main">
</head>
<body>
    <h1>Sign in</h1>
    <g:if test="${flash.message}">
        <div class="flash">
            ${flash.message}
        </div>
    </g:if>
    <g:form action="signIn">
        <fieldset class="form">
            <div class="fieldcontain required">
                <label for="username">Login ID</label>
                <g:textField name="username" value="${username}" />
            </div>
            <div class="fieldcontain required">
                <label for="password">Password</label>
                <g:passwordField name="password"/>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="signIn" value="Sign in"/>
        </fieldset>
    </g:form>

</body>
</html>

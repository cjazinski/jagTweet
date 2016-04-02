<html>
<head>
    <title>Sign into JagTweet</title>
    <meta name="layout" content="main">
</head>
<body>
<div class="row columns small-12">
<g:if test="${flash.message}">
    <div class="alert callout" data-closable>
        ${flash.message}
        <button class="close-button" aria-label="Dismiss alert" type="button" data-close>
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</g:if>
</div>  
<div class="row column small-6 large-centered">
    <h1>Sign in</h1>
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
            <g:submitButton name="signIn" value="Sign in" class="expanded button"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>

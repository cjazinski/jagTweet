<!DOCTYPE html>
<html lang="en">
<head>
    <title>
        JagTweet &raquo; <g:layoutTitle default="Welcome" />
    </title>
    <meta charset="UTF-8" />
    <asset:stylesheet href="application.css" />
    <asset:javascript src="application.js" />
    <g:layoutHead />
</head>
<body>
    <div>
        <header>
            <asset:image src="headerlogo.png" alt="logo" />
        </header>
        <main>
            <g:layoutBody />
        </main>
        <footer>
            <div id="footerText">Hubbub - Social Networking on Grails</div>
            Version <g:meta name="app.version"/>
            on Grails <g:meta name="app.grails.version"/>
        </footer>
    </div>
</body>
</html>
<html>
<head>
	<title>Search JagTweet</title>
	<meta name="layout" content="main" />
</head>
<body>
	<formset>
		<legend>Search for Friends...</legend>
		<g:form action="results">
			<label for="username">Username</label>
			<g:textField name="username" id="username" />
			<g:submitButton name="search" value="Search" />
		</g:form>
	</formset>
</body>
</html>
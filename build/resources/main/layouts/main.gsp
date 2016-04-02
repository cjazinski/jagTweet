<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<title>
        JagTweet &raquo; <g:layoutTitle default="Welcome" />
    </title>
    <asset:stylesheet href="application.css" />
    <asset:javascript src="application.js" />
    <g:layoutHead />	
</head>
<body>

<header>
	<a href="/">
		<asset:image src="headerLogoSTC.png" alt="logo" />
	</a>
</header>
 
<div class="stc-top-bar">
	<div class="top-bar-left">
		<ul class="menu">
			<li>
				<a href="/">Home</a>
			</li>
		</ul>
	</div>
	<div class="top-bar-right">
		<ul class="menu">
			<li>
				<g:link controller="post" action="personal">My Profile</g:link>
			</li>
			<!-- Login/Logout -->
        	<g:if test="${session.user}">
        		<li>
        			<g:link controller="login" action="logOut">Logout</g:link>
        		</li>
        	</g:if>
        	<g:else>
        	 	<li>
        			<g:link controller="login" action="form">Login</g:link>
        		</li>
        	</g:else>
		</ul>
	</div>
</div>

<main>
<div class="row">
	<div class="medium-8 columns" id="content">
		<g:layoutBody />
	</div>

	<div class="medium-3 columns" data-sticky-container>
		<div class="sticky" data-sticky data-anchor="content">
			<h4>Categories</h4>
			<ul>
				<li><a href="#">Sam</a></li>
				<li><a href="#">Jesse</a></li>
				<li><a href="#">Mike</a></li>
				<li><a href="#">Holly</a></li>
			</ul>
			<h4>Authors</h4>
			<ul>
				<li><a href="#">Sam</a></li>
				<li><a href="#">Jesse</a></li>
				<li><a href="#">Mike</a></li>
				<li><a href="#">Holly</a></li>
			</ul>
		</div>
	</div>
</div>
</main> <!-- End row -->
 
<footer class="row column">
	<ul>
		<li>
			<a href="#">About STC</a> |
		</li>
		<li>
			<a href="#">Evidence of Excellence</a> |
		</li>
		<li>
			<a href="#">Human Resources</a> |
		</li>
		<li>
			<a href="#">Campuses</a> |
		</li>
		<li>
			<a href="#">Faculty/Staff Directory</a> |
		</li>
		<li>
			<a href="#">Department Directory</a> |
		</li>
		<li>
			<a href="#">Contact</a> |
		</li>
		<li>
			<a href="#">Feedback</a>
		</li>
	</ul>
	&copy; 2016 - Chris | Version <g:meta name="app.version"/> | Grails <g:meta name="app.grails.version"/>
</footer>

<script>
    $(document).foundation();
</script>

</body>
</html>
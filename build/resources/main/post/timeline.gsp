<html>
<head>
	<title>Timeline for ${user.profile ? user.profile.fullName : user.username}</title>
	<meta name="layout" content="main" />
	<g:if test="${user.profile?.skin}">
		<asset:stylesheet href="${user.profile.skin}.css" />
	</g:if>
</head>
<body>
	<h1>
		Timeline for ${user.profile ? user.profile.fullName :user.username}
	</h1>
	<g:if test="${flash.message}">
		<div class="flash">
			${flash.message}
		</div>
	</g:if>
	<div id="newPost">
		<h3>
			What is ${user.profile.fullName} hacking on right now?
		</h3>
		<p>
			<g:form action="addPost" id="${user.username}">
				<g:textArea id="postContent" name="content" rows="3" cols="50" />
				<br />
				<g:submitButton name="post" value="Tweet O_0" />
			</g:form>
		</p>
	</div>
	<br />
    <div id="allPosts">
        <g:each in="${user.posts}" var="post">
            <div class="postEntry">
                <div class="postText">
                    ${post.content}
                </div>
            	<div class="postDate">
            		${post.dateCreated}
            	</div>
            </div>
        </g:each>
    </div>
</body>
</html>
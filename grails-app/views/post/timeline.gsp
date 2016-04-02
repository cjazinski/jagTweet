<html>
<head>
	<title>Timeline for ${user.profile ? user.profile.fullName : user.username}</title>
	<meta name="layout" content="main" />
	<g:if test="${user.profile?.skin}">
		<asset:stylesheet href="${user.profile.skin}.css" />
	</g:if>
</head>
<body>

<div class="row column small-12">
<g:if test="${flash.message}">
    <div class="alert callout" data-closable>
        ${flash.message}
        <button class="close-button" aria-label="Dismiss alert" type="button" data-close>
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</g:if>
</div>

<div class="row column small-12"> 
	<h1>
		Timeline for ${user.profile ? user.profile.fullName :user.username}
	</h1>
	<div id="newPost">
		<h3>
			What is ${user.profile.fullName} hacking on right now?
		</h3>
		<p>
			<g:form action="addPost" id="${user.username}">
				<g:textArea id="postContent" name="content" rows="3" cols="50" />
				<br />
				<g:submitButton name="post" value="Tweet O_0" class="button" />
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
</div>
</body>
</html>
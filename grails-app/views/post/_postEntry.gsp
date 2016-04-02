<div class="callout success">
	<div class="postAuthor">
		<g:link controller="post" action="timeline" id="${post.user.username}">
			${post.user.username}
		</g:link>
	</div>
    <div class="postText">${post.content}</div>
    <div class="postDate">
        <jagTweet:dateFromNow date="${post.dateCreated}"/>
    </div>
</div>
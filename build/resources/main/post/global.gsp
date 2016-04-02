<html>
    <head>
        <title>Global Timeline</title> 
        <meta name="layout" content="main"/>
<g:javascript>
    function clearPost(e) {
        $('#postContent').val('');
    }
    function showSpinner(visible) {
        if (visible) $('#spinner').show();
                else $('#spinner').hide();
    }
    function addTinyUrl(data) {
        var tinyUrl = data.urls.small;
        var postBox = $("#postContent")
        postBox.val(postBox.val() + tinyUrl);
        toggleTinyUrl();
        $("#tinyUrl input[name='fullUrl']").val('');
    }
    function toggleTinyUrl() {
        var toggleText = $('#showHideUrl');
        if ($('#tinyUrl').is(':visible')) {
            $('#tinyUrl').slideUp(300);
            toggleText.innerText = 'Hide TinyURL';
        } else {
            $('#tinyUrl').slideDown(300);
            toggleText.innerText = 'Show TinyURL';
        }
    }
</g:javascript>
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
    <h1>Global Timeline</h1>
        
    <g:if test="${session.user}">
        <div id="newPost">
            <h3>What is ${session.user.profile.fullName} hacking on right now?</h3>
            <p>
                <g:form>
                    <g:textArea id='postContent' name="content" rows="3" cols="50"/><br/>
                    <g:submitToRemote value="Post"
                         url="[controller: 'post', action: 'addPostAjax']"
                         update="allPosts"
                         onSuccess="clearPost(data)"
                         onLoading="showSpinner(true)"
                         onComplete="showSpinner(false)" />

                    <a href="#" id="showHideUrl" onclick="toggleTinyUrl(); return false;">
                        Show TinyURL
                    </a>
                    <asset:image src="spinner.gif" id="spinner" style="display:none;" />
                </g:form>

                <div id="tinyUrl" style="display:none;">
                      <g:formRemote name="tinyUrlForm" url="[action: 'tinyUrl']" onSuccess="addTinyUrl(data);">
                      TinyUrl: <g:textField name="fullUrl"/>
                      <g:submitButton name="submit" value="Make Tiny"/>
                   </g:formRemote>
                </div>
            </p>
        </div>
        </g:if>
        <br />
        <div id="allPosts">
            <g:render template="postEntry" collection="${posts}" var="post"/>
        </div>
        <g:paginate action="global" total="${postCount}" max="10" class="pagination"/>
</div>
    </body>
</html>
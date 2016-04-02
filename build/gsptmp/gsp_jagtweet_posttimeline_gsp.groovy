import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_jagTweet_posttimeline_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/post/timeline.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
printHtmlPart(2)
expressionOut.print(user.profile ? user.profile.fullName : user.username)
})
invokeTag('captureTitle','sitemesh',3,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',3,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
if(true && (user.profile?.skin)) {
printHtmlPart(3)
invokeTag('stylesheet','asset',6,['href':("${user.profile.skin}.css")],-1)
printHtmlPart(1)
}
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(user.profile ? user.profile.fullName :user.username)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(user.profile.fullName)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('textArea','g',24,['id':("postContent"),'name':("content"),'rows':("3"),'cols':("50")],-1)
printHtmlPart(12)
invokeTag('submitButton','g',26,['name':("post"),'value':("Tweet O_0"),'class':("button")],-1)
printHtmlPart(13)
})
invokeTag('form','g',27,['action':("addPost"),'id':(user.username)],2)
printHtmlPart(14)
for( post in (user.posts) ) {
printHtmlPart(15)
expressionOut.print(post.content)
printHtmlPart(16)
expressionOut.print(post.dateCreated)
printHtmlPart(17)
}
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',43,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1459559039000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}

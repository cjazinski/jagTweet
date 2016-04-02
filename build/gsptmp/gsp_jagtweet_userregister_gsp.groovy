import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_jagTweet_userregister_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/user/register.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',3,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',3,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',5,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('renderErrors','g',10,['bean':(user),'as':("list")],-1)
printHtmlPart(6)
})
invokeTag('hasErrors','g',12,[:],2)
printHtmlPart(1)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('textField','g',20,['name':("username"),'value':(user?.username)],-1)
printHtmlPart(10)
invokeTag('passwordField','g',24,['name':("password")],-1)
printHtmlPart(11)
invokeTag('textField','g',29,['name':("profile.fullName"),'value':(user?.profile?.fullName)],-1)
printHtmlPart(12)
invokeTag('textArea','g',34,['name':("profile.bio"),'value':(user?.profile?.bio)],-1)
printHtmlPart(13)
invokeTag('textField','g',39,['name':("profile.email"),'value':(user?.profile?.email)],-1)
printHtmlPart(14)
invokeTag('submitButton','g',43,['name':("register"),'value':("Register")],-1)
printHtmlPart(15)
})
invokeTag('form','g',45,['action':("register")],2)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',46,[:],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1459473586000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}

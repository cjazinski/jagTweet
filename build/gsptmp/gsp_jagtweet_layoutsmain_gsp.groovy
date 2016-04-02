import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_jagTweet_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
printHtmlPart(2)
invokeTag('layoutTitle','g',7,['default':("Welcome")],-1)
printHtmlPart(3)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
invokeTag('stylesheet','asset',9,['href':("application.css")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',10,['src':("application.js")],-1)
printHtmlPart(3)
invokeTag('layoutHead','g',11,[:],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('image','asset',17,['src':("headerLogoSTC.png"),'alt':("logo")],-1)
printHtmlPart(7)
createClosureForHtmlPart(8, 2)
invokeTag('link','g',32,['controller':("post"),'action':("personal")],2)
printHtmlPart(9)
if(true && (session.user)) {
printHtmlPart(10)
createClosureForHtmlPart(11, 3)
invokeTag('link','g',37,['controller':("login"),'action':("logOut")],3)
printHtmlPart(12)
}
else {
printHtmlPart(13)
createClosureForHtmlPart(14, 3)
invokeTag('link','g',42,['controller':("login"),'action':("form")],3)
printHtmlPart(12)
}
printHtmlPart(15)
invokeTag('layoutBody','g',52,[:],-1)
printHtmlPart(16)
invokeTag('meta','g',103,['name':("app.version")],-1)
printHtmlPart(17)
invokeTag('meta','g',103,['name':("app.grails.version")],-1)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',110,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1459560427000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}

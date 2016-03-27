import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_jagtweet_postglobal_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/post/global.gsp" }
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
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('javascript','g',30,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',31,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (session.user)) {
printHtmlPart(11)
expressionOut.print(session.user.profile.fullName)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
invokeTag('textArea','g',46,['id':("postContent"),'name':("content"),'rows':("3"),'cols':("50")],-1)
printHtmlPart(14)
invokeTag('submitToRemote','g',52,['value':("Post"),'url':([controller: 'post', action: 'addPostAjax']),'update':("allPosts"),'onSuccess':("clearPost(data)"),'onLoading':("showSpinner(true)"),'onComplete':("showSpinner(false)")],-1)
printHtmlPart(15)
invokeTag('image','asset',57,['src':("spinner.gif"),'id':("spinner"),'style':("display:none;")],-1)
printHtmlPart(16)
})
invokeTag('form','g',58,[:],3)
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('textField','g',62,['name':("fullUrl")],-1)
printHtmlPart(19)
invokeTag('submitButton','g',63,['name':("submit"),'value':("Make Tiny")],-1)
printHtmlPart(20)
})
invokeTag('formRemote','g',64,['name':("tinyUrlForm"),'url':([action: 'tinyUrl']),'onSuccess':("addTinyUrl(data);")],3)
printHtmlPart(21)
}
printHtmlPart(22)
invokeTag('render','g',71,['template':("postEntry"),'collection':(posts),'var':("post")],-1)
printHtmlPart(23)
invokeTag('paginate','g',73,['action':("global"),'total':(postCount),'max':("10")],-1)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1459048058000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://sakaiproject.org/jsf/sakai" prefix="sakai" %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<f:view>
<jsp:useBean id="msgs" class="org.sakaiproject.util.ResourceLoader" scope="session">
   <jsp:setProperty name="msgs" property="baseName" value="org.sakaiproject.tool.syllabus.bundle.Messages"/>
</jsp:useBean>

    <sakai:view_container title="#{msgs.title_template}">
        <sakai:view_content>
            <h:form id="templateForm">
                <h3>
                    <h:outputText value="#{msgs.title_template}" />
                </h3>
                <h:panelGrid columns="3" styleClass="jsfFormTable">
                    <h:panelGroup styleClass="shorttext required">
                        <h:outputLabel for="template">
                            <h:outputText value="*" styleClass="reqStar"/>
                            <h:outputText value="#{msgs.template}"/>
                        </h:outputLabel>
                        <sakai:button_bar>
                            <sakai:button_bar_item
                                action="" 
                                value="#{msgs.change}"/>
                            <sakai:button_bar_item
                                action="#{SyllabusTool.processTemplateSelectTemplateCancel}"
                                value="#{msgs.cancel}" 
                                accesskey="x" />
                        </sakai:button_bar>
                    </h:panelGroup>
                </h:panelGrid>
            </h:form>
        </sakai:view_content>
    </sakai:view_container>
</f:view>

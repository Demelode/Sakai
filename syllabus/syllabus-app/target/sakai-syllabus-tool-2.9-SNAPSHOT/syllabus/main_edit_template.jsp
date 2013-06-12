<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://sakaiproject.org/jsf/sakai" prefix="sakai" %>
<%@ taglib uri="http://sakaiproject.org/jsf/syllabus" prefix="syllabus" %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<f:view>

<jsp:useBean id="msgs" class="org.sakaiproject.util.ResourceLoader" scope="session">
   <jsp:setProperty name="msgs" property="baseName" value="org.sakaiproject.tool.syllabus.bundle.Messages"/>
</jsp:useBean>

    <sakai:view_container title="#{msgs.title_list}">
    <sakai:view_content>
        <h:form>
          <sakai:tool_bar>
          <%-- (gsilver) cannot pass a needed title attribute to these next items --%>
            <sakai:tool_bar_item
                action="#{SyllabusTool.processListNewTemplate}"
                    value="#{msgs.bar_new_template}" 
                rendered="#{SyllabusTool.editAble == 'true'}" />
            <sakai:tool_bar_item
                action="#{SyllabusTool.processTemplateUsingTemplate}"
                    value="#{msgs.template_using_template}" 
                rendered="#{SyllabusTool.editAble == 'true'}" />
          </sakai:tool_bar>
          <h:messages globalOnly="true" styleClass="alertMessage" rendered="#{!empty facesContext.maximumSeverity}" />
        </h:form>
    </sakai:view_content>
    </sakai:view_container>
</f:view>

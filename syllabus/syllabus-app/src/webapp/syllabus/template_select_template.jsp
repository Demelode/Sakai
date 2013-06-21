<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://sakaiproject.org/jsf/sakai" prefix="sakai" %>
<%@ taglib uri="http://sakaiproject.org/jsf/syllabus" prefix="syllabus" %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<f:view>

    <jsp:useBean id="msgs" class="org.sakaiproject.util.ResourceLoader" scope="session">
       <jsp:setProperty name="msgs" property="baseName" value="org.sakaiproject.tool.syllabus.bundle.Messages"/>
    </jsp:useBean>

    <sakai:view_container title="#{msgs.selecttempastemp}">
        <sakai:view_content>
            <h:form>
              <h:messages globalOnly="true" styleClass="alertMessage" rendered="#{!empty facesContext.maximumSeverity}" />
              <sakai:tool_bar_message value="#{msgs.selecttempastemp}" />

              <syllabus:syllabus_table value="#{SyllabusTool.templateEntries}" var="eachEntry" summary="#{msgs.mainEditListSummary}" styleClass="listHier lines nolines">
                
                <h:column rendered="#{! SyllabusTool.displayNoEntryMsg}">
                  <f:facet name="header">
                    <h:outputText value="#{msgs.template}" />
                  </f:facet>
                  <f:verbatim><h4 class="specialLink"></f:verbatim>               
                  <h:commandLink action="#{eachEntry.processListUseTemplateForTemplate}" title="#{msgs.goToItem} #{eachEntry.entry.title}">
                    <h:outputText value="#{eachEntry.entry.title}"/>
                  </h:commandLink>
                  <f:verbatim></h4></f:verbatim>
                </h:column>
            </syllabus:syllabus_table>
            <f:verbatim></p></f:verbatim>     
            </h:form>
        </sakai:view_content>
    </sakai:view_container>

</f:view>
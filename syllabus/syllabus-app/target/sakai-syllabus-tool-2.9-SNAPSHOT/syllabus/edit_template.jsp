<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://sakaiproject.org/jsf/sakai" prefix="sakai" %>
<%@ taglib uri="http://sakaiproject.org/jsf/syllabus" prefix="syllabus" %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<f:view>

<jsp:useBean id="msgs" class="org.sakaiproject.util.ResourceLoader" scope="session">
	<jsp:setProperty name="msgs" property="baseName" value="org.sakaiproject.tool.syllabus.bundle.Messages"/>
</jsp:useBean>

	<sakai:view_container title="#{msgs.title_edit}">
		<sakai:view_content>
			<h:outputText value="#{SyllabusTool.alertMessage}" styleClass="alertMessage" rendered="#{SyllabusTool.alertMessage != null}" />
			<h:messages styleClass="alertMessage" rendered="#{!empty facesContext.maximumSeverity}" />
			<h:form>
		  	<sakai:tool_bar_message value="#{msgs.template_header}" /> 
 			<sakai:doc_section>
 				<h:outputText value="#{msgs.newSyllabusForm1}"/>
 				<h:outputText value="*" styleClass="reqStarInline"/>
 				<h:outputText value="#{msgs.newSyllabusForm2}"/>
 			</sakai:doc_section>
 
 			<h:panelGrid columns="2" styleClass="jsfFormTable">
 				<h:panelGroup styleClass="shorttext required">
 					<h:outputText value="*" styleClass="reqStar"/>
 					
 					<h:outputLabel for="title">
 						<h:outputText value="#{msgs.template_title}"/>
 					</h:outputLabel>
 					<h:inputText value="#{SyllabusTool.syllabusDataTitle}" id="title"/>
 				</h:panelGroup>
 				<h:outputText value="#{msgs.empty_title_validate}" styleClass="alertMessage" rendered="#{SyllabusTool.displayTitleErroMsg}"/>
 			</h:panelGrid>
 
 			<div class="longtext">
 				<label for="" style="float:none;display:block">
 					<h:outputText value="#{msgs.syllabus_content}"/>
 				</label>
				<sakai:inputRichText textareaOnly="#{SyllabusTool.mobileSession}" rows="20" cols="120" id="syllabus_compose_edit" value="#{SyllabusTool.syllabusDataAsset}" />
			    <h:outputText value="#{msgs.empty_content_validate} #{SyllabusTool.evilTagMsg}" styleClass="alertMessage"  rendered="#{SyllabusTool.displayEvilTagMsg}"/>
 			</div>
				
			<sakai:button_bar>
				<sakai:button_bar_item
					action="#{SyllabusTool.processEditTemplatePost}"
					styleClass="active"
					value="#{msgs.save}" 
					accesskey="s"
					title="#{msgs.save}" />
				<sakai:button_bar_item
					action="#{SyllabusTool.processEditTemplateCancel}"
					value="#{msgs.cancel}" 
					accesskey="x"
					title="#{msgs.button_cancel}" />
			</sakai:button_bar>
		 </h:form>
		</sakai:view_content>
	</sakai:view_container>
</f:view> 

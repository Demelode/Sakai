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
                    
                        <syllabus:syllabus_table value="#{SyllabusTool.templateEntries}" var="eachEntry" summary="#{msgs.mainEditListSummary}" styleClass="listHier lines nolines">
                            
                            <h:column rendered="#{! SyllabusTool.displayNoEntryMsg}">
                              <f:facet name="header">
                                <h:outputText value="#{msgs.mainEditHeaderItem}" />
                              </f:facet>
                              <f:verbatim><h4 class="specialLink"></f:verbatim>               
                              <h:commandLink action="#{eachEntry.processListRead}" title="#{msgs.goToItem} #{eachEntry.entry.title}">
                                <h:outputText value="#{eachEntry.entry.title}"/>
                              </h:commandLink>
                              <f:verbatim></h4></f:verbatim>
                            </h:column>

                            <h:column rendered="#{! SyllabusTool.displayNoEntryMsg}">
                              <f:facet name="header">
                                <h:outputText value="" />
                              </f:facet>
                              <h:commandLink action="#{eachEntry.processUpMove}" style="text-decoration:none" title="#{msgs.mainEditLinkUpTitle}" rendered="#{SyllabusTool.editAble == 'true'}">
                                <h:graphicImage url="/syllabus/moveup.gif" alt="#{msgs.mainEditLinkUpTitle}" />
                                <h:outputText value="(#{eachEntry.entry.title})" styleClass="skip"/>
                              </h:commandLink>
                            </h:column>

                            <h:column rendered="#{! SyllabusTool.displayNoEntryMsg}">
                              <f:facet name="header">
                                <h:outputText value="" />
                              </f:facet>
                              <h:commandLink action="#{eachEntry.processDownMove}"  style="text-decoration:none" title="#{msgs.mainEditLinkDownTitle}" styleClass="imageLink" rendered="#{SyllabusTool.editAble == 'true'}">
                                <h:graphicImage url="/syllabus/movedown.gif" alt="#{msgs.mainEditLinkDownTitle}" />
                                <h:outputText value="(#{eachEntry.entry.title})" styleClass="skip"/>
                              </h:commandLink>
                            </h:column>

                            <h:column rendered="#{! SyllabusTool.displayNoEntryMsg}">
                              <f:facet name="header">
                                <h:outputText value="#{msgs.mainEditHeaderStatus}"/>
                              </f:facet>
                              <h:outputText value="#{eachEntry.status}"/>
                            </h:column>

                            <h:column rendered="#{! SyllabusTool.displayNoEntryMsg}">
                              <f:facet name="header">
                                <h:outputText value="#{msgs.mainEditHeaderRemove}"/>
                              </f:facet>
                              <h:selectBooleanCheckbox value="#{eachEntry.selected}" title="#{msgs.selectThisCheckBox}: (#{eachEntry.entry.title})"/>
                            </h:column>

                       </syllabus:syllabus_table>

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

package org.sakaiproject.api.app.syllabus;

import java.util.Set;

/**
 * @author <a href="mailto:demelode@gmail.com">Jon Demelo</a>
 * @version $id
 */
public interface SyllabusTemplate
{

  /**
   * @return Returns the syllabi template set.
   */
  public Set getTemplate();

  /**
   * @param template The syllabi template to set.
   */
  public void setTemplate(Set template);

  /**
   * @return Returns the Template content.
   */
  public String getTemplateContent();

  /**
   * @param content The Template content to set.
   */
  public void setTemplateContent(String content);

  /*
   * @return Returns the Template title.
   */
  public String getTemplateTitle();

  /**
   * @param title The Template title to set.
   */
  public void setTemplateTitle(String title);

  /**
   * @return Returns the contextId.
   */
  public String getContextId();

  /**
   * @param contextId The contextId to set.
   */
  public void setContextId(String contextId);

  /**
   * @return Returns the lockId.
   */
  public Integer getLockId();

  /**
   * @return Returns the surrogateKey.
   */
  public Long getSurrogateKey();

  /**
   * @return Returns the userId.
   */
  public String getUserId();

  /**
   * @param userId The userId to set.
   */
  public void setUserId(String userId);
}




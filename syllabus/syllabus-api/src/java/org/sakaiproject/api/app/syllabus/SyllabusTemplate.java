package org.sakaiproject.api.app.syllabus;

/**
 * @author <a href="mailto:demelode@gmail.com">Jon Demelo</a>
 * @version $id
 */
public interface SyllabusTemplate
{

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
   * @return Returns the position.
   */
  public Integer getPosition();

  /**
   * @param position The position to set.
   */
  public void setPosition(Integer position);

}
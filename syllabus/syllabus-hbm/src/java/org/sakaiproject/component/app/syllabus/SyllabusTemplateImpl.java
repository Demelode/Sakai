package org.sakaiproject.component.app.syllabus;

import org.sakaiproject.api.app.syllabus.SyllabusTemplate;

/**
 * A syllabus template contains information relating to a syllabus template and an order
 * within a particular context (site).
 * 
 * @author Jon Demelo
 * @version $Id: 
 * 
 */

public class SyllabusTemplateImpl implements SyllabusTemplate
{
  private Integer position;
  private String title;
  private String content;
  
  /**
   *  Public no-arg Constructor.
   */
  public SyllabusTemplateImpl(){
    
    ;
  } 

  /**
   * @return Returns the template title.
   */
  public String getTemplateTitle()
  {
    return title;
  }
  /**
   * @param syllabi The syllabi template title to set.
   */
  public void setTemplateTitle(String title)
  {
    this.title = title;
  }


  /**
   * @return Returns the template content.
   */
  public String getTemplateContent()
  {
    return content;
  }
  /**
   * @param syllabi The syllabi template content to set.
   */
  public void setTemplateContent(String content)
  {
    this.content = content;
  }


  /**
   * @return Returns the position.
   */
  public Integer getPosition()
  {
    return position;
  }
  /**
   * @param position The position to set.
   */
  public void setPosition(Integer position)
  {
    this.position = position;
  }  
  
  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  public boolean equals(Object obj)
  {
    if (this == obj) return true;
    if (!(obj instanceof SyllabusTemplateImpl)) return false;
    SyllabusTemplateImpl other = (SyllabusTemplateImpl) obj;

    if ((position == null ? other.position == null : position.equals(other.position))
        && (title == null ? other.title == null : title.equals(other.title)))
    {
      return true;
    }
    return false;
  }

  /**
   * @see java.lang.Object#toString()
   */
  public String toString()
  {
    StringBuilder sb = new StringBuilder(); 
    sb.append(", position=");
    sb.append(position);
    sb.append(", title=");
    sb.append(title);
    sb.append(", content=");
    sb.append(content);       
    sb.append("}");
    return sb.toString();
  }   
}
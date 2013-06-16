package org.sakaiproject.component.app.syllabus;

import org.sakaiproject.api.app.syllabus.SyllabusTemplate;

/**
 * A syllabus template contains information relating to a syllabus template.
 * 
 * @author Jon Demelo
 * @version $Id: 
 * 
 */

public class SyllabusTemplateImpl implements SyllabusTemplate
{
  private String title;
  private String content;

  private Long surrogateKey;
  private Integer posId;
  private Integer lockId; // optimistic lock

  public SyllabusTemplateImpl()
  {  
    ;
  }

  // public SyllabusTemplateImpl(String title, Integer posId, String content)
  // {

  //   if (posId == null || title == null)
  //   {
  //     throw new IllegalArgumentException();
  //   }
   
  //   this.posId = posId;

  //   this.title = title;
  //   this.content = content;
  // } 

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
   * @return Returns the posId.
   */
  public Integer getPosId()
  {
    return posId;
  }
  /**
   * @param posId The posId to set.
   */
  public void setPosId(Integer posId)
  {
    this.posId = posId;
  }  
  /**
   * @return Returns the lockId.
   */
  public Integer getLockId()
  {
    return lockId;
  }
  /**
   * @param lockId The lockId to set.
   */
  public void setLockId(Integer lockId)
  {
    this.lockId = lockId;
  }
  /**
   * @return Returns the surrogateKey.
   */
  public Long getSurrogateKey()
  {
    return surrogateKey;
  }
  /**
   * @param surrogateKey The surrogateKey to set.
   */
  public void setSurrogateKey(Long surrogateKey)
  {
    this.surrogateKey = surrogateKey;
  }  

  public boolean equals(Object obj)
  {
    if (this == obj) return true;
    if (!(obj instanceof SyllabusTemplateImpl)) return false;
    SyllabusTemplateImpl other = (SyllabusTemplateImpl) obj;

    if ((posId == null ? other.posId == null : posId.equals(other.posId))
        && (title == null ? other.title == null : title.equals(other.title)))
    {
      return true;
    }
    return false;
  }

  public int hashCode()
  {
    return posId.hashCode();
  }

  public String toString()
  {
  StringBuilder sb = new StringBuilder();
    sb.append("{surrogateKey=");
    sb.append(surrogateKey); 
    sb.append(", posId=");
    sb.append(posId);
    sb.append(", title=");
    sb.append(title);
    sb.append(", content=");
    sb.append(content);      
    sb.append(", lockId=");
    sb.append(lockId);
    sb.append("}");
    return sb.toString();
  } 
 
}